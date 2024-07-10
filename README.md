# Proyecto: Sistema de gestión de restaurant

Este proyecto consiste en una aplicación que permita manejar el funcionamiento con las mesas del restaurante haciendo que los meseros ingresen los pedidos de cada mesa.

## Descripción
Este proyecto implementa un sistema de gestión para un restaurante, donde se manejan pedidos, mesas, meseros y diferentes tipos de productos (bebestibles, entradas, platos de fondo y postres).

## Estructura del Proyecto
El proyecto contiene los siguientes archivos Java:

- `Bebestibles.java`
- `Carta.java`
- `Entradas.java`
- `Main.java`
- `Mesa.java`
- `Mesero.java`
- `Pedido.java`
- `PlatoFondo.java`
- `Postres.java`

Además, se incluyen archivos CSV con los datos de los productos:

- `Bebestibles.csv`
- `Entradas.csv`
- `Platofondo.csv`
- `Postres.csv`

## Compilación y Ejecución
Para compilar y ejecutar el proyecto, sigue estos pasos:

1. Abre una terminal y navega al directorio donde se encuentran los archivos `.java`.
2. Compila los archivos Java utilizando el comando:
   ```sh
   javac Main.java Mesero.java Mesa.java Pedido.java Carta.java Bebestibles.java Entradas.java PlatoFondo.java Postres.java
   ```
3. Una vez compilados, ejecuta el programa con el siguiente comando:
   ```sh
   java Main
   ```

## Uso
El programa principal está en `Main.java`, que inicializa y maneja las operaciones del restaurante.

## Makefile
El proyecto incluye un `Makefile` para automatizar la compilación y ejecución. Para usar el `Makefile`, sigue estos pasos:

1. Compila los archivos Java:
   ```sh
   make compile
   ```
2. Ejecuta el programa:
   ```sh
   make run
   ```
3. Limpia los archivos `.class` generados:
   ```sh
   make clean
   ```

## Integrantes:
- Vicente Moya 🔰- [@R4skolnikov](https://github.com/r4skolnikov)
- Nicolas Vergara ⛄- [@Nmauri](https://github.com/Nmaurii)
- Ignacio González 👾 - [@Choriporg](https://github.com/Choriporg)
- Eduardo Palma 🗻 - [@Adreoud](https://github.com/adreoud)
