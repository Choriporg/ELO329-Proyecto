public abstract class Carta {
    //Atributos
    protected int codigoItem;
    protected int precioItem;
    protected String nombreItem;

    //Getters
    public int getPrecioItem(){ return precioItem; }
    public int getCodigoItem(){ return codigoItem; }
    public String getNombreItem(){ return nombreItem; }

    //Metodos
    public abstract void ingresarItem();
    public abstract void imprimirItem();

    //Constructor
    public Carta(int codigoItem, int precioItem, String nombreItem){
        this.codigoItem = codigoItem;
        this.precioItem = precioItem;
        this.nombreItem = nombreItem;
    }
}
