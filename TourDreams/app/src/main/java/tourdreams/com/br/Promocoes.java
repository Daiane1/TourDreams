package tourdreams.com.br;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class Promocoes extends AppCompatActivity {

    String url, parametros;
    List<ItensPromocoes> list_promocoes = new ArrayList<>();

    ArrayAdapter<ItensPromocoes> adapter;
    Context context;

    ListView list_view_promocoes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_promocoes);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        context = this;

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        list_view_promocoes = (ListView) findViewById(R.id.list_promocoes);
        carregarPromocoes();

    }


    private void carregarPromocoes() {

        ConnectivityManager connMgr = (ConnectivityManager)this.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()){

            url =  this.getString(R.string.link)+"produto_promocoes.php";

            parametros ="";


            new Promocoes.Preencher_promocoes().execute(url);

        }else{

            Toast.makeText(this, "Nenhuma Conexao foi detectada", Toast.LENGTH_LONG).show();
        }

    }


    private class Preencher_promocoes extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... urls){

            return Conexao.postDados(urls[0], parametros);

        }

        // onPostExecute displays the results of the AsyncTask.
        @Override
        protected void onPostExecute(String resultado){

            Gson gson = new Gson();
            ItensPromocoes[] itensPromocoes = gson.fromJson(resultado, ItensPromocoes[].class);



            for(int i = 0; i < itensPromocoes.length;i++){

                list_promocoes.add(itensPromocoes[i]);

            }

            adapter = new PromocesAdapter(
                    context,
                    R.layout.list_item_promocoes,
                    list_promocoes);


            list_view_promocoes.setAdapter(adapter);

        }

    }

}
