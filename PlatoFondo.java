public class PlatoFondo extends Carta{
    //Atributos
    private String descripcion;
    private String tipoPlatoFondo;

    //Metodos

    public void imprimirItem(){
        System.out.println("\n\t\t>> Nombre del plato de fondo: " + nombreItem);
        System.out.println("\t\t>> Codigo del plato de fondo: " + id);
        System.out.println("\t\t>> Precio del plato de fonfo: " + precioItem);
        System.out.println("\t\t>> Tipo de plato de fondo: " + tipoPlatoFondo);
        System.out.println("\t\t>> Descripción del plato:");
        System.out.println("\t\t\t>>> " + descripcion);
    }

    //Constructor
    public PlatoFondo(int precioItem, String nombreItem, String descripcion, String tipoPlatoFondo){
        super(precioItem, nombreItem);
        this.tipoPlatoFondo = tipoPlatoFondo;
        this.descripcion = descripcion;
    }
}
