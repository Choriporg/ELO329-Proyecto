import java.util.ArrayList;
import java.util.Scanner;

public class Pedido {

    //Atributos
    private ArrayList<Carta> productosPedidos;
    private int numeroPedido;
    private int subtotal;
    private int propinaSugerida;

    //Métodos

    //Agregar item al pedido
    public void agregarItemPedido(Carta producto){
        productosPedidos.add(producto);
        actualizarSubtotal(); //Actualiza el subtotal
        actualizarPropinaSugerida();
    }

    public void actualizarSubtotal(){
        subtotal += productosPedidos.get(productosPedidos.size() - 1).getPrecioItem();
    }
    //Aplica un descuento a un producto en específico
    public void aplicarPrecioEspecial(int codigoProducto){
        //Busqueda del producto
        for(int i = 0; i < productosPedidos.size(); i++){
            if(productosPedidos.get(i).getCodigoItem() == codigoProducto){ //Si el producto es encontrado
                System.out.println(">> ¿Cuál es el descuento que se va a aplicar?");
                Scanner scn = new Scanner(System.in);
                //Calculo del descuento
                int descuento = scn.nextInt();
                float descuentoPorcentual = (float)descuento / 100;
                int valorDesconatado = (int)(productosPedidos.get(i).getPrecioItem() * descuentoPorcentual);
                subtotal -= valorDesconatado; //Aplicación del descuento
                scn.close();
                System.out.println("\n\t>> Descuento aplicado correctamente");
                actualizarPropinaSugerida();
            } else {
                System.out.println("\n\t>> Producto no encontrado");
            }
        }
    }

    public void actualizarPropinaSugerida(){
        propinaSugerida = (int)(subtotal * 0.1);
    }

    //Getters
    public int getSubtotal(){ return subtotal; }
    public int getPropinaSugerida(){ return propinaSugerida; }
    public int getNumeroPedido(){ return numeroPedido; }
    
    //Constructor
    public Pedido(int numeroPedido){
        this.numeroPedido = numeroPedido;
        productosPedidos = new ArrayList<Carta>();
        subtotal = 0;
        propinaSugerida = 0;
    }

}
