package tourdreams.com.br;

import android.app.DialogFragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by 16165886 on 03/10/2017.
 */

public class DialogMeuPerfil extends DialogFragment {

    DialogFragment self;
    TextView logar_perfil, nao_logar_perfil;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        getDialog().setTitle("Mais Opções");

        self = this;

        View v = inflater.inflate(R.layout.meu_perfil_dialog, null);

        logar_perfil = (TextView) v.findViewById(R.id.logar_perfil);
        nao_logar_perfil = (TextView) v.findViewById(R.id.nao_logar_perfil);

        logar_perfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Login.class);
                startActivity(intent);
            }
        });

        nao_logar_perfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                self.dismiss();
            }
        });




        return v;
    }
}
