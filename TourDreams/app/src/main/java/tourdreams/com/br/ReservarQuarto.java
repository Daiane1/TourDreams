package tourdreams.com.br;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class ReservarQuarto extends AppCompatActivity {

    String url, parametros, data_entrada, data_saida, adultos, criancas;
    ListView list_view_quartos;

    List<ReservarQuartoGetSetter> list_quartos = new ArrayList<>();
    ArrayAdapter<ReservarQuartoGetSetter> adapter;
    Integer id_produto_vem, id_quarto;

    String checkin_reserva, checkout_reserva, valor_reserva;

    Context context;

    SharedPreferences preferences;

    String nome_cliente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservar_quarto);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        preferences = PreferenceManager.getDefaultSharedPreferences(this);

        id_produto_vem = getIntent().getExtras().getInt("id_produto_vai");

        data_entrada = getIntent().getExtras().getString("data_entrada");
        data_saida = getIntent().getExtras().getString("data_saida");
        adultos = getIntent().getExtras().getString("adultos");
        criancas = getIntent().getExtras().getString("criancas");

        list_view_quartos = (ListView) findViewById(R.id.list_view_quartos);

        nome_cliente = preferences.getString("nome_cliente", "");





        list_view_quartos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                ReservarQuartoGetSetter reservarQuartoGetSetter = adapter.getItem(position);

                id_quarto = reservarQuartoGetSetter.getId_quarto();
                valor_reserva = reservarQuartoGetSetter.getPreco_diaria();

                checkin_reserva = reservarQuartoGetSetter.getData_entrada();
                checkout_reserva = reservarQuartoGetSetter.getData_saida();

                if (nome_cliente.isEmpty()){
                    AlertDialog alertDialog = new AlertDialog.Builder(ReservarQuarto.this).create();

                    alertDialog.setTitle("Autenticação Necessária");
                    alertDialog.setMessage("Para finalizar sua reserva o usuário deve estar logado.");
                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "Fazer Login",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    Intent intent = new Intent(ReservarQuarto.this, Login.class);

                                    startActivity(intent);
                                }
                            });
                    alertDialog.show();
                }else {
                    Intent intent = new Intent(ReservarQuarto.this, FinalizarReserva.class);

                    intent.putExtra("checkin_reserva", checkin_reserva);
                    intent.putExtra("checkout_reserva", checkout_reserva);
                    intent.putExtra("id_quarto", id_quarto);
                    intent.putExtra("valor_reserva",valor_reserva);
                    intent.putExtra("adultos", adultos);
                    intent.putExtra("criancas", criancas);
                    startActivity(intent);
                }





            }
        });




        context = this;


        buscarProduto();


    }

   private void buscarProduto() {

        ConnectivityManager connMgr = (ConnectivityManager)this.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()){

            url =  this.getString(R.string.link)+"reservar_quarto.php";

            parametros = "id_produto=" + id_produto_vem + "&checkin=" + data_entrada + "&checkout=" + data_saida;

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


            list_view_quartos.setAdapter(adapter);

        }


    }




}
