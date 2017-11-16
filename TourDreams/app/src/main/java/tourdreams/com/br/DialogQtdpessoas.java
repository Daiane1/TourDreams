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
 * Created by 16165886 on 16/11/2017.
 */

public class DialogQtdpessoas extends DialogFragment {

    ImageView remover_quartos_image, adcionar_quartos_image,
            remover_adultos_image, adcionar_adultos_image,
            remover_criancas_image, adcionar_criancas_image;
    TextView text_quartos_dialog, text_adultos_dialog, text_criancas_dialog;

    int contagem_quartos = 1;
    int contagem_adultos = 1;
    int contagem_criancas = 0;

    Button aplicar_selecaoDt, desfazer_selecaoDt;


    DialogFragment self;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        getDialog().setTitle("Mais Opções");

        self = this;

        View v = inflater.inflate(R.layout.caixa_qtd_pessoas, null);


        adcionar_adultos_image= (ImageView) v.findViewById(R.id.adcionar_adultos_image_dt);
        remover_adultos_image = (ImageView) v.findViewById(R.id.remover_adultos_image_dt);

        adcionar_criancas_image = (ImageView) v.findViewById(R.id.adcionar_criancas_image_dt);
        remover_criancas_image = (ImageView) v.findViewById(R.id.remover_criancas_image_dt);

        text_adultos_dialog = (TextView) v.findViewById(R.id.count_adultos);
        text_criancas_dialog = (TextView) v.findViewById(R.id.count_criancas);

        aplicar_selecaoDt = (Button) v.findViewById(R.id.aplicar_selecaoDt);
        aplicar_selecaoDt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DetalhesProduto.txt_adulto_detalhes.setText(text_adultos_dialog.getText());
                DetalhesProduto.txt_crianca_detalhes.setText(text_criancas_dialog.getText());
                self.dismiss();
            }
        });

        desfazer_selecaoDt = (Button) v.findViewById(R.id.desfazer_selecaoDt);
        desfazer_selecaoDt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                self.dismiss();
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
