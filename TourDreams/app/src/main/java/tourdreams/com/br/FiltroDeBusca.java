package tourdreams.com.br;

import android.content.Intent;
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

import com.yahoo.mobile.client.android.util.rangeseekbar.RangeSeekBar;

import java.util.ArrayList;
import java.util.List;

public class FiltroDeBusca extends AppCompatActivity {
    FiltroDeBusca context;
    String abc = "asdawd";
    MenuItem menuItem;
    Boolean imagem = false;

    GridView grid_filtro_caracteristicas;
    List<CaracteristicasFiltro> list_caracteristicas_filtro = new ArrayList<>();
    ArrayAdapter<CaracteristicasFiltro> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filtro_de_busca);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        context = this;



        RangeSeekBar<Integer> seekBar = new RangeSeekBar<Integer>(this);
        seekBar = (RangeSeekBar<Integer>) findViewById(R.id.rangeSeekbar);
        seekBar.setRangeValues(1 , 999);


        grid_filtro_caracteristicas = (GridView) findViewById(R.id.grid_filtro_caracteristicas);


        list_caracteristicas_filtro.add (new CaracteristicasFiltro(R.drawable.ic_attach_money_black_24dp, "Money Money"));
        list_caracteristicas_filtro.add (new CaracteristicasFiltro(R.drawable.ic_attach_money_black_24dp, "Money Money"));
        list_caracteristicas_filtro.add (new CaracteristicasFiltro(R.drawable.ic_attach_money_black_24dp, "Money Money"));
        list_caracteristicas_filtro.add (new CaracteristicasFiltro(R.drawable.ic_attach_money_black_24dp, "Money Money"));

        FiltroDeBuscaAdapter filtroDeBuscaAdapter = new FiltroDeBuscaAdapter(this, R.layout.caracteristicas_filtro, list_caracteristicas_filtro);
        grid_filtro_caracteristicas.setAdapter(filtroDeBuscaAdapter);


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
