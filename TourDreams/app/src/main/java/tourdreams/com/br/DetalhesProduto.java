package tourdreams.com.br;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ForkJoinPool;

public class    DetalhesProduto extends AppCompatActivity {

    ListView list_view_caracteristicas1, list_view_caracteristicas2, list_view_comentarios;
    List<Caracteristicas> list_caracteristicas = new ArrayList<>();
    List<Caracteristicas> list_caracteristicas2 = new ArrayList<>();
    List<Comentarios> list_comentarios = new ArrayList<>();

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



        list_view_caracteristicas1 = (ListView) findViewById(R.id.list_view_caracteristicas_1);

        list_caracteristicas.add(new Caracteristicas(R.drawable.ic_wifi_black_18dp, "Wi-fi"));
        list_caracteristicas.add(new Caracteristicas(R.drawable.ic_wifi_black_18dp, "Wi-fi"));
        list_caracteristicas.add(new Caracteristicas(R.drawable.ic_wifi_black_18dp, "Wi-fi"));
        list_caracteristicas.add(new Caracteristicas(R.drawable.ic_wifi_black_18dp, "Wi-fi"));



        // Montar o Adapter
        CaracteristicasAdapter adapter = new CaracteristicasAdapter(
                this,
                R.layout.list_item_caracteristicas,
                list_caracteristicas);

        list_view_caracteristicas1.setAdapter(adapter);



        list_view_caracteristicas2 = (ListView) findViewById(R.id.list_view_caracteristicas_2);

        list_caracteristicas2.add(new Caracteristicas(R.drawable.ic_spa_black_36dp, "Spa"));
        list_caracteristicas2.add(new Caracteristicas(R.drawable.ic_spa_black_36dp, "Spa"));
        list_caracteristicas2.add(new Caracteristicas(R.drawable.ic_spa_black_36dp, "Spa"));
        list_caracteristicas2.add(new Caracteristicas(R.drawable.ic_spa_black_36dp, "Spa"));

        CaracteristicasAdapter adapter2 = new CaracteristicasAdapter(
                this, R.layout.list_item_caracteristicas, list_caracteristicas2);
        list_view_caracteristicas2.setAdapter(adapter2);


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

            String image_produto = getString(R.string.link_imagens) + detalhesProduto[0].getImg_produto();

           /* Picasso.with(context)
                    .load(image_produto)
                    .into(setBackgroundResource(produto));*/


            String nome_produto = detalhesProduto[0].getNome();



        }

    }


}

