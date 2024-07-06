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
        instancia.mesas = new ArrayList<Mesa>();

        System.out.println("-----------------------------------------");
        System.out.println(">> Bienvenido a la aplicación de pedidos");
        System.out.println("-----------------------------------------");
        System.out.println(">> Iniciando configuraciones iniciales:");
        instancia.Inicialización();
        System.out.println(">> Configuración inicial exitosa");

        //Menu de interaccion con el usuario

        //PENDIENTE POR HACER EL MANEJO DE MESAS Y PEDIDOS.

        boolean continuar = true;
        int numeroMesa = 1;
        int numeroPedido = 0;

        while(continuar){
            System.out.println("-----------------------------------------");
            System.out.println("\n>> Seleccione una opción:");
            System.out.println("\t\t>> (1) Ingresar mesa");
            System.out.println("\t\t>> (2) Ingresar Pedido");
            System.out.println("\t\t>> (3) Completar Pedido");
            System.out.println("\t\t>> (4) Salir");

            int accion = inputInteger.nextInt();
            
            //Caso en el que se selecciona ingresar una mesa.
            if(accion == 1){
                Mesa nuevaMesa = new Mesa(numeroMesa, numeroPedido);
                instancia.mesas.add(nuevaMesa);
                
                System.out.println("\t\t>> Codigo del mesero: ");
                int codigoIngresado = inputInteger.nextInt();

                int i = 0;
                boolean meseroEncontrado = false;
                //Obtener el mesero que está atendiendo la mesa
                while(i < instancia.meseros.size() && meseroEncontrado == false){
                    if(instancia.meseros.get(i).getCodigoMesero() == codigoIngresado){
                        meseroEncontrado = true;
                    }else{
                        i++;
                    }
                }
                numeroMesa++;
                numeroPedido++;
                //Verificación si se encontró el mesero
                if(meseroEncontrado == false){
                    System.out.println(">> No se encontró al mesero ingresado, ingrese un codigo válido.");
                }else{
                    instancia.meseros.get(i).ingresarMesa(nuevaMesa);
                }
            //Caso en el que ingresan productos al pedido
            }else if (accion == 2){
                instancia.mostrarMenu();

                System.out.println("\t\t>> Ingrese el codigo del producto: ");
                int codigoProducto = inputInteger.nextInt();

                System.out.println("\t\t>> Ingresa la mesa atendida: ");
                int mesaAtendida = inputInteger.nextInt();

                //Buscar item en la carta
                int i = 0;
                boolean itemEncontrado = false;
                while(i < instancia.menu.size() && itemEncontrado == false){
                    if(instancia.menu.get(i).getCodigoItem() == codigoProducto){
                        itemEncontrado = true;
                    }else{
                        i++;
                    }
                }
                //La mesa y el producto existen
                if(mesaAtendida < instancia.mesas.size() && itemEncontrado){
                    instancia.mesas.get(i).getOrden().agregarItemPedido(instancia.menu.get(i));
                }

            //Completar pedido
            } else if(accion == 3){
                System.out.println("------------------------------------");
                for(int index = 0; index < instancia.meseros.size(); index++){
                    instancia.meseros.get(index).imprimirMesero();
                    instancia.meseros.get(index).imprimirMesasAtendidas();
                }
                System.out.println(">> Ingrese codigo de mesero: ");
                int codMesero = inputInteger.nextInt();

                System.out.println(">> Ingrese la mesa que se está cerrando: ");
                int mesaCompletada = inputInteger.nextInt();
                
                //Busqueda mesero
                int i = 0;
                boolean meseroEncontrado = false;
                while(i < instancia.meseros.size() && meseroEncontrado == false){
                    if(instancia.meseros.get(i).getCodigoMesero() == codMesero){
                        meseroEncontrado = true;
                    }else{
                        i++;
                    }
                }
                //El mesero existe
                if(meseroEncontrado){
                    Pedido pedidoCompletado = instancia.meseros.get(i).getMesasAtendidas().get(mesaCompletada).getOrden();
                    instancia.meseros.get(i).actualizarPropinas(pedidoCompletado.getPropinaSugerida());
                    
                    //Eliminación de la mesa en la lista del mesero y vaciado de la mesa.
                    instancia.meseros.get(i).getMesasAtendidas().remove(mesaCompletada);
                }

            //Salir
            }else if(accion == 4){
                continuar = false;
            }
        
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

    //Imprimir el menu
    public void mostrarMenu(){
        System.out.println("\n\t>> Mostrando la carta.");
        for(int i = 0; i < menu.size(); i ++){
            System.out.println("-----------------------------------------");
            menu.get(i).imprimirItem();
            System.out.println("-----------------------------------------");
        }
    }
}