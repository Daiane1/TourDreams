package tourdreams.com.br;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by 16165886 on 25/09/2017.
 */

public class ProdutosHomeAdapter extends ArrayAdapter<ProdutosHome> {

    int resource;
    public ProdutosHomeAdapter(Context context, int resource, List<ProdutosHome> objects) {
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

        ProdutosHome item = getItem(position); /*Pegando o item que está sendo carregado naquela posição */

        if (item != null) {

            ImageView img_produto = (ImageView) v.findViewById(R.id.img_produto);
            TextView nome_produto = (TextView) v.findViewById(R.id.nome_produto);
            TextView nome_local = (TextView) v.findViewById(R.id.nome_local);
            TextView descricao_produto = (TextView) v.findViewById(R.id.descricao_produto);
            TextView preco_produto = (TextView) v.findViewById(R.id.preco_produto);



            img_produto.setImageResource(item.getImg_produto());
            nome_produto.setText(item.getNome());
            nome_local.setText(item.getLocal());
            descricao_produto.setText(item.getDescricao());
            preco_produto.setText(item.getPreco());
        }

        return v;
    }

}
