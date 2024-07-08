import java.util.Scanner;

public class Postres extends Carta{
    //Atributos
    private String tipoPostre;
    private String descripcion;

    //Metodos
    public void imprimirItem(){
        System.out.println("\n\t\t>> Nombre del postre: " + nombreItem);
        System.out.println("\t\t>> Codigo del postre: " + id);
        System.out.println("\t\t>> Precio del postre: " + precioItem);
        System.out.println("\t\t>> Tipo de postre: " + tipoPostre);
        System.out.println("\t\t>> Descripción: ");
        System.out.println("\t\t\t>>> " + descripcion);
    }
    //Getters
    public String getTipoPostre(){ return tipoPostre; }
    public String getDescripcion(){ return descripcion; }

    //Constructor
    public Postres(int precioItem, String nombreItem, String tipoPostre, String descripcion){
        super(precioItem, nombreItem);
        this.tipoPostre = tipoPostre;
        this.descripcion = descripcion;

    }
}
