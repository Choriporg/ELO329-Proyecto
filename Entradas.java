import java.util.Scanner;

public class Entradas extends Carta{
    //Atributos
    private boolean aptoVegetarianos;
    private String tipoEntrada;

    //Metodos
    public boolean checkVegetariano(){
        return aptoVegetarianos;
    }


    public void imprimirItem(){
        System.out.println("\n\t\t>> Nombre del plato de entrada: " + nombreItem);
        System.out.println("\t\t>> Codigo del plato de entrada: " + id);
        System.out.println("\t\t>> Precio del plato de entrada: " + precioItem);
        System.out.println("\t\t>> Tipo de entrada: " + tipoEntrada);
        
        //Verificar si es un plato vegetariano
        if(aptoVegetarianos){
            System.out.println("\t\t>> Es un plato vegetariano");
        }else{
            System.out.println("\t\t>> No es un plato vegetariano");
        }
    }

    //Constructor
    public Entradas(int precioItem, String nombreItem, String tipoEntrada, boolean aptoVegetarianos){
        super(precioItem, nombreItem);
        this.tipoEntrada = tipoEntrada;
        this.aptoVegetarianos = aptoVegetarianos;
    }
}
