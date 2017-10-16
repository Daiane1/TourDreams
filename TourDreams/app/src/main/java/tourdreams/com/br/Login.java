package tourdreams.com.br;

import android.content.Intent;
import android.preference.Preference;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class Login extends AppCompatActivity {

    EditText edit_email, edit_senha;
    Button btn_logar, btn_cadastrar;
    Context context = this;

    String url = "";
    String parametros = "";
    TextView nome_cliente_nav, email_cliente_nav;
    String id_cliente,milhas, nome_cliente, email_cliente, rg_cliente,cpf_cliente,senha_cliente,celular_cliente,foto_cliente;


    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edit_email = (EditText)findViewById(R.id.edit_email);
        edit_senha = (EditText)findViewById(R.id.edit_senha);
        btn_logar = (Button)findViewById(R.id.btn_logar);
        btn_cadastrar = (Button)findViewById(R.id.btn_cadastrar);

        getAplication();

        preferences = PreferenceManager.getDefaultSharedPreferences(this);



    }




    private void getAplication() {
        /*esqueci_senha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), MudarSenhaActivity.class);
                startActivity(intent);
            }
        });*/
        btn_logar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConnectivityManager connMgr = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
                if (networkInfo != null && networkInfo.isConnected()){

                    String email = edit_email.getText().toString();
                    String senha = edit_senha.getText().toString();

                    if(email.isEmpty() || senha.isEmpty()){
                        Toast.makeText(context, "Preencha todos os campos", Toast.LENGTH_LONG).show();

                    }else{

                        url =  context.getString(R.string.link)+"login.php";

                        parametros = "cpf=" + email +"&senha=" + senha;

                        new Login.SolicitaDados().execute(url);

                    }
                }else{
                    Snackbar.make(v, "Sem Conexão!", Snackbar.LENGTH_INDEFINITE)
                            .setAction("Fechar", new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent intent = new Intent(context, MainActivity.class);
                                            startActivity(intent);
                                        }
                                    }
                            ).show();

                }

            }
        });
    }




    private class SolicitaDados extends AsyncTask<String, Void, String> {

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

        // onPostExecute displays the results of the AsyncTask.
        @Override
        protected void onPostExecute(String resultado){


            progressDialog.dismiss();

            if(resultado.contains("login_ok")){

                String[] dados = resultado.split(",");

                Intent abreInicio = new Intent(context, MainActivity.class);

                preferences.edit().putString("id_cliente", dados[1]).commit();
                preferences.edit().putString("milhas", dados[2]).commit();
                preferences.edit().putString("nome_cliente", dados[3]).commit();
                preferences.edit().putString("rg_cliente", dados[4]).commit();
                preferences.edit().putString("cpf_cliente", dados[5]).commit();
                preferences.edit().putString("email_cliente", dados[6]).commit();
                preferences.edit().putString("senha_cliente", dados[7]).commit();
                preferences.edit().putString("celular_cliente", dados[8]).commit();
                preferences.edit().putString("foto_cliente", dados[9]).commit();
                preferences.edit().putString("dt_nasc", dados[10]).commit();


                startActivity(abreInicio);

            }else{

                Toast.makeText(context, "Usuário ou senha incorretos", Toast.LENGTH_LONG).show();

            }

        }

    }
}
