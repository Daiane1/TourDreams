package tourdreams.com.br;

/**
 * Created by 16165886 on 25/09/2017.
 */

public class ProdutosHome {

    int img_produto;
    String nome;
    String local;
    String descricao;
    String preco;

    public ProdutosHome(int img_produto, String nome, String local, String preco, String descricao ) {
        this.img_produto = img_produto;
        this.nome = nome;
        this.local = local;
        this.preco = preco;
        this.descricao = descricao;

    }


    public int getImg_produto() {
        return img_produto;
    }

    public void setImg_produto(int img_produto) {
        this.img_produto = img_produto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }


    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
