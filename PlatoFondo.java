import java.util.ArrayList;
import java.util.Scanner;

public class PlatoFondo extends Carta{
    //Atributos
    private String descripcion;
    private String tipoPlatoFondo;
    private ArrayList<String> ingredientesEspeciales;

    //Metodos
    public void ingresarItem(){
        System.out.println("\n\t>> Ingrese una descripción del plato");
        Scanner scn = new Scanner(System.in);
        descripcion = scn.nextLine();
        System.out.println("\n\t>> Ingrese el tipo de plato");
        tipoPlatoFondo = scn.nextLine();
        System.out.println(">> ¿Cuántos ingredientes especiales tiene el plato?");
        int cantidadIngredientes = scn.nextInt();
        ingredientesEspeciales = new ArrayList<String>();
        scn.nextLine();
        for(int i = 0; i < cantidadIngredientes; i++){
            System.out.println(">> Ingrese el ingrediente especial " + (i + 1));
            ingredientesEspeciales.add(scn.nextLine());
        }
        scn.close();
    }

    //Constructor
    public PlatoFondo(int codigoItem, int precioItem, String nombreItem){
        super(codigoItem, precioItem, nombreItem);
        ingredientesEspeciales = new ArrayList<String>();
        ingresarItem();
    }
}
