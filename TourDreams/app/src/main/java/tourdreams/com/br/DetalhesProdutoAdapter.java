package tourdreams.com.br;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.BaseTransientBottomBar;
import android.support.design.widget.CollapsingToolbarLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Toolbar;

import java.util.List;

/**
 * Created by 16165886 on 11/10/2017.
 */

public class DetalhesProdutoAdapter extends ArrayAdapter<DetalhesProdutoGetSetter>{

    int resource;
    Context context;
    public DetalhesProdutoAdapter(Context context, int resource, List<DetalhesProdutoGetSetter> objects) {
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

        DetalhesProdutoGetSetter item = getItem(position); /*Pegando o item que está sendo carregado naquela posição */

        if (item != null) {

            CollapsingToolbarLayout produto = (CollapsingToolbarLayout) v.findViewById(R.id.toolbar_layout);

            produto.setBackgroundResource(R.drawable.resort1);
            produto.setTitle("KARALHO SOU FODA");


            /*TextView nome_local = (TextView) v.findViewById(R.id.nome_local);
            TextView descricao_produto = (TextView) v.findViewById(R.id.descricao_produto);
            TextView preco_produto = (TextView) v.findViewById(R.id.preco_produto);


            String url =  "http://10.107.134.33/TourDreams/Parceiro/Arquivos/" + item.getImg_produto();

            Picasso.with(getContext())
                    .load(url)
                    .into(img_produto);


            //img_produto.setImageResource(Picasso.with(getContext()).load(item.getImg_produto()).into(img_produto));
            nome_produto.setText(item.getNome());
            nome_local.setText(item.getLocal());
            descricao_produto.setText(item.getDescricao());
            preco_produto.setText(item.getPreco());*/
        }

        return v;
    }

}
