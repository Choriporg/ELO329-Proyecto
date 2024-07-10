/**
 * Subclase Entradas que extiende de Carta.
 */
public class Entradas extends Carta {
    private String tipoEntrada;
    private boolean aptoVegetarianos;

    public Entradas(String nombre, int precio, String tipoEntrada, boolean aptoVegetarianos) {
        this.nombreItem = nombre;
        this.precioItem = precio;
        this.tipoEntrada = tipoEntrada;
        this.aptoVegetarianos = aptoVegetarianos;
    }

    public String getTipoEntrada() {
        return tipoEntrada;
    }

    public boolean isAptoVegetarianos() {
        return aptoVegetarianos;
    }
}