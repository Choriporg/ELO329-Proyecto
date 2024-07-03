import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static Scanner inputInteger;
    public static Scanner inputString;
    private ArrayList<Mesero> meseros;
    private ArrayList<Mesa> mesas;
    private ArrayList<Carta> menu;
    public static void main(String[] args){
        //Inicialización de la aplicación

        //Scanner para ingreso de datos
        //Hay dos, para evitar problemas al leer datos de diferentes tipos
        inputInteger = new Scanner(System.in);
        inputString = new Scanner(System.in);

        //Creación de una instancia de ejecución de la aplicación.
        Main instancia = new Main();

        System.out.println("-----------------------------------------");
        System.out.println(">> Bienvenido a la aplicación de pedidos");
        System.out.println("-----------------------------------------");
        System.out.println(">> Iniciando configuraciones iniciales:");
        instancia.Inicialización();
        System.out.println(">> Configuración inicial exitosa");

        //Menu de interaccion con el usuario

        //PENDIENTE POR HACER EL MANEJO DE MESAS Y PEDIDOS.

        boolean continuar = true;
        while(continuar){
            System.out.println("\n>> Seleccione una opción:");
            System.out.println("\t\t>> (1) Ingresar mesa");
            System.out.println("\t\t>> (2) Ingresar Pedido");
            System.out.println("\t\t>> (3) Completar Pedido");
            System.out.println("\t\t>> (4) Salir");
        }
        
    }

    //Inicia la ejecución de la instancia de ejecución creando el arreglo de los meseros y la carta.
    public void Inicialización(){
        inputInteger = new Scanner(System.in);
        inputString = new Scanner(System.in);
        meseros = new ArrayList<Mesero>();
        menu = new ArrayList<Carta>();

        System.out.println("\t>> ¿Cuántos meseros trabajan en el restaurante?");
        int cantidadMeseros = inputInteger.nextInt();


        for(int i = 0; i < cantidadMeseros; i++){
            System.out.println("\n\t>> Ingrese el nombre del mesero " + (i + 1));
            String nombreMesero = inputString.nextLine();
            Mesero mesero = new Mesero(nombreMesero);
            System.out.println("\n\t>> Ingrese el código del mesero " + nombreMesero + ":");
            int codigoMesero = inputInteger.nextInt();
            mesero.setCodigoMesero(codigoMesero);
            meseros.add(mesero);

        }

        for(int i = 0; i < cantidadMeseros; i++){
            meseros.get(i).imprimirMesero();
        }

        System.out.println("\n\t>> Meseros ingresados correctamente");
        System.out.println("-----------------------------------------");

        //Llenado de la carta
        boolean flagCartaCompleta = true;
        while(flagCartaCompleta){

            //Elección de tipo de item que se agregará a la carta
            System.out.println("\n\t>> ¿Qué tipo de item desea ingresar?");
            System.out.println("\t\t1. Bebestible");
            System.out.println("\t\t2. Entrada");
            System.out.println("\t\t3. Plato de fondo");
            System.out.println("\t\t4. Postre");
            System.out.println("\t\t5. Ingreso completo de la carta");
            
            int eleccionItem = inputInteger.nextInt();

            //Caso en el que se ingresa un bebestible
            if(eleccionItem == 1){
                System.out.println("\n\t>> Ingrese el nombre del bebestible");
                String nombreItem = inputString.nextLine();
                System.out.println("\t>> Ingrese el precio del bebestible");
                int precioItem = inputInteger.nextInt();
                System.out.println("\t>> Ingrese el código del bebestible");
                int codigoItem = inputInteger.nextInt();
                Carta bebestible = new Bebestibles(codigoItem, precioItem, nombreItem);
                menu.add(bebestible);

            //Caso en el que se ingresa un plato de entrada
            }else if(eleccionItem == 2){
                System.out.println("\n\t>> Ingrese el nombre de la entrada");
                String nombreItem = inputString.nextLine();
                System.out.println("\t>> Ingrese el precio de la entrada");
                int precioItem = inputInteger.nextInt();
                System.out.println("\t>> Ingrese el código de la entrada");
                int codigoItem = inputInteger.nextInt();
                Carta entrada = new Entradas(codigoItem, precioItem, nombreItem);
                menu.add(entrada);

            //Caso en el que se ingresa un plato de fondo
            } else if(eleccionItem == 3){
                System.out.println("\n\t>> Ingrese el nombre del plato de fondo");
                String nombreItem = inputString.nextLine();
                System.out.println("\t>> Ingrese el precio del plato de fondo");
                int precioItem = inputInteger.nextInt();
                System.out.println("\t>> Ingrese el código del plato de fondo");
                int codigoItem = inputInteger.nextInt();
                Carta platoFondo = new PlatoFondo(codigoItem, precioItem, nombreItem);
                menu.add(platoFondo);

            //Caso en el que se ingresa un postre
            }else if(eleccionItem == 4){
                System.out.println("\n\t>> Ingrese el nombre del postre");
                String nombreItem = inputString.nextLine();
                System.out.println("\t>> Ingrese el precio del postre");
                int precioItem = inputInteger.nextInt();
                System.out.println("\t>> Ingrese el código del postre");
                int codigoItem = inputInteger.nextInt();
                Carta postre = new Postres(codigoItem, precioItem, nombreItem);
                menu.add(postre);

            //Caso en el que se termina de ingresar la carta
            }else if(eleccionItem == 5){
                flagCartaCompleta = false;

            //Caso en el que no hay una entrada válida
            } else{
                System.out.println("\n\t>> Ingrese una opción válida, por favor ingrese un número entre 1 y 4");
            }
            
            System.out.println("-----------------------------------------");
        }
        System.out.println("\n\t>> Carta ingresada correctamente");
    }

    public void mostrarMenu(){
        System.out.println("\n\t>> Mostrando la carta.")
        for(int i = 0; i < menu.size(); i ++){
            menu.get(i).imprimirItem();
        }
    }
}