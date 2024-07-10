import java.util.ArrayList;
import java.util.List;

/**
 * La clase Pedido representa un pedido en el restaurante.
 * Cada pedido contiene una lista de productos pedidos, un subtotal y una propina sugerida.
 */
public class Pedido {
    private List<Carta> productosPedidos;
    private int subtotal;
    private int propinaSugerida;

    public Pedido() {
        this.productosPedidos = new ArrayList<>();
        this.subtotal = 0;
    }

    public void agregarProducto(Carta producto) {
        this.productosPedidos.add(producto);
        recalcularSubtotal();
    }

    public void eliminarProducto(Carta producto) {
        this.productosPedidos.remove(producto);
        recalcularSubtotal();
    }

    private void recalcularSubtotal() {
        subtotal = productosPedidos.stream().mapToInt(Carta::getPrecioItem).sum();
        propinaSugerida = (int) (subtotal * 0.1);
    }

    public int getSubtotal() {
        return subtotal;
    }

    public int getPropinaSugerida() {
        return propinaSugerida;
    }

    public List<Carta> getProductosPedidos() {
        return productosPedidos;
    }
}