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
 * Created by 16165886 on 25/10/2017.
 */
public class FiltroDeBuscaAdapter extends ArrayAdapter<CaracteristicasFiltro> {

    int resource;
    public FiltroDeBuscaAdapter(Context context, int resource, List<CaracteristicasFiltro> objects) {
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

        CaracteristicasFiltro item = getItem(position); /*Pegando o item que está sendo carregado naquela posição */

        if (item != null) {

            ImageView img_carac_filtro = (ImageView) v.findViewById(R.id.imagem_caracteristica_filtro);
            TextView nome_carac_filtro = (TextView) v.findViewById(R.id.texto_caracteristica_filtro);




            img_carac_filtro.setImageResource(item.getImagem());
            nome_carac_filtro.setText(item.getNome());

        }

        return v;
    }

}