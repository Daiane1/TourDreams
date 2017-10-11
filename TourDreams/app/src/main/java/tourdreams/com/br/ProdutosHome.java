package tourdreams.com.br;

/**
 * Created by 16165886 on 25/09/2017.
 */

public class ProdutosHome {

    int  id_produto;
    String nome;
    String local;
    String descricao;
    String preco;
    String img_produto;

    public ProdutosHome(int id_produto, String nome, String local, String descricao, String preco, String img_produto) {
        this.id_produto = id_produto;
        this.nome = nome;
        this.local = local;
        this.descricao = descricao;
        this.preco = preco;
        this.img_produto = img_produto;
    }

    public String getImg_produto() {
        return img_produto;
    }

    public void setImg_produto(String img_produto) {
        this.img_produto = img_produto;
    }

    public int getId_produto() {
        return id_produto;
    }

    public void setId_produto(int id_produto) {
        this.id_produto = id_produto;
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
