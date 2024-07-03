import java.util.Scanner;

public class Postres extends Carta{
    //Atributos
    private String tipoPostre;
    private String descripcion;

    //Metodos
    public void ingresarItem(){
        System.out.println(">> Ingrese el tipo de postre");
        Scanner scn = new Scanner(System.in);
        tipoPostre = scn.nextLine();
        System.out.println(">> Ingrese una descripción del postre");
        descripcion = scn.nextLine();
    }

    public void imprimirItem(){
        System.out.println("\n\t\t>> Nombre del postre: " + nombreItem);
        System.out.println("\t\t>> Codigo del postre: " + codigoItem);
        System.out.println("\t\t>> Precio del postre: " + precioItem);
        System.out.println("\t\t>> Tipo de postre: " + tipoPostre);
        System.out.println("\t\t>> Descripción: ");
        System.out.println("\t\t\t>>> " + descripcion);
    }
    //Getters
    public String getTipoPostre(){ return tipoPostre; }
    public String getDescripcion(){ return descripcion; }

    //Constructor
    public Postres(int codigoItem, int precioItem, String nombreItem){
        super(codigoItem, precioItem, nombreItem);
        ingresarItem();
    }
}
