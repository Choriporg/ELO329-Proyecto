import java.util.Scanner;

public class Bebestibles extends Carta{
    //Atributos
    private boolean tieneAlcohol;
    private String descripcion;

    //Metodos
    public void ingresarItem(){
        System.out.println(">> ¿El producto tiene alcohol? (S/N)");
        Scanner scn = new Scanner(System.in);
        String respuesta = scn.nextLine();
        if(respuesta.equals("S")){
            tieneAlcohol = true;
        } else {
            tieneAlcohol = false;
        }
        System.out.println(">> Ingrese una descripción del producto");
        descripcion = scn.nextLine();
          
    }

    public void imprimirItem(){
        System.out.println("\n\t\t>> Nombre de la bebida: " + nombreItem);
        System.out.println("\t\t>> Codigo de la bebida: " + codigoItem);
        System.out.println("\t\t>> Precio de la bebida: " + precioItem);

        if(tieneAlcohol){
            System.out.println("\t\t>> Es una bebida alcohólica");
        } else{
            System.out.println("\t\t>> No es una bebida alcohólica");
        }

        System.out.println("\t\t>> Descripción: ");
        System.out.println("\t\t\t>>> " + descripcion);
    }

    //Getters
    public boolean getTieneAlcohol(){ return tieneAlcohol; }
    public String getDescripcion(){ return descripcion; }

    //Constructor
    public Bebestibles(int codigoItem, int precioItem, String nombreItem){
        super(codigoItem, precioItem, nombreItem);
        ingresarItem();
    }
}
