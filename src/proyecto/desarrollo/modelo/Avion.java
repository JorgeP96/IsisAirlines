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
public class Avion {
    private String idAvion;
    private String fabricante;
    private String modelo;
    private int capacidad;
    private int autonomia;

    public Avion(String idAvion, String fabricante, String modelo, int capacidad, int autonomia) {
        this.idAvion = idAvion;
        this.fabricante = fabricante;
        this.modelo = modelo;
        this.capacidad = capacidad;
        this.autonomia = autonomia;
    }

    public String getIdAvion() {
        return idAvion;
    }

    public void setIdAvion(String idAvion) {
        this.idAvion = idAvion;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public int getAutonomia() {
        return autonomia;
    }

    public void setAutonomia(int autonomia) {
        this.autonomia = autonomia;
    }
}
