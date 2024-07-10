/**
 * Subclase Postres que extiende de Carta.
 */
public class Postres extends Carta {
    private String tipoPostre;

    public Postres(String nombre, int precio, String tipoPostre) {
        this.nombreItem = nombre;
        this.precioItem = precio;
        this.tipoPostre = tipoPostre;
    }

    public String getTipoPostre() {
        return tipoPostre;
    }
}