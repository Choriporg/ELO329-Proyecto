import java.util.ArrayList;

public class Mesero {
    //Atributos
    private String nombreMesero;
    private int propinasAcumuladas;
    private int codigoMesero;
    private ArrayList<Mesa> mesasAtendidas;

    //Metodos

    public void ingresarMesa(Mesa mesaNueva){
        mesasAtendidas.add(mesaNueva);
    }

    public void actualizarPropinas(int propinaGanada){
        propinasAcumuladas += propinaGanada;
    }

    public void imprimirMesero(){
        System.out.println("Nombre del mesero: " + nombreMesero + "; Codigo del mesero: " + codigoMesero + "; Propinas acumuladas: " + propinasAcumuladas);
    }

    //Getters

    public int getCodigoMesero(){ return codigoMesero;}
    public int getPropinasAcumuladas(){ return propinasAcumuladas;}
    public ArrayList<Mesa> getMesasAtendidas(){return mesasAtendidas;}
    public String getNombreMesero(){ return nombreMesero;}

    //Setters
    public void setCodigoMesero(int codigo){
        codigoMesero = codigo;
    }

    //Cosntructor
    public Mesero(String nombreMesero){
        codigoMesero = 0;
        mesasAtendidas = new ArrayList<Mesa>();
        this.nombreMesero = nombreMesero;
        propinasAcumuladas = 0;
    }

}
