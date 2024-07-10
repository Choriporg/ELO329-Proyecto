/**
 * La clase Carta representa un producto en el menú del restaurante.
 * Es una clase base para diferentes tipos de productos como bebestibles, entradas, plato de fondo y postres.
 */
public class Carta {
    protected int precioItem;
    protected String nombreItem;

    public int getPrecioItem() {
        return precioItem;
    }

    public String getNombreItem() {
        return nombreItem;
    }
}