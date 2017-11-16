package tourdreams.com.br;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class FinalizarReserva extends AppCompatActivity {

    SharedPreferences preferences;

    Integer id_quarto;
    String id_cliente, data_entrada, data_saida, cpf_cliente, celular_cliente, email_cliente, nome_cliente, responsavel_edit, valor_reserva, id_adulto, id_crianca;

    String url, parametros;

    TextView txt_cpf, txt_celular, txt_email, checkin_reserva, checkout_reserva, txt_nome_principal;

    EditText edit_responsavel;

    Context context;

    Button btn_reservar_final;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finalizar_reserva);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        preferences = PreferenceManager.getDefaultSharedPreferences(this);
        context=this;

        data_entrada = getIntent().getExtras().getString("checkin_reserva");
        data_saida = getIntent().getExtras().getString("checkout_reserva");
        id_quarto = getIntent().getExtras().getInt("id_quarto");
        valor_reserva = getIntent().getExtras().getString("valor_reserva");

        id_adulto = getIntent().getExtras().getString("adultos");
        id_crianca = getIntent().getExtras().getString("criancas");

        if (id_crianca.equals("0")){
            id_crianca = "1";
        }else if (id_crianca.equals("1")){
            id_crianca = "2";
        }else if (id_crianca.equals("2")){
            id_crianca = "3";
        }

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

        edit_responsavel = (EditText) findViewById(R.id.edit_nome_cliente);

        btn_reservar_final = (Button) findViewById(R.id.btn_reservar_final);



        txt_cpf.setText(cpf_cliente);
        txt_email.setText(email_cliente);
        txt_celular.setText(celular_cliente);
        checkin_reserva.setText(data_entrada);
        checkout_reserva.setText(data_saida);
        txt_nome_principal.setText(nome_cliente);

        btn_reservar_final.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finalizarReserva();
            }
        });


    }

    private void finalizarReserva() {

        ConnectivityManager connMgr = (ConnectivityManager)this.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()){

            responsavel_edit = edit_responsavel.getText().toString();

            url = getString(R.string.link)+"enviar_reserva.php";

            parametros = "id_quarto=" + id_quarto +"&id_cliente=" + id_cliente +"&dt_entrada=" + data_entrada +"&dt_saida=" + data_saida
                    +"&nome_responsavel=" + responsavel_edit +"&id_adulto=" + id_adulto +"&id_crianca=" + id_crianca +"&valor_reserva=" + valor_reserva;

            new FinalizarReserva.SolicitaDados().execute(url);

        }else{
            Toast.makeText(this, "Nenhuma Conexao foi detectada", Toast.LENGTH_LONG).show();

        }

    }


    public class SolicitaDados extends AsyncTask<String, Void, String> {
        ProgressDialog progressDialog;
        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            progressDialog = ProgressDialog.show(context, "Aguarde...", "Estamos Trabalhando");

        }

        @Override
        protected String doInBackground(String... urls){


            return Conexao.postDados(urls[0], parametros);

        }

        @Override
        protected void onPostExecute(String s) {
            progressDialog.dismiss();

            AlertDialog alertDialog = new AlertDialog.Builder(FinalizarReserva.this).create();

            alertDialog.setTitle("Reserva efetuada com sucesso");
            alertDialog.setMessage("Para saber mais sobre sua reserva acesse:" +
                    "www.tourdreams.com.");
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "Obrigado",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent(FinalizarReserva.this, MainActivity.class);
                            /*String url = "www.site.tourdreams.com/registrar_user.php";
                            Intent i = new Intent(Intent.ACTION_VIEW);
                            i.setData(Uri.parse(url));*/
                            startActivity(intent);
                        }


                    });
            alertDialog.show();
        }
    }
}
