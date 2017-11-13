package tourdreams.com.br;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ForkJoinPool;

public class    DetalhesProduto extends AppCompatActivity {

    ListView list_view_comentarios;
    List<Comentarios> list_comentarios = new ArrayList<>();

    List<Caracteristicas> list_caracteristicas = new ArrayList<>();

    GridView grid_view_caracteristicas;

    ArrayAdapter<Caracteristicas> adapter;

    ArrayAdapter<Comentarios> adapter_coment;

    String url, parametros, parametros_coment;
    Integer id_produto_vem;

    Button btn_reservar;
    static Date data_checkin, data_checkout;


    static TextView txt_checkin_detalhes;
    static TextView txt_checkout_detalhes;



    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes_produto);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        context = this;

        txt_checkin_detalhes = (TextView) findViewById(R.id.txt_checkin_detalhes);
        txt_checkout_detalhes = (TextView) findViewById(R.id.txt_checkout_detalhes);


        id_produto_vem = getIntent().getExtras().getInt("id_produto");


        buscarProduto();


        grid_view_caracteristicas = (GridView) findViewById(R.id.grid_view_caracteristicas);
        buscarCaracteristicasProduto();
        buscarAvaliacaoProduto();




        list_view_comentarios = (ListView)findViewById(R.id.list_view_comentarios);
        comentariosProduto();


        btn_reservar = (Button) findViewById(R.id.btn_reservar);

        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date data = new Date();
        Calendar  cal = Calendar.getInstance();
        cal.setTime(data);
        final Date data_atual = cal.getTime();
                /*
        try {
            data_checkin = formato.parse(txt_checkin_detalhes.getText().toString());
            data_checkout = formato.parse(txt_checkout_detalhes.getText().toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }*/





        btn_reservar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (txt_checkin_detalhes.getText().toString().equals("Selecione uma data") || txt_checkout_detalhes.getText().toString().equals("Selecione uma data")){
                    AlertDialog alertDialog = new AlertDialog.Builder(DetalhesProduto.this).create();

                    alertDialog.setTitle("Alerta");
                    alertDialog.setMessage("Por favor, selecione uma data");
                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                    alertDialog.show();
                } else if (data_checkout.before(data_checkin)){
                    AlertDialog alertDialog = new AlertDialog.Builder(DetalhesProduto.this).create();

                    alertDialog.setTitle("Alerta");
                    alertDialog.setMessage("Por favor, a data de CHECK-OUT precisa ser maior que a data de CHECK-IN");
                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                    alertDialog.show();
                }else if(data_checkin.before(data_atual) || data_checkout.before(data_atual) ){
                    AlertDialog alertDialog = new AlertDialog.Builder(DetalhesProduto.this).create();

                    alertDialog.setTitle("Alerta");
                    alertDialog.setMessage("Por favor, a data de Entrada ou Saída precisa ser maior do que do dia de hoje !");
                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                }else {
                    Intent intent = new Intent(DetalhesProduto.this, ReservarQuarto.class);
                    startActivity(intent);
                }
            }
        });

    }

    private void comentariosProduto() {
        ConnectivityManager connMgr = (ConnectivityManager)this.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()){

            url =  this.getString(R.string.link)+"comentario_produto.php";

            parametros_coment = "id_produto=" + id_produto_vem;

            new DetalhesProduto.preencher_comentarios().execute(url);

        }else{

            Toast.makeText(this, "Nenhuma Conexao foi detectada", Toast.LENGTH_LONG).show();
        }
    }

    public class preencher_comentarios extends AsyncTask<String , Void, String>{


        @Override
        protected String doInBackground(String... urls) {
            return  Conexao.postDados(urls[0], parametros_coment);
        }

        @Override
        protected void onPostExecute(String resultado_comentario) {
            Gson gson = new Gson();
            Comentarios[] comentariosProdutos = gson.fromJson(resultado_comentario, Comentarios[].class);

            for(int i = 0; i < comentariosProdutos.length;i++){

                list_comentarios.add(comentariosProdutos[i]);

            }

            adapter_coment = new ComentariosAdapter(
                    context,
                    R.layout.list_item_comentarios,
                    list_comentarios);


            list_view_comentarios.setAdapter(adapter_coment);

        }
    }

    private void buscarAvaliacaoProduto() {
        ConnectivityManager connMgr = (ConnectivityManager)this.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()){

            url =  this.getString(R.string.link)+"detalhes_avaliacao_produto.php";

            parametros = "id_produto=" + id_produto_vem;

            new DetalhesProduto.preencher_avaliacoes().execute(url);

        }else{

            Toast.makeText(this, "Nenhuma Conexao foi detectada", Toast.LENGTH_LONG).show();
        }
    }

    public class preencher_avaliacoes extends  AsyncTask<String, Void, String>{

        @Override
        protected String doInBackground(String... urls) {
            return  Conexao.postDados(urls[0], parametros);
        }

        @Override
        protected void onPostExecute(String resultado_avaliacao) {
            Gson gson = new Gson();
            MediaAvaliacao[] media_detalhes_produto = gson.fromJson(resultado_avaliacao, MediaAvaliacao[].class);

            TextView limpeza = (TextView) findViewById(R.id.nota_limpeza);
            TextView restaurante = (TextView) findViewById(R.id.nota_restaurante);
            TextView atendimento = (TextView) findViewById(R.id.nota_atendimento);
            TextView lazer = (TextView) findViewById(R.id.nota_lazer);
            TextView media_geral = (TextView) findViewById(R.id.media_geral);

            RatingBar rating_bar = (RatingBar) findViewById(R.id.rating_bar);

            if (media_detalhes_produto[0].getMedia_geral().equals("N/A")){
                rating_bar.setRating(0);
            }else {
                rating_bar.setRating(Float.parseFloat(media_detalhes_produto[0].getMedia_geral()));
            }


            //rating_bar.getStepSize(Integer.parseInt(media_detalhes_produto[0].getMedia_geral()));
            limpeza.setText(media_detalhes_produto[0].getLimpeza());
            restaurante.setText(media_detalhes_produto[0].getRestaurante());
            atendimento.setText(media_detalhes_produto[0].getAtendimento());
            lazer.setText(media_detalhes_produto[0].getLazer());
            media_geral.setText(media_detalhes_produto[0].getMedia_geral());


        }
    }


    private void buscarCaracteristicasProduto() {
        ConnectivityManager connMgr = (ConnectivityManager)this.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()){

            url =  this.getString(R.string.link)+"detalhes_carac_produto.php";

            parametros = "id_produto=" + id_produto_vem;

            new DetalhesProduto.preencher_caracteristicas().execute(url);

        }else{

            Toast.makeText(this, "Nenhuma Conexao foi detectada", Toast.LENGTH_LONG).show();
        }

    }


    public class preencher_caracteristicas extends  AsyncTask<String, Void, String>{

        @Override
        protected String doInBackground(String... urls) {
            return Conexao.postDados(urls[0], parametros);
        }

        @Override
        protected void onPostExecute(String resultado_caracteristica) {
            Gson gson = new Gson();
            Caracteristicas[] carac_detalhes_produto = gson.fromJson(resultado_caracteristica, Caracteristicas[].class);


            for(int i = 0; i < carac_detalhes_produto.length;i++){

                list_caracteristicas.add(carac_detalhes_produto[i]);

            }

            adapter = new CaracteristicasAdapter(
                    context,
                    R.layout.list_item_caracteristicas,
                    list_caracteristicas);


            grid_view_caracteristicas.setAdapter(adapter);


        }
    }


    private void buscarProduto() {

        ConnectivityManager connMgr = (ConnectivityManager)this.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()){

             url =  this.getString(R.string.link)+"detalhes_produto.php";

            parametros = "id_produto=" + id_produto_vem;

            new DetalhesProduto.preencher_produto().execute(url);

        }else{

            Toast.makeText(this, "Nenhuma Conexao foi detectada", Toast.LENGTH_LONG).show();
        }

    }

    private class preencher_produto extends AsyncTask<String, Void, String> {

        Drawable d;

        DetalhesProdutoGetSetter[] detalhesProduto;

        @Override
        protected String doInBackground(String... urls){
            String retorno = Conexao.postDados(urls[0], parametros);
            Gson gson = new Gson();
           detalhesProduto = gson.fromJson(retorno, DetalhesProdutoGetSetter[].class);

            try {
                //URL url_foto = new URL("http://www.site.tourdreams.com/Parceiro/Arquivos/" +  detalhesProduto[0].getImg_produto());
                URL url_foto = new URL(getString(R.string.link_imagens) +  detalhesProduto[0].getImg_produto());
                Bitmap image = BitmapFactory.decodeStream(url_foto.openConnection().getInputStream());
                 d = new BitmapDrawable(getResources(), image);

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return  retorno;


        }

        // onPostExecute displays the results of the AsyncTask.
        @Override
        protected void onPostExecute(String resultado){


            CollapsingToolbarLayout produto = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);

            TextView local_produto_selecionado = (TextView) findViewById(R.id.local_produto_selecionado);
            TextView preco_produto_selecionado = (TextView) findViewById(R.id.preco_produto_selecionado);






                if (Build.VERSION.SDK_INT > 16) {
                    produto.setBackground(d);
                } else {
                    Toast.makeText(context, "Arruma um celular melhor", Toast.LENGTH_SHORT).show();
                }



            //produto.setBackgroundResource(getString(R.string.link_imagens)+ detalhesProduto[0].getImg_produto());
            //produto.setBackgroundResource();

            produto.setTitle(detalhesProduto[0].getNome());
            local_produto_selecionado.setText(detalhesProduto[0].getLocal());
            preco_produto_selecionado.setText(detalhesProduto[0].getPreco());








        }

    }

    public void calendario_checkin(View view) {
        //Abrir o calendario
        DialogFragment calendario = new DetalhesProduto.DatePickerFragment();
        calendario.show(getSupportFragmentManager(), "datepicker");
    }


    public void calendario_checkout(View view) {
        //Abrir o calendario
        DialogFragment calendario = new DetalhesProduto.DatePickerFragment_checkout();
        calendario.show(getSupportFragmentManager(), "datepicker");
    }

    public static class DatePickerFragment_checkout extends DialogFragment implements DatePickerDialog.OnDateSetListener {

        @NonNull
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {

            final Calendar c = Calendar.getInstance();

            int ano = c.get(Calendar.YEAR);
            int mes = c.get(Calendar.MONTH);
            int dia = c.get(Calendar.DAY_OF_MONTH);

            //Cria uma nova instancia de calendario e retorna
            return new DatePickerDialog(getActivity(), this, ano, mes, dia);
        }

        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            //função chamada após a escolha da data

            String dataSelecionada = String.format("%02d/%02d/%d",
                    dayOfMonth, ++month , year );
            data_checkout = new Date(year, ++month, dayOfMonth);


            txt_checkout_detalhes.setText(dataSelecionada);

        }
    }

    public static class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {

        @NonNull
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {

            final Calendar c = Calendar.getInstance();

            int ano = c.get(Calendar.YEAR);
            int mes = c.get(Calendar.MONTH);
            int dia = c.get(Calendar.DAY_OF_MONTH);

            //Cria uma nova instancia de calendario e retorna
            return new DatePickerDialog(getActivity(), this, ano, mes, dia);
        }

        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            //função chamada após a escolha da data

            String dataSelecionada = String.format("%02d/%02d/%d",
                    dayOfMonth, ++month , year );
            data_checkin = new Date(year, ++month, dayOfMonth);





            txt_checkin_detalhes.setText(dataSelecionada);

        }
    }



}

