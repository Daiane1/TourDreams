package tourdreams.com.br;

/**
 * Created by 16165886 on 25/10/2017.
 */

class CaracteristicasFiltro {

    int imagem;
    String nome;

    public CaracteristicasFiltro(int imagem, String nome) {
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
