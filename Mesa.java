/**
 * La clase Mesa representa una mesa en el restaurante.
 * Cada mesa tiene un número único, un estado de ocupación, y un pedido actual asignado.
 */
public class Mesa {
    private int numeroMesa;
    private boolean ocupada;
    private Pedido pedidoActual;

    public Mesa(int numero) {
        this.numeroMesa = numero;
        this.ocupada = false;
    }

    public void asignarPedido(Pedido pedido) {
        this.pedidoActual = pedido;
        this.ocupada = true;
    }

    public Pedido getPedidoActual() {
        return pedidoActual;
    }

    public boolean isOcupada() {
        return ocupada;
    }

    public int getNumeroMesa() {
        return numeroMesa;
    }

    public void liberarMesa() {
        this.ocupada = false;
        this.pedidoActual = null;
    }
}