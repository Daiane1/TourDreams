package tourdreams.com.br;

/**
 * Created by 16165891 on 19/09/2017.
 */

public class Caracteristicas {

    String imagem;
    String nome;

    public Caracteristicas(String imagem, String nome) {
        this.imagem = imagem;
        this.nome = nome;

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
}
