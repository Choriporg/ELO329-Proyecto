/**
 * Subclase PlatoFondo que extiende de Carta.
 */
public class PlatoFondo extends Carta {
    private String tipoPlatoFondo;

    public PlatoFondo(String nombre, int precio, String tipoPlatoFondo) {
        this.nombreItem = nombre;
        this.precioItem = precio;
        this.tipoPlatoFondo = tipoPlatoFondo;
    }

    public String getTipoPlatoFondo() {
        return tipoPlatoFondo;
    }
}