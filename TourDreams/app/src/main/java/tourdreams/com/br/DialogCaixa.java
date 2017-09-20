package tourdreams.com.br;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by nicol on 29/08/2017.
 */

public class DialogCaixa extends DialogFragment {

    ImageView remover_quartos_image, adcionar_quartos_image,
            remover_adultos_image, adcionar_adultos_image,
            remover_criancas_image, adcionar_criancas_image;
    TextView text_quartos_dialog, text_adultos_dialog, text_criancas_dialog;

    int contagem_quartos = 1;
    int contagem_adultos = 1;
    int contagem_criancas = 0;

    Button aplicar_selecao, desfazer_selecao;


    DialogFragment self;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        getDialog().setTitle("Mais Opções");

        self = this;

        View v = inflater.inflate(R.layout.caixa_dialogo, null);

        adcionar_quartos_image = (ImageView) v.findViewById(R.id.adcionar_quartos_image);
        remover_quartos_image = (ImageView) v.findViewById(R.id.remover_quartos_image);

        adcionar_adultos_image= (ImageView) v.findViewById(R.id.adcionar_adultos_image);
        remover_adultos_image = (ImageView) v.findViewById(R.id.remover_adultos_image);

        adcionar_criancas_image = (ImageView) v.findViewById(R.id.adcionar_criancas_image);
        remover_criancas_image = (ImageView) v.findViewById(R.id.remover_criancas_image);

        text_quartos_dialog = (TextView) v.findViewById(R.id.text_quartos_dialog);
        text_adultos_dialog = (TextView) v.findViewById(R.id.text_adultos_dialog);
        text_criancas_dialog = (TextView) v.findViewById(R.id.text_criancas_dialog);

        aplicar_selecao = (Button) v.findViewById(R.id.aplicar_selecao);
        aplicar_selecao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.text_quartos.setText(text_quartos_dialog.getText());
                MainActivity.text_adultos.setText(text_adultos_dialog.getText());
                MainActivity.text_criancas.setText(text_criancas_dialog.getText());
                self.dismiss();
            }
        });

        desfazer_selecao = (Button) v.findViewById(R.id.desfazer_selecao);
        desfazer_selecao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                self.dismiss();
            }
        });

        adcionar_quartos_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adcionar_quartos();
                text_quartos_dialog.setText("" + contagem_quartos);
            }
        });

        remover_quartos_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                remover_quartos();
                text_quartos_dialog.setText("" + contagem_quartos);
            }
        });

        adcionar_adultos_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adcionar_adultos();
                text_adultos_dialog.setText("" + contagem_adultos);
            }
        });

        remover_adultos_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                remover_adultos();
                text_adultos_dialog.setText("" + contagem_adultos);
            }
        });

        adcionar_criancas_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adcionar_criancas();
                text_criancas_dialog.setText("" + contagem_criancas);

            }
        });

        remover_criancas_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                remover_criancas();
                text_criancas_dialog.setText("" + contagem_criancas);
            }
        });
        return v;
    }


    public void adcionar_quartos() {
        if(contagem_quartos >=3){
            contagem_quartos=1;
        }else {
            contagem_quartos++;
        }

    }

    public void remover_quartos() {

        if(contagem_quartos <=1){
            contagem_quartos=1;
        }else{
            contagem_quartos--;
        }


    }

    public void adcionar_adultos() {
        if(contagem_adultos >=3){
            contagem_adultos=0;
        }else {
            contagem_adultos++;
        }

    }

    public void remover_adultos() {
        if(contagem_adultos <=1){
            contagem_adultos=1;
        }else{
            contagem_adultos--;
        }

    }

    public void adcionar_criancas() {
        if(contagem_criancas >=2){
            contagem_criancas=0;
        }else {
            contagem_criancas++;
        }

    }

    public void remover_criancas() {
        if(contagem_criancas <=0){
            contagem_criancas=0;
        }else{
            contagem_criancas--;
        }

    }
}
