package tourdreams.com.br;

/**
 * Created by 16165886 on 13/11/2017.
 */

public class ReservarQuartoGetSetter {
    private int id_quarto;
    private String descricao_quarto, preco_diaria, foto_quarto;

    private CaracteristicasQuarto[] caracteristicasQuartos;

    public ReservarQuartoGetSetter(int id_quarto, String descricao_quarto, String preco_diaria, String foto_quarto) {
        this.id_quarto = id_quarto;
        this.descricao_quarto = descricao_quarto;
        this.preco_diaria = preco_diaria;
        this.foto_quarto = foto_quarto;
    }

    public int getId_quarto() {
        return id_quarto;
    }

    public void setId_quarto(int id_quarto) {
        this.id_quarto = id_quarto;
    }

    public String getDescricao_quarto() {
        return descricao_quarto;
    }

    public void setDescricao_quarto(String descricao_quarto) {
        this.descricao_quarto = descricao_quarto;
    }

    public String getPreco_diaria() {
        return preco_diaria;
    }

    public void setPreco_diaria(String preco_diaria) {
        this.preco_diaria = preco_diaria;
    }

    public String getFoto_quarto() {
        return foto_quarto;
    }

    public void setFoto_quarto(String foto_quarto) {
        this.foto_quarto = foto_quarto;
    }

    public CaracteristicasQuarto[] getCaracteristicasQuartos() {
        return caracteristicasQuartos;
    }

    public void setCaracteristicasQuartos(CaracteristicasQuarto[] caracteristicasQuartos) {
        this.caracteristicasQuartos = caracteristicasQuartos;
    }
}
