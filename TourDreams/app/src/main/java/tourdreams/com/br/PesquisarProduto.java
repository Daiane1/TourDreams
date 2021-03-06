package tourdreams.com.br;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.nfc.Tag;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.zip.Inflater;

public class PesquisarProduto extends AppCompatActivity {

    Context context;
    Integer codigo_tela_filtro = 1;

    MenuItem menuItem;
    String resultado_listener;
    String url, parametros, parametros_medios;

    String checkin_home, checkout_home, pesquisa_home ="";

    Boolean home = false;

    ArrayAdapter<ProdutosBusca> adapter;
    ArrayAdapter<ProdutosHome> adapter2;

    Integer id_produto;

    ListView list_view_produto_busca;
    List<ProdutosBusca> list_produto_busca = new ArrayList<>();
    SearchView.OnQueryTextListener listennerBusca= new SearchView.OnQueryTextListener() {
        @Override
        public boolean onQueryTextSubmit(String query) {

            resultado_listener = query;


            ConnectivityManager connMgr = (ConnectivityManager)getApplication().getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
            if (networkInfo != null && networkInfo.isConnected()){

                url =  getApplication().getString(R.string.link)+"busca_basica.php";

                parametros = "busca_basica=" + resultado_listener;


                new PesquisarProduto.Preencher_busca_basica().execute(url);

            }else{

                Toast.makeText(getApplicationContext(), "Nenhuma Conexao foi detectada", Toast.LENGTH_LONG).show();
            }

        


            menuItem.setVisible(true);
            return false;
        }

        @Override
        public boolean onQueryTextChange(String newText) {
            return false;
        }
    };

    private class Preencher_busca_basica extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... strings) {
            return Conexao.postDados(strings[0], parametros);
        }

        @Override
        protected void onPostExecute(String resultado) {


                Gson gson = new Gson();
                ProdutosBusca[] produtosBusca = gson.fromJson(resultado, ProdutosBusca[].class);
            if(!resultado.isEmpty()){
                adapter.clear();
                adapter.addAll(Arrays.asList(produtosBusca));
            }else{

                AlertDialog alertDialog = new AlertDialog.Builder(PesquisarProduto.this).create();

                alertDialog.setTitle("Desculpe,");
                alertDialog.setMessage("Não encontramos nenhum hotel disponível para esta data, por favor pesquise outros hotéis.");
                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                alertDialog.show();
            }


        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesquisar_produto);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        list_view_produto_busca = (ListView) findViewById(R.id.list_resultado_busca);

        list_view_produto_busca.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ProdutosBusca produtosBusca = adapter.getItem(position);

                id_produto = produtosBusca.getId_produto();

                Intent detalhesProduto =  new Intent(PesquisarProduto.this, DetalhesProduto.class);

                detalhesProduto.putExtra("id_produto", id_produto);


                startActivity(detalhesProduto);
            }
        });


        home = getIntent().getExtras().getBoolean("home");
        checkin_home  = getIntent().getExtras().getString("checkin_home");
        checkout_home  = getIntent().getExtras().getString("checkout_home");
        pesquisa_home = getIntent().getExtras().getString("pesquisa_home");

        context = this;

        if (home){

            ConnectivityManager connMgr = (ConnectivityManager)getApplication().getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
            if (networkInfo != null && networkInfo.isConnected()){

                url =  getApplication().getString(R.string.link)+"busca_media.php";

                parametros_medios = "localizacao=" + pesquisa_home + "&dt_entrada=" + checkin_home + "&dt_saida=" + checkout_home ;


                new PesquisarProduto.Preencher_busca_media().execute(url);
            }else{

                Toast.makeText(getApplicationContext(), "Nenhuma Conexao foi detectada", Toast.LENGTH_LONG).show();
            }
        }else {
            //Acabou
        }



        adapter = new ProdutosBuscaAdapter(
                context,
                R.layout.list_item_resultado_busca,
                new ArrayList<ProdutosBusca>());


        list_view_produto_busca.setAdapter(adapter);


    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);

        SearchView searchView = (SearchView) menu.findItem(R.id.busca).getActionView();

        searchView.setQueryHint("Pesquisar");
        searchView.setOnQueryTextListener(listennerBusca);
        searchView.requestFocus();




        return true;
    }


    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {

        menuItem = menu.findItem(R.id.filtro_busca);
        menuItem.setVisible(false);


        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.filtro_busca) {
            //DialogCaixa dialogCaixa = new DialogCaixa();
            //dialogCaixa.show(getFragmentManager(), "dialogCaixa");
            Intent intent =  new Intent(this, FiltroDeBusca.class);

            intent.putExtra("o_que_o_cara_digitou", resultado_listener);
            startActivityForResult(intent, codigo_tela_filtro);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == codigo_tela_filtro && resultCode == RESULT_OK){
            String teste = data.getStringExtra("teste");
            String teste2 = data.getStringExtra("min_value");
            Toast.makeText(context, teste2, Toast.LENGTH_SHORT).show();
        }

    }

    private class Preencher_busca_media extends AsyncTask<String, Void, String> {

        ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            progressDialog = ProgressDialog.show(context, "Aguarde...", "Estamos Buscando em nossa base de dados");;
        }

        @Override
        protected String doInBackground(String... strings) {
            return Conexao.postDados(strings[0], parametros_medios);
        }

        @Override
        protected void onPostExecute(String resultado2) {
                progressDialog.dismiss();


                Gson gson = new Gson();
                ProdutosBusca[] produtosBusca = gson.fromJson(resultado2, ProdutosBusca[].class);

            if(!resultado2.isEmpty()){
                adapter.clear();
                adapter.addAll(Arrays.asList(produtosBusca));
            }else{

                AlertDialog alertDialog = new AlertDialog.Builder(PesquisarProduto.this).create();

                alertDialog.setTitle("Desculpe,");
                alertDialog.setMessage("Não encontramos nenhum hotel disponível para esta data, por favor pesquise outros hotéis.");
                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                alertDialog.show();
            }





        }
    }
}
