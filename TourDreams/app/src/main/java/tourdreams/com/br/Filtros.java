package tourdreams.com.br;

/**
 * Created by 16165886 on 26/10/2017.
 */

public class Filtros {
    String nome_caracteristica, cidade, estado, pais, preco;

    public Filtros(String nome_caracteristica, String cidade, String estado, String pais, String preco) {
        this.nome_caracteristica = nome_caracteristica;
        this.cidade = cidade;
        this.estado = estado;
        this.pais = pais;
        this.preco = preco;
    }


    public String getNome_caracteristica() {
        return nome_caracteristica;
    }

    public void setNome_caracteristica(String nome_caracteristica) {
        this.nome_caracteristica = nome_caracteristica;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }
}
