package tourdreams.com.br;

import android.content.Context;
import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;

import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

public class PesquisarProduto extends AppCompatActivity {

    Context context;
    Integer codigo_tela_filtro = 1;

    MenuItem menuItem;

    ListView list_view_produto_busca;
    List<ProdutosBusca> list_produto_busca = new ArrayList<>();
    SearchView.OnQueryTextListener listennerBusca= new SearchView.OnQueryTextListener() {
        @Override
        public boolean onQueryTextSubmit(String query) {

            menuItem.setVisible(true);
            return false;
        }

        @Override
        public boolean onQueryTextChange(String newText) {
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesquisar_produto);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        context = this;

        list_view_produto_busca = (ListView) findViewById(R.id.list_resultado_busca);

        list_produto_busca.add (new ProdutosBusca(R.drawable.alguma, "Olympia Residence", "Vila Olímpia, São Paulo - 7,3 km do centro", "4,5", "R$ 397,95"));
        list_produto_busca.add (new ProdutosBusca(R.drawable.sheraton, "Sheraton WTC Hotel", "Brooklin Novo, São Paulo - 9,1 km do centro", "4,0", "R$ 450,95"));
        list_produto_busca.add (new ProdutosBusca(R.drawable.hilton, "Hilton Morumbi", "Brooklin Novo, São Paulo - 9,3 km do centro", "4,7", "R$ 475,95"));
        list_produto_busca.add (new ProdutosBusca(R.drawable.gran, "Gran Estanplaza Berrini", "Brooklin Novo, São Paulo - 9,2 km do centro", "4,5", "R$ 350,95"));
        list_produto_busca.add (new ProdutosBusca(R.drawable.bourbon, "Bourbon Convention", "Moema, São Paulo - 7,3 km do centro", "4,9", "R$ 268,80"));

        ProdutosBuscaAdapter produtosBuscaAdapter = new ProdutosBuscaAdapter(this, R.layout.list_item_resultado_busca, list_produto_busca);
        list_view_produto_busca.setAdapter(produtosBuscaAdapter);



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

            startActivityForResult(intent, codigo_tela_filtro);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == codigo_tela_filtro && resultCode == RESULT_OK){
            String teste = data.getStringExtra("teste");
            Toast.makeText(context, teste, Toast.LENGTH_SHORT).show();
        }

    }
}
