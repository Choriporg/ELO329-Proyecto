import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Mesero> meseros;
    private static List<Mesa> mesas;
    private static List<Carta> menu;

    public static void main(String[] args) {
        inicializarSistema();
        mostrarMenuPrincipal();
    }

    private static void inicializarSistema() {
        meseros = new ArrayList<>();
        mesas = new ArrayList<>();
        menu = new ArrayList<>();

        cargarMeserosDesdeArchivo("meseros.csv");
        for (int i = 1; i <= 10; i++) {
            mesas.add(new Mesa(i));
        }
        cargarMenuDesdeArchivo("Bebestibles.csv", "Entradas.csv", "Platofondo.csv", "Postres.csv");
    }

    private static void cargarMeserosDesdeArchivo(String archivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                String nombre = datos[0];
                int codigo = Integer.parseInt(datos[1]);
                meseros.add(new Mesero(nombre, codigo));
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo de meseros: " + e.getMessage());
        }
    }

    private static void cargarMenuDesdeArchivo(String archivoBebestibles, String archivoEntradas, String archivoPlatoFondo, String archivoPostres) {
        cargarBebestibles(archivoBebestibles);
        cargarEntradas(archivoEntradas);
        cargarPlatoFondo(archivoPlatoFondo);
        cargarPostres(archivoPostres);
    }

    private static void cargarBebestibles(String archivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                String nombre = datos[0];
                int precio = Integer.parseInt(datos[1]);
                boolean tieneAlcohol = Boolean.parseBoolean(datos[2]);
                menu.add(new Bebestibles(nombre, precio, tieneAlcohol));
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo de bebestibles: " + e.getMessage());
        }
    }

    private static void cargarEntradas(String archivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                String nombre = datos[0];
                int precio = Integer.parseInt(datos[1]);
                String tipoEntrada = datos[2];
                boolean aptoVegetarianos = Boolean.parseBoolean(datos[3]);
                menu.add(new Entradas(nombre, precio, tipoEntrada, aptoVegetarianos));
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo de entradas: " + e.getMessage());
        }
    }

    private static void cargarPlatoFondo(String archivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                String nombre = datos[0];
                int precio = Integer.parseInt(datos[1]);
                String tipoPlatoFondo = datos[2];
                menu.add(new PlatoFondo(nombre, precio, tipoPlatoFondo));
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo de platos de fondo: " + e.getMessage());
        }
    }

    private static void cargarPostres(String archivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                String nombre = datos[0];
                int precio = Integer.parseInt(datos[1]);
                String tipoPostre = datos[2];
                menu.add(new Postres(nombre, precio, tipoPostre));
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo de postres: " + e.getMessage());
        }
    }

    private static void mostrarMenuPrincipal() {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.println("\n=== Sistema de Gestión de Pedidos ===");
            System.out.println("Seleccione una opción:");
            System.out.println("1. Seleccionar mesa");
            System.out.println("2. Ingresar pedido");
            System.out.println("3. Mostrar mesas ocupadas");
            System.out.println("4. Mostrar mesas desocupadas");
            System.out.println("5. Generar boleta y liberar mesa");
            System.out.println("6. Salir");
            System.out.print("Opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    seleccionarMesa(scanner);
                    break;
                case 2:
                    ingresarPedido(scanner);
                    break;
                case 3:
                    mostrarMesasOcupadas();
                    break;
                case 4:
                    mostrarMesasDesocupadas();
                    break;
                case 5:
                    generarBoleta(scanner);
                    break;
                case 6:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opción inválida, por favor intente nuevamente.");
            }
        }
        scanner.close();
    }

    private static void seleccionarMesa(Scanner scanner) {
        System.out.println("\n=== Selección de Mesa ===");
        System.out.println("Seleccione el número de mesa disponible:");
        for (Mesa mesa : mesas) {
            if (!mesa.isOcupada()) {
                System.out.println("Mesa " + mesa.getNumeroMesa());
            }
        }
        System.out.print("Número de mesa: ");
        int numeroMesa = scanner.nextInt();
        try {
            Mesa mesaSeleccionada = mesas.get(numeroMesa - 1);
            if (!mesaSeleccionada.isOcupada()) {
                System.out.println("Mesa " + numeroMesa + " seleccionada.");
                mesaSeleccionada.asignarPedido(new Pedido()); // Marcando la mesa como ocupada
            } else {
                System.out.println("Mesa no disponible.");
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Número de mesa inválido. Por favor, intente nuevamente.");
        }
    }

    private static void ingresarPedido(Scanner scanner) {
        System.out.println("\n=== Ingreso de Pedido ===");
        System.out.print("Ingrese el número de mesa: ");
        int numeroMesa = scanner.nextInt();
        try {
            Mesa mesaSeleccionada = mesas.get(numeroMesa - 1);
            if (mesaSeleccionada.isOcupada()) {
                Pedido pedido = mesaSeleccionada.getPedidoActual();
                boolean agregarProductos = true;
                while (agregarProductos) {
                    System.out.println("Seleccione un producto del menú:");
                    for (int i = 0; i < menu.size(); i++) {
                        System.out.println((i + 1) + ". " + menu.get(i).getNombreItem() + " - $" + menu.get(i).getPrecioItem());
                    }
                    System.out.print("Número del producto: ");
                    int productoIndex = scanner.nextInt() - 1;
                    if (productoIndex >= 0 && productoIndex < menu.size()) {
                        pedido.agregarProducto(menu.get(productoIndex));
                        System.out.println("Producto agregado.");
                    } else {
                        System.out.println("Producto inválido.");
                    }
                    agregarProductos = preguntarSiAgregarOtroProducto(scanner);
                }
                System.out.println("Pedido registrado. Subtotal: $" + pedido.getSubtotal() + " Propina sugerida: $" + pedido.getPropinaSugerida());
            } else {
                System.out.println("Mesa no disponible o no seleccionada.");
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Número de mesa inválido. Por favor, intente nuevamente.");
        }
    }

    private static boolean preguntarSiAgregarOtroProducto(Scanner scanner) {
        while (true) {
            System.out.print("¿Desea agregar otro producto? (1: Sí, 2: No): ");
            String respuesta = scanner.next();
            if (respuesta.equalsIgnoreCase("1") || respuesta.equalsIgnoreCase("Sí") || respuesta.equalsIgnoreCase("Si")) {
                return true;
            } else if (respuesta.equalsIgnoreCase("2") || respuesta.equalsIgnoreCase("No")) {
                return false;
            } else {
                System.out.println("Entrada inválida. Por favor, ingrese '1' para Sí o '2' para No.");
            }
        }
    }

    private static void mostrarMesasOcupadas() {
        System.out.println("\n=== Mesas Ocupadas ===");
        for (Mesa mesa : mesas) {
            if (mesa.isOcupada()) {
                System.out.println("Mesa " + mesa.getNumeroMesa());
            }
        }
    }

    private static void mostrarMesasDesocupadas() {
        System.out.println("\n=== Mesas Desocupadas ===");
        for (Mesa mesa : mesas) {
            if (!mesa.isOcupada()) {
                System.out.println("Mesa " + mesa.getNumeroMesa());
            }
        }
    }

    private static void generarBoleta(Scanner scanner) {
        System.out.println("\n=== Generación de Boleta ===");
        System.out.print("Ingrese el número de mesa para generar la boleta: ");
        int numeroMesa = scanner.nextInt();
        try {
            Mesa mesaSeleccionada = mesas.get(numeroMesa - 1);
            if (mesaSeleccionada.isOcupada()) {
                Pedido pedido = mesaSeleccionada.getPedidoActual();
                try (FileWriter writer = new FileWriter("boleta_mesa_" + numeroMesa + ".txt")) {
                    writer.write("Boleta para Mesa " + numeroMesa + "\n");
                    writer.write("=====================\n");
                    for (Carta producto : pedido.getProductosPedidos()) {
                        writer.write(producto.getNombreItem() + " - $" + producto.getPrecioItem() + "\n");
                    }
                    writer.write("=====================\n");
                    writer.write("Subtotal: $" + pedido.getSubtotal() + "\n");
                    writer.write("Propina Sugerida: $" + pedido.getPropinaSugerida() + "\n");
                } catch (IOException e) {
                    System.out.println("Error al generar la boleta: " + e.getMessage());
                }
                mesaSeleccionada.liberarMesa();
                System.out.println("Boleta generada y mesa liberada.");
            } else {
                System.out.println("Mesa no disponible o no seleccionada.");
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Número de mesa inválido. Por favor, intente nuevamente.");
        }
    }
}


