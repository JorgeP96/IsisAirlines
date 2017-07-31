/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.desarrollo.modelo;

/**
 *
 * @author Jorge
 */
public class Vuelo {
    private String id;
    private String fecha;
    private String origen;
    private String destino;
    private String avion;

    public Vuelo(String id, String fecha, String origen, String destino, String avion) {
        this.id = id;
        this.fecha = fecha;
        this.origen = origen;
        this.destino = destino;
        this.avion = avion;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getAvion() {
        return avion;
    }

    public void setAvion(String avion) {
        this.avion = avion;
    }
}
