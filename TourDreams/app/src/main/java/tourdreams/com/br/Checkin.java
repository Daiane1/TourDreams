package tourdreams.com.br;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;

/**
 * Created by nicol on 26/08/2017.
 */

public class Checkin extends AppCompatActivity {

    static TextView text_checkin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        text_checkin = (TextView) findViewById(R.id.text_checkin);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }


    public void abrirCalendario_checkin(View view) {

        //Abrir o calendario
        DialogFragment calendario = new DatePickerFragment();
        calendario.show(getSupportFragmentManager(), "datepicker");
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

}
