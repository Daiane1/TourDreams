package tourdreams.com.br;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class DetalhesProduto extends AppCompatActivity {

    ListView list_view_caracteristicas1, list_view_caracteristicas2, list_view_comentarios;
    List<Caracteristicas> list_caracteristicas = new ArrayList<>();
    List<Caracteristicas> list_caracteristicas2 = new ArrayList<>();
    List<Comentarios> list_comentarios = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes_produto);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


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
        list_comentarios.add(new Comentarios(R.drawable.fotinha_azul, "Nicolas Guarino Santana", "24/07/2000", "ahdiawjdijawdjawd"));

        ComentariosAdapter comentariosAdapter = new ComentariosAdapter(
                this,R.layout.list_item_comentarios, list_comentarios
        );
        list_view_comentarios.setAdapter(comentariosAdapter);

}
}
