package tourdreams.com.br;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class FinalizarReserva extends AppCompatActivity {

    SharedPreferences preferences;

    String id_cliente, data_entrada, data_saida, cpf_cliente, celular_cliente, email_cliente, nome_cliente;

    TextView txt_cpf, txt_celular, txt_email, checkin_reserva, checkout_reserva, txt_nome_principal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finalizar_reserva);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        preferences = PreferenceManager.getDefaultSharedPreferences(this);

        data_entrada = getIntent().getExtras().getString("checkin_reserva");
        data_saida = getIntent().getExtras().getString("checkout_reserva");

        id_cliente = preferences.getString("id_cliente", "");
        cpf_cliente = preferences.getString("cpf_cliente","");
        email_cliente = preferences.getString("email_cliente", "");
        celular_cliente = preferences.getString("celular_cliente", "");
        nome_cliente = preferences.getString("nome_cliente", "");

        txt_cpf = (TextView) findViewById(R.id.txt_cpf);
        txt_celular = (TextView) findViewById(R.id.txt_celular);
        txt_email = (TextView) findViewById(R.id.txt_email);
        txt_nome_principal = (TextView) findViewById(R.id.txt_nome_principal);

        checkin_reserva = (TextView) findViewById(R.id.checkin_reserva);
        checkout_reserva = (TextView) findViewById(R.id.checkout_reserva);



        txt_cpf.setText(cpf_cliente);
        txt_email.setText(email_cliente);
        txt_celular.setText(celular_cliente);
        checkin_reserva.setText(data_entrada);
        checkout_reserva.setText(data_saida);
        txt_nome_principal.setText(nome_cliente);




    }

}
