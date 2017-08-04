package proyecto.desarrollo.modelo;

import java.sql.*;
import java.sql.PreparedStatement;
import java.util.ArrayList;

public class Prueba {
    public static void main(String[] args) {
        
        //Prueba de unidad para guardar aviones
        /*try{
            Avion avion = new Avion("1A", "Aeromexico", "Jet", 25, 5);
            DAOAvion.guardar(avion);
            System.out.println("Guardado correcto de avión");
        } catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }*/
        
        //Prueba de unidad para mostrar todos los aviones
        /*try{
            ArrayList<Avion> aviones;
            aviones = DAOAvion.obtenerTodo();
            String mostrar = "";
            
            for(Avion avion:aviones){
                mostrar += "Avion: " + avion.getIdAvion() + " " +
                          "Fabricante: " + avion.getFabricante() + " " +
                          "Modelo: " + avion.getModelo() + " " +
                          "Capacidad: " + avion.getCapacidad() + " " +
                          "Autonomía: " + avion.getAutonomia() + "\n";
            }
            
            System.out.println(mostrar);
        } catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }*/
        
        
        
        
        
        
        
        
        
        //Prueba de unidad para guardar vuelo
        /*try{
            Vuelo vuelo = new Vuelo("3", "10/09/2017", "Mexico", "Mty", "1A");
            DAOVuelo.guardar(vuelo);
            System.out.println("Guardado correcto de vuelo");
        } catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }*/
        
        //Prueba de unidad para mostrar todos los vuelos
        /*try{
            ArrayList<Vuelo> vuelos;
            vuelos = DAOVuelo.obtenerTodo();
            String mostrar = "";
            
            for(Vuelo vuelo:vuelos){
                mostrar += "Id: " + vuelo.getId()+ " " +
                          "Fecha: " + vuelo.getFecha()+ " " +
                          "Origen: " + vuelo.getOrigen()+ " " +
                          "Destino: " + vuelo.getDestino()+ " " +
                          "Avión: " + vuelo.getAvion()+ "\n";
            }
            
            System.out.println(mostrar);
        } catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }*/
        
        
        
        
        
        
        
        
        //Prueba de unidad para guardar pasajero
        /*try{
            Pasajero pasajero = new Pasajero("1", "Roko", "2A", "Business", "2");
            DAOPasajero.guardar(pasajero);
            System.out.println("Guardado correcto de pasajero");
        } catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }*/
        
        //Prueba de unidad para mostrar todos los pasajeros
        /*try{
            ArrayList<Pasajero> pasajeros;
            pasajeros = DAOPasajero.obtenerTodo();
            String mostrar = "";
            
            for(Pasajero pasajero:pasajeros){
                mostrar += "Id: " + pasajero.getId()+ " " +
                          "Nombre: " + pasajero.getNombre()+ " " +
                          "Asiento: " + pasajero.getAsiento()+ " " +
                          "Clase: " + pasajero.getClase()+ " " +
                          "Vuelo: " + pasajero.getVuelo()+ "\n";
            }
            
            System.out.println(mostrar);
        } catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }*/
    }
}
