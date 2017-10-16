package tourdreams.com.br;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ForkJoinPool;

public class    DetalhesProduto extends AppCompatActivity {

    ListView list_view_caracteristicas1, list_view_caracteristicas2, list_view_comentarios;
    List<Caracteristicas> list_caracteristicas = new ArrayList<>();
    List<Caracteristicas> list_caracteristicas2 = new ArrayList<>();
    List<Comentarios> list_comentarios = new ArrayList<>();
    GridView grid_view_caracteristicas;

    String url, parametros;
    Integer id_produto_vem;

    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes_produto);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        context = this;

        id_produto_vem = getIntent().getExtras().getInt("id_produto");


        buscarProduto();


        grid_view_caracteristicas = (GridView) findViewById(R.id.grid_view_caracteristicas);
        buscarCaracteristicasProduto();



        list_view_comentarios = (ListView)findViewById(R.id.list_view_comentarios);
        list_comentarios.add(new Comentarios(R.drawable.plus, "Nicolas Guarino Santana"
                , "24/07/2000"
                , "'Ótimo hotel, um atendimento muito bem qualificado recomendo ele a todos que me perguntarem," +
                " sensacional o nivel do hotel, Obrigado TourDreams por mais um hotel belo'"));

        list_comentarios.add(new Comentarios(R.drawable.ic_directions_car_black_36dp, "Matheus Silva"
                , "12/03/2017"
                , "'Ótimo hotel, um atendimento muito bem qualificado recomendo ele a todos que me perguntarem," +
                " sensacional o nivel do hotel, Obrigado TourDreams por mais um hotel belo'"));

        ComentariosAdapter comentariosAdapter = new ComentariosAdapter(
                this,R.layout.list_item_comentarios, list_comentarios
        );
        list_view_comentarios.setAdapter(comentariosAdapter);

    }

    private void buscarCaracteristicasProduto() {
        ConnectivityManager connMgr = (ConnectivityManager)this.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()){

            url =  this.getString(R.string.link)+"detalhes_produto.php";

            parametros = "id_produto=" + id_produto_vem;

            new DetalhesProduto.preencher_produto().execute(url);

        }else{

            Toast.makeText(this, "Nenhuma Conexao foi detectada", Toast.LENGTH_LONG).show();
        }

    }

    private void buscarProduto() {

        ConnectivityManager connMgr = (ConnectivityManager)this.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()){

             url =  this.getString(R.string.link)+"detalhes_produto.php";

            parametros = "id_produto=" + id_produto_vem;

            new DetalhesProduto.preencher_produto().execute(url);

        }else{

            Toast.makeText(this, "Nenhuma Conexao foi detectada", Toast.LENGTH_LONG).show();
        }

    }

    private class preencher_produto extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... urls){


            return Conexao.postDados(urls[0], parametros);

        }

        // onPostExecute displays the results of the AsyncTask.
        @Override
        protected void onPostExecute(String resultado){
            Gson gson = new Gson();
            DetalhesProdutoGetSetter[] detalhesProduto = gson.fromJson(resultado, DetalhesProdutoGetSetter[].class);

            CollapsingToolbarLayout produto = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);

            TextView local_produto_selecionado = (TextView) findViewById(R.id.local_produto_selecionado);
            TextView preco_produto_selecionado = (TextView) findViewById(R.id.preco_produto_selecionado);





            try {
                URL url_foto = new URL("http://10.107.144.5/TourDreams/Parceiro/Arquivos/" +  detalhesProduto[0].getImg_produto());
                Bitmap image = BitmapFactory.decodeStream(url_foto.openConnection().getInputStream());
                Drawable d = new BitmapDrawable(getResources(), image);

                if (Build.VERSION.SDK_INT > 16) {
                    produto.setBackground(d);
                } else {
                    Toast.makeText(context, "Fodase seu celular velho", Toast.LENGTH_SHORT).show();
                }



            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }




            //produto.setBackgroundResource(getString(R.string.link_imagens)+ detalhesProduto[0].getImg_produto());
            //produto.setBackgroundResource();

            produto.setTitle(detalhesProduto[0].getNome());
            local_produto_selecionado.setText(detalhesProduto[0].getLocal());
            preco_produto_selecionado.setText(detalhesProduto[0].getPreco());








        }

    }


}

