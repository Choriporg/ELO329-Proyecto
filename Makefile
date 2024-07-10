# Variables
JAVAC = javac
JAVA = java
SRC_DIR = .
CLASSES = Main.class Mesero.class Mesa.class Pedido.class Carta.class Bebestibles.class Entradas.class PlatoFondo.class Postres.class

# Regla principal
all: compile

# Reglas de compilación
compile: $(CLASSES)

Main.class: Main.java
	$(JAVAC) Main.java

Mesero.class: Mesero.java
	$(JAVAC) Mesero.java

Mesa.class: Mesa.java
	$(JAVAC) Mesa.java

Pedido.class: Pedido.java
	$(JAVAC) Pedido.java

Carta.class: Carta.java
	$(JAVAC) Carta.java

Bebestibles.class: Bebestibles.java
	$(JAVAC) Bebestibles.java

Entradas.class: Entradas.java
	$(JAVAC) Entradas.java

PlatoFondo.class: PlatoFondo.java
	$(JAVAC) PlatoFondo.java

Postres.class: Postres.java
	$(JAVAC) Postres.java

# Ejecutar el programa
run: compile
	$(JAVA) Main

# Limpiar los archivos .class
clean:
	del /F /Q *.class