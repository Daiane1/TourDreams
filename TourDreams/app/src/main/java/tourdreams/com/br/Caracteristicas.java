package tourdreams.com.br;

/**
 * Created by 16165891 on 19/09/2017.
 */

public class Caracteristicas {

    int imagem;
    String nome;

    public Caracteristicas(int imagem, String nome) {
        this.imagem = imagem;
        this.nome = nome;

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
}
