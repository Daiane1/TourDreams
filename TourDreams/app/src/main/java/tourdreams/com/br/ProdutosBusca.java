package tourdreams.com.br;

/**
 * Created by nicol on 07/10/2017.
 */

public class ProdutosBusca  {

    String img_produto_busca;
    int id_produto;
    String nome_produto_busca, local_produto_busca, nota_produto_busca, preco_produto_busca;

    public ProdutosBusca(String img_produto_busca, int id_produto, String nome_produto_busca, String local_produto_busca, String nota_produto_busca, String preco_produto_busca) {
        this.img_produto_busca = img_produto_busca;
        this.id_produto = id_produto;
        this.nome_produto_busca = nome_produto_busca;
        this.local_produto_busca = local_produto_busca;
        this.nota_produto_busca = nota_produto_busca;
        this.preco_produto_busca = preco_produto_busca;
    }

    public int getId_produto() {
        return id_produto;
    }

    public void setId_produto(int id_produto) {
        this.id_produto = id_produto;
    }

    public String getImg_produto_busca() {
        return img_produto_busca;
    }

    public void setImg_produto_busca(String img_produto_busca) {
        this.img_produto_busca = img_produto_busca;
    }

    public String getNome_produto_busca() {
        return nome_produto_busca;
    }

    public void setNome_produto_busca(String nome_produto_busca) {
        this.nome_produto_busca = nome_produto_busca;
    }

    public String getLocal_produto_busca() {
        return local_produto_busca;
    }

    public void setLocal_produto_busca(String local_produto_busca) {
        this.local_produto_busca = local_produto_busca;
    }

    public String getNota_produto_busca() {
        return nota_produto_busca;
    }

    public void setNota_produto_busca(String nota_produto_busca) {
        this.nota_produto_busca = nota_produto_busca;
    }

    public String getPreco_produto_busca() {
        return preco_produto_busca;
    }

    public void setPreco_produto_busca(String preco_produto_busca) {
        this.preco_produto_busca = preco_produto_busca;
    }
}
