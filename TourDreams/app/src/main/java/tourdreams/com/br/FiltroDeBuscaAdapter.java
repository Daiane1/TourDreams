package tourdreams.com.br;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

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


    View.OnClickListener click_img = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            ImageView img =(ImageView) v;
            boolean ativo = (boolean) img.getTag();

            if (!ativo){
                img.setBackgroundResource(R.drawable.jailson);
                img.setTag(true);
            }else {
                img.setBackgroundResource(R.drawable.bolinha_filtro);
                img.setTag(false);

            }


        }
    };

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


            String url =  "http://10.107.144.5/TourDreams/CMS/Fotos_Mobile/" + item.getFoto_caracteristica();

            Picasso.with(getContext())
                    .load(url)
                    .into(img_carac_filtro);

            nome_carac_filtro.setText(item.getNome_caracteristica());

            img_carac_filtro.setOnClickListener(click_img);
            img_carac_filtro.setTag(false);

        }

        return v;
    }

}