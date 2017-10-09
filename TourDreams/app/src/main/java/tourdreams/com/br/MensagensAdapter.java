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
 * Created by nicol on 06/10/2017.
 */

public class MensagensAdapter extends ArrayAdapter<MensagensGetSetter>{

    int resource;
    public MensagensAdapter(Context context, int resource, List<MensagensGetSetter> objects) {
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

        MensagensGetSetter item = getItem(position); /*Pegando o item que está sendo carregado naquela posição */

        if (item != null) {



            TextView nome_mensagem = (TextView) v.findViewById(R.id.nome_mensagens);
            TextView hora_mensagem = (TextView) v.findViewById(R.id.hora_mensagens);
            TextView texto_mensagem = (TextView) v.findViewById(R.id.texto_mensagens);

            ImagemRedonda imagemRedonda = ImagemRedonda.class.cast(v.findViewById(R.id.img_mensagens));
            imagemRedonda.setImageResource(item.getImg_mensagens());

            nome_mensagem.setText(item.getNome_mensagens());
            hora_mensagem.setText(item.getHora_mensagens());
            texto_mensagem.setText(item.getTexto_mensagens());
        }

        return v;
    }

}
