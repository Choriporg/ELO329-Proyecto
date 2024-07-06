public class Mesa {

    //Atributos
    private int numeroMesa;
    private Pedido orden;

    //Getters
    public int getNumeroMesa() {return numeroMesa;}
    public Pedido getOrden(){return orden;}

    //Métodos

    public void imprimirMesa(){
        System.out.println("\n\t\t>> Número de mesa: " + numeroMesa);
    }

    //Constructor
    public Mesa(int numeroMesa, int numeroPedido){
        this.numeroMesa = numeroMesa;
        this.orden = new Pedido(numeroPedido);
    }
}
