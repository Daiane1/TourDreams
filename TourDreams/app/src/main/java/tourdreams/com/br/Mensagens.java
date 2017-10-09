package tourdreams.com.br;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Mensagens extends AppCompatActivity {

    ListView list_view_mensagens;
    List<MensagensGetSetter> list_mensagens = new ArrayList<>();

    ImageView img_mensagens;
    TextView nome_mensagens, hora_mensagens, texto_mensagens;

    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mensagens);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        context = this;



        list_view_mensagens = (ListView) findViewById(R.id.list_view_mensagens);
        list_mensagens.add(new MensagensGetSetter(R.drawable.nicolas, "Nicolas Guarino", "22:16", "WhatsApp me contrata..."));
        list_mensagens.add(new MensagensGetSetter(R.drawable.daiane, "Daiane", "22:16", "Bagui ficou bom em"));
        list_mensagens.add(new MensagensGetSetter(R.drawable.matheus, "Matheus", "22:14", "Namoral, Ficou Daora demais"));
        list_mensagens.add(new MensagensGetSetter(R.drawable.taina, "Tainá", "22:13", "Quem é Whatsapp perto disso"));

        MensagensAdapter mensagensAdapter = new MensagensAdapter(this, R.layout.list_item_mensagens, list_mensagens);
        list_view_mensagens.setAdapter(mensagensAdapter);
        /*list_view_mensagens.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //startActivity(new Intent(MainActivity.this, DetalhesProduto.class));
                Integer posicao = position;
                Toast.makeText(context, "Posicao" + posicao , Toast.LENGTH_SHORT).show();
            }
        });*/




    }

    public void abrir_image_mensagens(View view) {

        DialogClicarFoto dialogClicarFoto = new DialogClicarFoto();
        dialogClicarFoto.show(getFragmentManager(), "dialogClicarFoto");

    }
}
