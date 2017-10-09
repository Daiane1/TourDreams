package tourdreams.com.br;

import android.app.DialogFragment;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by nicol on 07/10/2017.
 */

public class DialogClicarFoto extends DialogFragment{

    DialogFragment self;
    LinearLayout background_foto;
    TextView nome_foto_mensagem;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        self = this;

        View v = inflater.inflate(R.layout.dialog_image_mensagens, null);

        background_foto = (LinearLayout) v.findViewById(R.id.linear);
        nome_foto_mensagem = (TextView) v.findViewById(R.id.nome_click_foto_mensagem);


        String nome_pessoa_foto = definindo_nome_pessoa();

        definirImagem(nome_pessoa_foto);

        return v;
    }

    private String definindo_nome_pessoa() {
        Intent intent = getActivity().getIntent();
        String nome_pessoa_foto = intent.getStringExtra("nome_mensagens");
        nome_foto_mensagem.setText(nome_pessoa_foto);

        return  nome_pessoa_foto;
    }


    private void definirImagem(String nome_pessoa_foto) {

        if (nome_pessoa_foto.equals("Nicolas Guarino")) {
            background_foto.setBackgroundResource(R.drawable.nicolas);
        }else if (nome_pessoa_foto.equals("Matheus")){
            background_foto.setBackgroundResource(R.drawable.matheus);

        }else if (nome_pessoa_foto.equals("Tainá")){
            background_foto.setBackgroundResource(R.drawable.taina);

        }else if (nome_pessoa_foto.equals("Daiane")){
            background_foto.setBackgroundResource(R.drawable.daiane);

        }


    }

}


