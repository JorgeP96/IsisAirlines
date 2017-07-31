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
public class Pasajero {
    private String id;
    private String nombre;
    private String asiento;
    private String clase;
    private String vuelo;

    public Pasajero(String id, String nombre, String asiento, String clase, String vuelo) {
        this.id = id;
        this.nombre = nombre;
        this.asiento = asiento;
        this.clase = clase;
        this.vuelo = vuelo;
    }

    public String getVuelo() {
        return vuelo;
    }

    public void setVuelo(String vuelo) {
        this.vuelo = vuelo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAsiento() {
        return asiento;
    }

    public void setAsiento(String asiento) {
        this.asiento = asiento;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }
}
