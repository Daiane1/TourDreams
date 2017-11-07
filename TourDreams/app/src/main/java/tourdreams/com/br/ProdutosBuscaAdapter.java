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
 * Created by nicol on 07/10/2017.
 */

public class ProdutosBuscaAdapter extends ArrayAdapter<ProdutosBusca> {

    int resource;
    public ProdutosBuscaAdapter(Context context, int resource, List<ProdutosBusca> objects) {
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

        ProdutosBusca item = getItem(position); /*Pegando o item que está sendo carregado naquela posição */

        if (item != null) {

            ImageView img_produto = (ImageView) v.findViewById(R.id.img_produto_busca);
            TextView nome_produto = (TextView) v.findViewById(R.id.nome_produto_busca);
            TextView nome_local = (TextView) v.findViewById(R.id.local_produto_busca);
            TextView nota_produto = (TextView) v.findViewById(R.id.nota_produto_busca);
            TextView preco_produto = (TextView) v.findViewById(R.id.preco_produto_busca);

            String url = getContext().getString(R.string.link_imagens) + item.getImg_produto_busca() ;

            Picasso.with(getContext())
                    .load(url)
                    .into(img_produto);

            nome_produto.setText(item.getNome_produto_busca());
            nome_local.setText(item.getLocal_produto_busca());
            nota_produto.setText(item.getNota_produto_busca());
            preco_produto.setText(item.getPreco_produto_busca());
        }

        return v;
    }

}