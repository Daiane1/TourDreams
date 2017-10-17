package tourdreams.com.br;

/**
 * Created by 16165891 on 19/09/2017.
 */

public class Comentarios {
    String imagem;
    String nome;
    String data;
    String comentario;
    String media;


    public Comentarios(String imagem, String nome, String data, String comentario, String media) {
        this.imagem = imagem;
        this.nome = nome;
        this.data = data;
        this.comentario = comentario;
        this.media = media;
    }

    public String getMedia() {
        return media;
    }

    public void setMedia(String media) {
        this.media = media;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
}
