package tourdreams.com.br;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by 16165886 on 30/10/2017.
 */

class LocalizacaoAdapter extends ArrayAdapter<FiltroLocal>{

    int resource;
    public LocalizacaoAdapter(Context context, int resource, List<FiltroLocal> objects) {
        super(context, resource, objects);
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;

        if (v == null) {
            v = LayoutInflater.from(getContext())
                    .inflate(resource,null);
            /* Resource é o layout do item da lista */
        }

        FiltroLocal item = getItem(position); /*Pegando o item que está sendo carregado naquela posição */

        if (item != null) {

            TextView text_local_filtro = (TextView) v.findViewById(R.id.text_local_filtro);


            text_local_filtro.setText(item.getLocalizacao());
        }

        return v;
    }
}
