import java.util.ArrayList;
import java.util.List;

/**
 * La clase Mesero representa a un mesero del restaurante.
 * Cada mesero tiene un nombre, un código único, la cantidad de propinas acumuladas,
 * y una lista de mesas que está atendiendo.
 */
public class Mesero {
    private String nombreMesero;
    private int propinasAcumuladas;
    private int codigoMesero;
    private List<Mesa> mesasAtendidas;

    public Mesero(String nombre, int codigo) {
        this.nombreMesero = nombre;
        this.codigoMesero = codigo;
        this.propinasAcumuladas = 0;
        this.mesasAtendidas = new ArrayList<>();
    }

    public void actualizarPropinas(int propina) {
        this.propinasAcumuladas += propina;
    }

    public void asignarMesa(Mesa mesa) {
        this.mesasAtendidas.add(mesa);
    }

    public List<Mesa> getMesasAtendidas() {
        return mesasAtendidas;
    }

    public String getNombreMesero() {
        return nombreMesero;
    }

    public int getPropinasAcumuladas() {
        return propinasAcumuladas;
    }

    public int getCodigoMesero() {
        return codigoMesero;
    }
}