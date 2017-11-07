package tourdreams.com.br;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v4.app.DialogFragment;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.NumberPicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    Context context;
    String parametros, url_foto = "", url="";

    static TextView text_checkin;
    static TextView text_checkout;
    Boolean usuariologado = false;
    int contagem = 1;
    ImageView adcionar_quartos_image;
    public static TextView text_quartos, text_adultos, text_criancas;
    ListView list_view_produto;
    List<ProdutosHome> list_produto = new ArrayList<>();
    ArrayAdapter<ProdutosHome> adapter;

    int id_produto;

    TextView nome_cliente_nav, email_cliente_nav;
    ImageView img_cliente_nav;
    String id_cliente,milhas, nome_cliente, email_cliente, rg_cliente,cpf_cliente,senha_cliente,celular_cliente,foto_cliente;

    SharedPreferences preferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        context = this;

        preferences = PreferenceManager.getDefaultSharedPreferences(this);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        View nav = navigationView.getHeaderView(0);

        text_checkin = (TextView) findViewById(R.id.text_checkin);
        text_checkout = (TextView) findViewById(R.id.text_checkout);
        adcionar_quartos_image = (ImageView) findViewById(R.id.adcionar_quartos_image);

        text_adultos = (TextView) findViewById(R.id.text_adultos);
        text_quartos = (TextView) findViewById(R.id.text_quartos);
        text_criancas = (TextView) findViewById(R.id.text_criancas);






        list_view_produto = (ListView) findViewById(R.id.list_view_produto);

        list_view_produto.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                ProdutosHome produtosHome = adapter.getItem(position);

                id_produto = produtosHome.getId_produto();

                Intent detalhesProduto =  new Intent(MainActivity.this, DetalhesProduto.class);

                detalhesProduto.putExtra("id_produto", id_produto);


                startActivity(detalhesProduto);

            }
        });


        nome_cliente_nav = (TextView) nav.findViewById(R.id.nome_cliente);
        email_cliente_nav = (TextView) nav.findViewById(R.id.email_cliente);
        img_cliente_nav = (ImageView) nav.findViewById(R.id.image_cliente_nav);


        nome_cliente = preferences.getString("nome_cliente", "");
        email_cliente = preferences.getString("email_cliente", "");
        foto_cliente = preferences.getString("foto_cliente", "");

        if (nome_cliente.isEmpty() && email_cliente.isEmpty()){
            email_cliente_nav.setText("O melhor portal de viagens");
            nome_cliente_nav.setText("TourDreams");

            Picasso.with(this).load(R.drawable.logo_tourdreams).resize(120,100).centerCrop().transform(new CircleTransform()).into(img_cliente_nav);

            carregarProdutos();

            MenuItem menu_perfil = (MenuItem) navigationView.getMenu().findItem(R.id.nav_meuperfil);
            menu_perfil.setVisible(false);

            MenuItem menu_mensagens = (MenuItem) navigationView.getMenu().findItem(R.id.nav_mensagens);
            menu_mensagens.setVisible(false);

        }else {
            email_cliente_nav.setText(email_cliente);
            nome_cliente_nav.setText(nome_cliente);

            String url_foto = this.getString(R.string.link_imagens) + foto_cliente;
            Picasso.with(this).load(url_foto).resize(120,100).transform(new CircleTransform()).into(img_cliente_nav);

            /*img_cliente_nav = ImagemRedonda.class.cast(findViewById(R.id.image_cliente_nav));
            img_cliente_nav.setBackgroundResource(R.drawable.jailson);

            */
            carregarProdutos();

            MenuItem n =(MenuItem) navigationView.getMenu().findItem(R.id.nav_logar);
            n.setTitle("Sair");
            n.setIcon(R.drawable.ic_sair);

            usuariologado = true;
        }
    }

    private void carregarProdutos() {

        ConnectivityManager connMgr = (ConnectivityManager)this.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()){

            url =  this.getString(R.string.link)+"listar_produtos_home.php";

            parametros ="";


            new MainActivity.Preencher_produtos().execute(url);

        }else{

            Toast.makeText(this, "Nenhuma Conexao foi detectada", Toast.LENGTH_LONG).show();
        }

    }



    private class Preencher_produtos extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... urls){

            return Conexao.postDados(urls[0], parametros);

        }

        // onPostExecute displays the results of the AsyncTask.
        @Override
        protected void onPostExecute(String resultado){
            Gson gson = new Gson();
            ProdutosHome[] produtosHome = gson.fromJson(resultado, ProdutosHome[].class);




            for(int i = 0; i < produtosHome.length;i++){

                list_produto.add(produtosHome[i]);

            }

            adapter = new ProdutosHomeAdapter(
                    context,
                    R.layout.list_item_produto,
                    list_produto);


            list_view_produto.setAdapter(adapter);

        }


    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }






    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_pginicial) {
            // Handle the camera action
        } else if (id == R.id.nav_meuperfil) {

        } else if (id == R.id.nav_promocoes) {

        } else if (id == R.id.nav_mensagens) {

        } else if (id == R.id.nav_buscar) {

        } else if (id == R.id.nav_logar) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void calendario_checkin(View view) {
            //Abrir o calendario
            DialogFragment calendario = new DatePickerFragment();
            calendario.show(getSupportFragmentManager(), "datepicker");
    }

    public void abrirDialog(View view) {

        DialogCaixa dialogCaixa = new DialogCaixa();
        dialogCaixa.show(getFragmentManager(), "dialogCaixa");
    }

    public void selecionar_hotel(View view) {
        Intent intent = new Intent(this, DetalhesProduto.class);
        startActivity(intent);
    }

    public void pagina_inicial(MenuItem item) {
        Intent intent = new Intent (this, MainActivity.class);
        startActivity(intent);
    }

    public void pesquisar_produto(MenuItem item) {
        Intent intent = new Intent(this, PesquisarProduto.class);
        startActivity(intent);
    }


    public void login(MenuItem item) {
        if(usuariologado){

            preferences.edit().putString("nome_cliente", "").commit();
            preferences.edit().putString("email_cliente", "").commit();

            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }else {

            Intent intent = new Intent(this, Login.class);
            startActivity(intent);
        }
    }

    public void meu_perfil(MenuItem item) {
            Intent intent = new Intent(this, MeuPerfil.class);
            startActivity(intent);
    }

    public void mensagens(MenuItem item) {
        Intent intent = new Intent(this, Mensagens.class);
        startActivity(intent);
    }

    public void promocoes(MenuItem item) {
        Intent intent = new Intent(this, Promocoes.class);
        startActivity(intent);
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




                text_checkin.setText(dataSelecionada);

            }
        }



    public void calendario_checkout(View view) {
        //Abrir o calendario
        DialogFragment calendario = new DatePickerFragment_checkout();
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


            text_checkout.setText(dataSelecionada);

        }
    }



}




