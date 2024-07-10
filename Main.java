import java.util.Scanner;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

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
        System.out.println("\n>> Configuración inicial exitosa");

        //Menu de interaccion con el usuario

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

                for(int i = 0; i < instancia.mesas.size(); i++){
                    instancia.mesas.get(i).imprimirMesa();
                }

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

                System.out.println("Se encontró el item en la carta?: " + itemEncontrado);
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

                System.out.println("Salida while: " + meseroEncontrado + " i: " + i);

                System.out.println("\t\t>> Agregar propina>: (S/N)");
                String respuesta = inputString.nextLine();

                if(respuesta.equals("S")){
                    //El mesero existe
                    if(meseroEncontrado){
                        Pedido pedidoCompletado = instancia.meseros.get(i).getMesasAtendidas().get(mesaCompletada).getOrden();
                        instancia.meseros.get(i).actualizarPropinas(pedidoCompletado.getPropinaSugerida());
                        
                        //Eliminación de la mesa en la lista del mesero y vaciado de la mesa.
                        instancia.meseros.get(i).getMesasAtendidas().remove(mesaCompletada);
                    }

                }               

            //Salir
            }else if(accion == 4){
                for(int i = 0; i < instancia.meseros.size(); i++){
                    instancia.meseros.get(i).imprimirMesero();
                }

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

        //Llenado de meseros
        leerMeseros("Meseros.csv");

        for(int i = 0; i < meseros.size(); i++){
            meseros.get(i).imprimirMesero();
        }

        System.out.println("\n\t>> Meseros ingresados correctamente");
        System.out.println("-----------------------------------------");

        //Llenado de la carta
        leeBebestibles("Bebestibles.csv");
        leeEntradas("Entradas.csv");
        leePlatofondo("Platofondo.csv");
        leerPostre("Postres.csv");
        
        System.out.println("\n\t>> Carta ingresada correctamente");
    }

    //Leer archivo de configuración de los meseros
    public void leerMeseros(String archivoCSV){
        String linea;
        try(BufferedReader br = new BufferedReader(new FileReader(archivoCSV))){
            linea = br.readLine();

            while((linea = br.readLine() )!= null){
                String[] datos = linea.split(",");
                int id = Integer.parseInt(datos[0]);
                String nombreMesero = datos[1];

                //Creacion del mesero
                Mesero nuevoMesero = new Mesero(nombreMesero, id);
                meseros.add(nuevoMesero);
            }
        } catch (IOException e){
            e.printStackTrace();
        }

    }


    //Leer archivo de configuracion bebestibles
    public void leeBebestibles(String archivoCSV) {
        String linea;
        try (BufferedReader br = new BufferedReader(new FileReader(archivoCSV))) {
            // Leer la primera línea (cabecera)
            linea = br.readLine();

            // Leer el resto del archivo
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                int precioItem = Integer.parseInt(datos[1]);
                String nombreItem = datos[2];
                boolean tieneAlcohol = Boolean.parseBoolean(datos[3]);
                String descripcion = datos[4];

                // Crear un objeto Bebestibles y agregarlo al menu
                Carta bebestible = new Bebestibles(precioItem, nombreItem, tieneAlcohol, descripcion);
                menu.add(bebestible);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Leer archivo de configuracion postres
    public void leerPostre(String archivoCSV) {
        String linea;
        try (BufferedReader br = new BufferedReader(new FileReader(archivoCSV))) {
            // Leer la primera línea (cabecera)
            linea = br.readLine();

            // Leer el resto del archivo
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                int precioItem = Integer.parseInt(datos[1]);
                String nombreItem = datos[2];
                String tipoPostre = datos[3];
                String descripcion = datos[4];

                // Crear un objeto Postre y agregarlo al menu
                Carta postre = new Postres(precioItem, nombreItem, tipoPostre, descripcion);
                menu.add(postre);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Leer archivo de configuracion entradas
    public void leeEntradas(String archivoCSV) {
        String linea;
        try (BufferedReader br = new BufferedReader(new FileReader(archivoCSV))) {
            linea = br.readLine(); // Leer la primera línea (cabecera)

            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                int codigoItem = Integer.parseInt(datos[0]);
                int precioItem = Integer.parseInt(datos[1]);
                String nombreItem = datos[2];
                String tipoEntrada = datos[3];
                boolean aptoVegetarianos = Boolean.parseBoolean(datos[4]);


                Carta entrada = new Entradas(precioItem, nombreItem, tipoEntrada, aptoVegetarianos);
                menu.add(entrada);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Leer archivo de configuracion platos de fondo
    public void leePlatofondo(String archivoCSV) {
        String linea;
        try (BufferedReader br = new BufferedReader(new FileReader(archivoCSV))) {
            linea = br.readLine(); // Leer la primera línea (cabecera)

            // Leer el resto del archivo
            while ((linea = br.readLine()) != null) {
                // Ignorar líneas vacías
                if (linea.trim().isEmpty()) {
                    continue;
                }

                String[] datos = linea.split(",");
                if (datos.length < 6) {
                    // Si faltan columnas, continuar con la siguiente línea
                    System.err.println("Línea ignorada por falta de datos: " + linea);
                    continue;
                }

                try {
                    int codigoItem = Integer.parseInt(datos[0].trim());
                    int precioItem = Integer.parseInt(datos[1].trim());
                    String nombreItem = datos[2].trim();
                    String descripcion = datos[3].trim();
                    String tipoPlatoFondo = datos[4].trim();
                    int cantidad = Integer.parseInt(datos[5].trim());

                    Carta platoDeFondo = new PlatoFondo(precioItem, nombreItem, descripcion, tipoPlatoFondo);
                    menu.add(platoDeFondo);
                } catch (NumberFormatException e) {
                    System.err.println("Error al parsear número en línea: " + linea);
                    e.printStackTrace();
                } catch (Exception e) {
                    System.err.println("Error al procesar línea: " + linea);
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
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

