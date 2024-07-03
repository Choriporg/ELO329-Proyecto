public class Mesa {

    //Atributos
    private int numeroMesa;
    private Pedido orden;

    //Getters

    public int getNumeroMesa() {return numeroMesa;}
    public Pedido getOrden(){return orden;}

    //Constructor

    public Mesa(int numeroMesa, int numeroPedido){
        this.numeroMesa = numeroMesa;
        this.orden = new Pedido(numeroPedido);
    }
}

