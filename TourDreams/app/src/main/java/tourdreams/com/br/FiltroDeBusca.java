package tourdreams.com.br;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.Toast;

import com.google.gson.Gson;
import com.yahoo.mobile.client.android.util.rangeseekbar.RangeSeekBar;

import java.util.ArrayList;
import java.util.List;

public class FiltroDeBusca extends AppCompatActivity {
    FiltroDeBusca context;
    String abc = "asdawd";
    MenuItem menuItem;
    Boolean imagem = false;
    String url, parametros;

    GridView grid_filtro_caracteristicas;
    //List<CaracteristicasFiltro> list_caracteristicas_filtro = new ArrayList<>();
    ArrayAdapter<CaracteristicasFiltro> adapter;
    List<CaracteristicasFiltro> list_filtros = new ArrayList<>();
    String o_que_o_cara_digitou;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filtro_de_busca);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        context = this;

        o_que_o_cara_digitou = getIntent().getExtras().getString("o_que_o_cara_digitou");

        buscarFiltros();

        RangeSeekBar<Integer> seekBar = new RangeSeekBar<Integer>(this);
        seekBar = (RangeSeekBar<Integer>) findViewById(R.id.rangeSeekbar);
        seekBar.setRangeValues(1 , 999);


        grid_filtro_caracteristicas = (GridView) findViewById(R.id.grid_filtro_caracteristicas);

        grid_filtro_caracteristicas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                CaracteristicasFiltro caracteristicasFiltro = adapter.getItem(position);



            }
        });






        seekBar.setOnRangeSeekBarChangeListener(new RangeSeekBar.OnRangeSeekBarChangeListener<Integer>() {
            @Override
            public void onRangeSeekBarValuesChanged(RangeSeekBar<?> bar, Integer minValue, Integer maxValue) {

            }



        });
        seekBar.setNotifyWhileDragging(true);


    }


    private void buscarFiltros() {
        ConnectivityManager connMgr = (ConnectivityManager)this.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()){

            url =  this.getString(R.string.link)+"filtros.php";

            parametros = "filtro_basico=" + o_que_o_cara_digitou;


            new FiltroDeBusca.Preencher_filtros().execute(url);

        }else{

            Toast.makeText(this, "Nenhuma Conexao foi detectada", Toast.LENGTH_LONG).show();
        }


    }


    public class Preencher_filtros extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... urls) {
            return Conexao.postDados(urls[0], parametros);
        }

        @Override
        protected void onPostExecute(String resultado) {
            Gson gson = new Gson();
            CaracteristicasFiltro[] filtros = gson.fromJson(resultado, CaracteristicasFiltro[].class);



            for(int i = 0; i < filtros.length;i++){

                list_filtros.add(filtros[i]);

            }


            adapter = new FiltroDeBuscaAdapter(
                    context,
                    R.layout.caracteristicas_filtro,
                    list_filtros);


            grid_filtro_caracteristicas.setAdapter(adapter);
        }
    }











    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.aceitar_filtro, menu);


        return true;
    }


    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        menu.findItem(R.id.aceitar).setVisible(true);

        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.aceitar) {

            Intent intent =  new Intent();
            intent.putExtra("teste", "TESTE");
            intent.putExtra("teste2", abc);
            context.setResult(RESULT_OK,intent);
            context.finish();

        }
        return super.onOptionsItemSelected(item);
    }


}
