import java.util.Scanner;

public class Bebestibles extends Carta{
    //Atributos
    private boolean tieneAlcohol;
    private String descripcion;

    //Metodos

    public void imprimirItem(){
        System.out.println("\n\t\t>> Nombre de la bebida: " + nombreItem);
        System.out.println("\t\t>> Codigo de la bebida: " + id);
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
    public Bebestibles(int precioItem,  String nombreItem,  boolean tieneAlcohol, String descripcion){
        super(precioItem, nombreItem);
        this.tieneAlcohol = tieneAlcohol;
        this.descripcion = descripcion;
    }
}
