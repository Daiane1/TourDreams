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
 * Created by 16165886 on 18/10/2017.
 */

class PromocesAdapter extends ArrayAdapter<ItensPromocoes> {
    int resource;
    Context context;
    public PromocesAdapter(Context context, int resource, List<ItensPromocoes> objects) {
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

        ItensPromocoes item = getItem(position); /*Pegando o item que está sendo carregado naquela posição */

        if (item != null) {

            ImageView img_produto = (ImageView) v.findViewById(R.id.img_produto_promocao);
            TextView nome_produto = (TextView) v.findViewById(R.id.nome_produto_promocao);
            TextView nome_local = (TextView) v.findViewById(R.id.nome_local_promocao);
            TextView descricao_produto = (TextView) v.findViewById(R.id.descricao_produto_promocao);
            TextView preco_produto = (TextView) v.findViewById(R.id.preco_produto_promocao);
            ImageView img_brinde = (ImageView) v.findViewById(R.id.imagem_brinde_promo);
            TextView qtd_milhas = (TextView) v.findViewById(R.id.qtd_milhas_promocao);



            String url = getContext().getString(R.string.link_imagens) + item.getImg_produto();
            Picasso.with(getContext())
                    .load(url)
                    .into(img_produto);


            //img_produto.setImageResource(Picasso.with(getContext()).load(item.getImg_produto()).into(img_produto));
            nome_produto.setText(item.getNome());
            nome_local.setText(item.getLocal());
            descricao_produto.setText(item.getDescricao());
            preco_produto.setText(item.getPreco());
            qtd_milhas.setText(item.getMilhas_necessarias());


            String url_brinde = getContext().getString(R.string.link_imagem_brinde) + item.getFoto_brinde();
            Picasso.with(getContext())
                    .load(url_brinde)
                    .into(img_brinde);
        }

        return v;
    }
}
