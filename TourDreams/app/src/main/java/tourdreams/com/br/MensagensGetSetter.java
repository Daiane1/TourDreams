package tourdreams.com.br;

/**
 * Created by nicol on 06/10/2017.
 */

public class MensagensGetSetter  {
    int img_mensagens;
    String nome_mensagens;
    String hora_mensagens;
    String texto_mensagens;

    public MensagensGetSetter(int img_mensagens, String nome_mensagens, String hora_mensagens, String texto_mensagens) {
        this.img_mensagens = img_mensagens;
        this.nome_mensagens = nome_mensagens;
        this.hora_mensagens = hora_mensagens;
        this.texto_mensagens = texto_mensagens;
    }

    public int getImg_mensagens() {
        return img_mensagens;
    }

    public void setImg_mensagens(int img_mensagens) {
        this.img_mensagens = img_mensagens;
    }

    public String getNome_mensagens() {
        return nome_mensagens;
    }

    public void setNome_mensagens(String nome_mensagens) {
        this.nome_mensagens = nome_mensagens;
    }

    public String getHora_mensagens() {
        return hora_mensagens;
    }

    public void setHora_mensagens(String hora_mensagens) {
        this.hora_mensagens = hora_mensagens;
    }

    public String getTexto_mensagens() {
        return texto_mensagens;
    }

    public void setTexto_mensagens(String texto_mensagens) {
        this.texto_mensagens = texto_mensagens;
    }
}
