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
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class ReservarQuarto extends AppCompatActivity {

    String url, parametros;

    List<ReservarQuartoGetSetter> list_quartos = new ArrayList<>();
    ArrayAdapter<ReservarQuartoGetSetter> adapter;

    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservar_quarto);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        context = this;




    }

    private void buscarProduto() {

        ConnectivityManager connMgr = (ConnectivityManager)this.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()){

            url =  this.getString(R.string.link)+"detalhes_produto.php";

            parametros = "id_produto=" + id_produto_vem;

            new ReservarQuarto.preencher_quartos().execute(url);

        }else{

            Toast.makeText(this, "Nenhuma Conexao foi detectada", Toast.LENGTH_LONG).show();
        }

    }

    public class preencher_quartos extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... urls){

            return Conexao.postDados(urls[0], parametros);

        }

        // onPostExecute displays the results of the AsyncTask.
        @Override
        protected void onPostExecute(String resultado){
            Gson gson = new Gson();
            ReservarQuartoGetSetter[] reservarQuartoGetSetters = gson.fromJson(resultado, ReservarQuartoGetSetter[].class);

           for(int i = 0; i < reservarQuartoGetSetters.length;i++){

               list_quartos.add(reservarQuartoGetSetters[i]);

            }

            adapter = new ReservarQuartoAdapter(
                    context,
                    R.layout.list_item_quartos,
                    list_quartos);


            list_view_produto.setAdapter(adapter);

        }


    }
}
