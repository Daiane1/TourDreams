package tourdreams.com.br;

import android.app.DialogFragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 16165886 on 30/10/2017.
 */

class DialogLocal extends DialogFragment{

    DialogFragment self;
    ListView list_local_filtro;
    ArrayAdapter<String> adapter;
    ArrayList<String> data = new ArrayList<String>();
    Context context;
    int position;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        getDialog().setTitle("Mais Opções");

        self = this;
        context = getActivity();


        View v = inflater.inflate(R.layout.dialog_local, null);


        list_local_filtro = (ListView) v.findViewById(R.id.list_local_filtro);

        data.add("São Paulo");
        data.add("Rio de Janeiro");
        data.add("Bahia");
        data.add("Rio Grande Do Sul");
        data.add("Amazonas");
        data.add("Mato Grosso do Sul");
        data.add("Minas Gerais");
        data.add("Santa Catarina");
        data.add("Acre");
        data.add("Pernambuco");
        data.add("Espirito Santo");
        data.add("Paraná");
        data.add("Piauí");
        data.add("Alagoas");
        data.add("Brasília");
        data.add("Goiás");
        data.add("Rondonia");
        data.add("Roraima");
        data.add("Tocantins");
        data.add("Amapá");
        data.add("Sergipe");
        data.add("Mato Grosso");

        adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_single_choice, data);
        list_local_filtro.setAdapter(adapter);



        list_local_filtro.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                FiltroDeBusca.txt_localizacao.setText(data.get(position));
                dismiss();
            }
        });



        return v;



    }



}
