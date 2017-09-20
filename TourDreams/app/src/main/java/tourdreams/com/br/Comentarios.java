package tourdreams.com.br;

/**
 * Created by 16165891 on 19/09/2017.
 */

public class Comentarios {
    int imagem;
    String nome;
    String data;
    String comentario;


    public Comentarios(int imagem, String nome, String data, String comentario) {
        this.imagem = imagem;
        this.nome = nome;
        this.data = data;
        this.comentario = comentario;

    }


    public int getImagem() {
        return imagem;
    }

    public void setImagem(int imagem) {
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
