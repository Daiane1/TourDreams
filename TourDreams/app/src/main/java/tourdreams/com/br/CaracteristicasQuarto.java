package tourdreams.com.br;

/**
 * Created by 16165886 on 13/11/2017.
 */

class CaracteristicasQuarto {
    private String caracteristicas_quarto, foto_caracteristicas;

    public CaracteristicasQuarto(String caracteristicas_quarto, String foto_caracteristicas) {
        this.caracteristicas_quarto = caracteristicas_quarto;
        this.foto_caracteristicas = foto_caracteristicas;
    }

    public String getCaracteristicas_quarto() {
        return caracteristicas_quarto;
    }

    public void setCaracteristicas_quarto(String caracteristicas_quarto) {
        this.caracteristicas_quarto = caracteristicas_quarto;
    }

    public String getFoto_caracteristicas() {
        return foto_caracteristicas;
    }

    public void setFoto_caracteristicas(String foto_caracteristicas) {
        this.foto_caracteristicas = foto_caracteristicas;
    }
}
