import java.util.Scanner;

public class Entradas extends Carta{
    //Atributos
    private boolean aptoVegetarianos;
    private String tipoEntrada;

    //Metodos
    public boolean checkVegetariano(){
        return aptoVegetarianos;
    }

    public void ingresarItem(){
        System.out.println(">> ¿Es apto para vegetarianos? (S/N)");
        Scanner scn = new Scanner(System.in);
        String respuesta = scn.nextLine();
        if(respuesta.equals("S")){
            aptoVegetarianos = true;
        } else {
            aptoVegetarianos = false;
        }
        System.out.println(">> Ingrese el tipo de entrada");
        tipoEntrada = scn.nextLine();
        scn.close();
    }

    //Constructor
    public Entradas(int codigoItem, int precioItem, String nombreItem){
        super(codigoItem, precioItem, nombreItem);
        ingresarItem();
    }
}
