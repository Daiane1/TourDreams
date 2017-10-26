package tourdreams.com.br;

/**
 * Created by 16165886 on 25/10/2017.
 */

class CaracteristicasFiltro {

    String nome_caracteristica;
    String foto_caracteristica;

    public CaracteristicasFiltro(String nome_caracteristica, String foto_caracteristica) {
        this.nome_caracteristica = nome_caracteristica;
        this.foto_caracteristica = foto_caracteristica;
    }

    public String getNome_caracteristica() {
        return nome_caracteristica;
    }

    public void setNome_caracteristica(String nome_caracteristica) {
        this.nome_caracteristica = nome_caracteristica;
    }

    public String getFoto_caracteristica() {
        return foto_caracteristica;
    }

    public void setFoto_caracteristica(String foto_caracteristica) {
        this.foto_caracteristica = foto_caracteristica;
    }
}
