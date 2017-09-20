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
 * Created by 16165891 on 19/09/2017.
 */

public class ComentariosAdapter extends ArrayAdapter<Comentarios> {

    int resource;
    public ComentariosAdapter(Context context, int resource, List<Comentarios> objects) {
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

        Comentarios item = getItem(position); /*Pegando o item que está sendo carregado naquela posição */

        if (item != null) {
            ImageView img_comentario = (ImageView) v.findViewById(R.id.img_comentario);
            TextView txt_comentario = (TextView) v.findViewById(R.id.nome_comentario);
            TextView nome_comentario = (TextView) v.findViewById(R.id.nome_comentario);
            TextView data_comentario = (TextView) v.findViewById(R.id.data_comentario);



            img_comentario.setImageResource(item.getImagem());
            txt_comentario.setText(item.getComentario());
            nome_comentario.setText(item.getNome());
            data_comentario.setText(item.getData());
        }

        return v;
    }

}
