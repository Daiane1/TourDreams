package tourdreams.com.br;

/**
 * Created by 16165886 on 18/10/2017.
 */

public class ItensPromocoes {

    int  id_produto;
    String nome;
    String local;
    String descricao;
    String preco;
    String img_produto;
    String milhas_necessarias;
    String foto_brinde;
    String nome_brinde;

    public ItensPromocoes(int id_produto, String nome, String local, String descricao, String preco, String img_produto, String milhas_necessarias, String foto_brinde, String nome_brinde) {
        this.id_produto = id_produto;
        this.nome = nome;
        this.local = local;
        this.descricao = descricao;
        this.preco = preco;
        this.img_produto = img_produto;
        this.milhas_necessarias = milhas_necessarias;
        this.foto_brinde = foto_brinde;
        this.nome_brinde = nome_brinde;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    public String getImg_produto() {
        return img_produto;
    }

    public void setImg_produto(String img_produto) {
        this.img_produto = img_produto;
    }

    public String getMilhas_necessarias() {
        return milhas_necessarias;
    }

    public void setMilhas_necessarias(String milhas_necessarias) {
        this.milhas_necessarias = milhas_necessarias;
    }

    public String getFoto_brinde() {
        return foto_brinde;
    }

    public void setFoto_brinde(String foto_brinde) {
        this.foto_brinde = foto_brinde;
    }

    public String getNome_brinde() {
        return nome_brinde;
    }

    public void setNome_brinde(String nome_brinde) {
        this.nome_brinde = nome_brinde;
    }
}
