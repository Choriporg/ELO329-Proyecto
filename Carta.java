public abstract class Carta {
    //Atributos
    protected int precioItem;
    protected String nombreItem;
    protected int id;
    protected int id_siguiente;
    protected static int counter = 0;

    //Getters
    public int getPrecioItem(){ return precioItem; }
    public int getCodigoItem(){ return id; }
    public String getNombreItem(){ return nombreItem; }

    //Metodos
    public abstract void imprimirItem();

    //Constructor
    public Carta(int precioItem, String nombreItem){
        this.id = ++counter;
        this.id_siguiente = id;
        this.precioItem = precioItem;
        this.nombreItem = nombreItem;

    }
}
