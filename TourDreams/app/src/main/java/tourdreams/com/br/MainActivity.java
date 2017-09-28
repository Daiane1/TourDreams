package tourdreams.com.br;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
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

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    static TextView text_checkin;
    static TextView text_checkout;
    Boolean usuariologado = false;
    int contagem = 1;
    ImageView adcionar_quartos_image;
    public static TextView text_quartos, text_adultos, text_criancas;
    ListView list_view_produto;
    List<ProdutosHome> list_produto = new ArrayList<>();

    TextView nome_cliente_nav, email_cliente_nav;

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
        list_produto.add(new ProdutosHome(R.drawable.resort2, "Hotel casa verde", "São Paulo, Brasil", "R$ 339,99" , "Hotel bacana tem varias coisas legal pra caramba" +
                "faz varias coisas diferentes tem lugares legais, portaria bem legal, hotelzao demais comparado com os demais #TourDreams."));

        list_produto.add(new ProdutosHome(R.drawable.resort1, "Hotel Maradonna", "São Paulo, Brasil", "R$ 339,99" , "Hotel bacana tem varias coisas legal pra caramba" +
                "faz varias coisas diferentes tem lugares legais, portaria bem legal, hotelzao demais comparado com os demais #TourDreams."));

        list_produto.add(new ProdutosHome(R.drawable.resort3, "Hotel casa da Joana", "São Paulo, Brasil", "R$ 339,99" , "Hotel bacana tem varias coisas legal pra caramba" +
                "faz varias coisas diferentes tem lugares legais, portaria bem legal, hotelzao demais comparado com os demais #TourDreams."));

        ProdutosHomeAdapter produtosHomeAdapter = new ProdutosHomeAdapter(this, R.layout.list_item_produto, list_produto);
        list_view_produto.setAdapter(produtosHomeAdapter);
        list_view_produto.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(MainActivity.this, DetalhesProduto.class));
            }
        });


        nome_cliente_nav = (TextView) nav.findViewById(R.id.nome_cliente);
        email_cliente_nav = (TextView) nav.findViewById(R.id.email_cliente);

        nome_cliente = preferences.getString("nome_cliente", "");
        email_cliente = preferences.getString("email_cliente", "");

        if (nome_cliente.isEmpty() && email_cliente.isEmpty()){
            email_cliente_nav.setText("O melhor portal de viagens");
            nome_cliente_nav.setText("TourDreams");



        }else {
            email_cliente_nav.setText(email_cliente);
            nome_cliente_nav.setText(nome_cliente);

            usuariologado = true;

            MenuItem n =(MenuItem) navigationView.getMenu().findItem(R.id.nav_logar);
            n.setTitle("Sair");
            n.setIcon(R.drawable.ic_sair);
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

            preferences.edit().putString("id_cliente", "").commit();
            preferences.edit().putString("milhas", "").commit();
            preferences.edit().putString("nome_cliente", "").commit();
            preferences.edit().putString("rg_cliente", "").commit();
            preferences.edit().putString("cpf_cliente", "").commit();
            preferences.edit().putString("email_cliente", "").commit();
            preferences.edit().putString("senha_cliente", "").commit();
            preferences.edit().putString("celular_cliente", "").commit();
            preferences.edit().putString("foto_cliente", "").commit();

            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }else {
            Intent intent = new Intent(this, Login.class);
            startActivity(intent);

        }

    }




    public static class DatePickerFragment extends DialogFragment
                implements DatePickerDialog.OnDateSetListener
        {

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


    public static class DatePickerFragment_checkout extends DialogFragment
            implements DatePickerDialog.OnDateSetListener
    {

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




