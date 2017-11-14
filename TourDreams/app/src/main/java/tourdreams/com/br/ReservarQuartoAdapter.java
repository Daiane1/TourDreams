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
 * Created by 16165886 on 13/11/2017.
*/

class ReservarQuartoAdapter extends ArrayAdapter<ReservarQuartoGetSetter> {
    int resource;
    Context context;
    public ReservarQuartoAdapter(Context context, int resource, List<ReservarQuartoGetSetter> objects) {
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

        ReservarQuartoGetSetter item = getItem(position); /*Pegando o item que está sendo carregado naquela posição */

        if (item != null) {

            ImageView img_quarto_reserva = (ImageView) v.findViewById(R.id.img_quarto_reserva);
            TextView descricao_quarto_reserva = (TextView) v.findViewById(R.id.descricao_quarto_reserva);
            TextView preco_quarto_reserva = (TextView) v.findViewById(R.id.preco_quarto_reserva);
            TextView data_entrada = (TextView) v.findViewById(R.id.txt_checkin_quarto);
            TextView data_saida = (TextView) v.findViewById(R.id.txt_checkout_quarto);




            String url = getContext().getString(R.string.link_imagens) + item.getFoto_quarto();



            Picasso.with(getContext())
                    .load(url)
                    .into(img_quarto_reserva);


            //img_produto.setImageResource(Picasso.with(getContext()).load(item.getImg_produto()).into(img_produto));
            descricao_quarto_reserva.setText(item.getDescricao_quarto());
            preco_quarto_reserva.setText(item.getPreco_diaria());
            data_entrada.setText(item.getData_entrada());
            data_saida.setText(item.getData_saida());
        }

        return v;
    }
}
