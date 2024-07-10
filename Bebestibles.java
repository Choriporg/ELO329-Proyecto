/**
 * Subclase Bebestibles que extiende de Carta.
 */
public class Bebestibles extends Carta {
    private boolean tieneAlcohol;

    public Bebestibles(String nombre, int precio, boolean tieneAlcohol) {
        this.nombreItem = nombre;
        this.precioItem = precio;
        this.tieneAlcohol = tieneAlcohol;
    }

    public boolean isTieneAlcohol() {
        return tieneAlcohol;
    }
}