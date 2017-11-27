package tourdreams.com.br;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Image;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class MeuPerfil extends AppCompatActivity {

    TextView telefone_numero_cliente, edit_email_cliente, edit_dt_nasc_cliente, edit_nome_cliente;
    TextView nome_cliente_header, email_cliente_header, txt_milhas;

    ImageView img_cliente;

    String id_cliente,milhas, nome_cliente, email_cliente, rg_cliente,cpf_cliente,senha_cliente,celular_cliente,foto_cliente, dt_nasc;
    SharedPreferences preferences;

    Button btn_acessar_reservas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meu_perfil);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        preferences = PreferenceManager.getDefaultSharedPreferences(this);

        id_cliente = preferences.getString("id_cliente", "");
        milhas = preferences.getString("milhas", "");
        nome_cliente = preferences.getString("nome_cliente", "");
        rg_cliente = preferences.getString("rg_cliente","");
        cpf_cliente = preferences.getString("cpf_cliente","");
        email_cliente = preferences.getString("email_cliente", "");
        senha_cliente = preferences.getString("senha_cliente", "");
        celular_cliente = preferences.getString("celular_cliente", "");
        foto_cliente = preferences.getString("foto_cliente", "");
        dt_nasc = preferences.getString("dt_nasc", "");

        telefone_numero_cliente = (TextView) findViewById(R.id.edit_telefone_cliente);
        edit_email_cliente = (TextView) findViewById(R.id.edit_email_cliente);
        edit_dt_nasc_cliente = (TextView) findViewById(R.id.edit_dt_nasc_cliente);
        edit_nome_cliente = (TextView) findViewById(R.id.edit_nome_cliente);
        img_cliente = (ImageView) findViewById(R.id.img_cliente);



        btn_acessar_reservas = (Button) findViewById(R.id.btn_acessar_reservas);


        String url_foto = this.getString(R.string.link_imagens) + foto_cliente;
        Picasso.with(this)
                .load(url_foto)
                .resize(80,80)
                .transform(new CircleTransform())
                .into(img_cliente);


        edit_nome_cliente.setText(nome_cliente);
        telefone_numero_cliente.setText(celular_cliente);
        edit_email_cliente.setText(email_cliente);
        edit_dt_nasc_cliente.setText(dt_nasc);

        btn_acessar_reservas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MeuPerfil.this, MinhasReservas.class);
                startActivity(intent);
            }

            });





    }

}
