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
        scn.close();
    
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
