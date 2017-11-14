package tourdreams.com.br;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MeuPerfil extends AppCompatActivity {

    EditText telefone_numero_cliente, edit_email_cliente, edit_dt_nasc_cliente, edit_nome_cliente;
    TextView nome_cliente_header, email_cliente_header, txt_milhas;

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

        rg_cliente = preferences.getString("rg_cliente","");
        cpf_cliente = preferences.getString("cpf_cliente","");
        email_cliente = preferences.getString("email_cliente", "");
        senha_cliente = preferences.getString("senha_cliente", "");
        celular_cliente = preferences.getString("celular_cliente", "");
        foto_cliente = preferences.getString("foto_cliente", "");
        dt_nasc = preferences.getString("dt_nasc", "");

        telefone_numero_cliente = (EditText) findViewById(R.id.edit_telefone_cliente);
        edit_email_cliente = (EditText) findViewById(R.id.edit_email_cliente);
        edit_dt_nasc_cliente = (EditText) findViewById(R.id.edit_dt_nasc_cliente);
        edit_nome_cliente = (EditText) findViewById(R.id.edit_nome_cliente);

        nome_cliente_header = (TextView) findViewById(R.id.nome_cliente_header);
        email_cliente_header = (TextView) findViewById(R.id.email_cliente_header);
        txt_milhas = (TextView) findViewById(R.id.txt_milhas);

        btn_acessar_reservas = (Button) findViewById(R.id.btn_acessar_reservas);



        nome_cliente_header.setText(nome_cliente);
        email_cliente_header.setText(email_cliente);
        txt_milhas.setText(milhas);
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
