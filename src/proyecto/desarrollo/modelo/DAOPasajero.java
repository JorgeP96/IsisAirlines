/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.desarrollo.modelo;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Jorge
 */
public class DAOPasajero {
 
    public static ArrayList <Pasajero> obtenerTodo(){
        Connection con = null;
        ArrayList<Pasajero> pasajeros = null;
        Statement cons = null;
        ResultSet res = null;
        
        try{
            con = Conexion.conectarse();
            pasajeros = new ArrayList<>();

            cons = con.createStatement();
            res = cons.executeQuery("SELECT * FROM pasajeros");
            
            while(res.next()){
                String id = res.getString(1);
                String nombre = res.getString(2);
                String asiento = res.getString(3);
                String clase = res.getString(4);
                String vuelo = res.getString(5);

                Pasajero pasajero = new Pasajero(id, nombre, asiento, clase, vuelo);
                pasajeros.add(pasajero);
            }
            
            return pasajeros;
            
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            
        } finally{
            try{
                con.close();
                cons.close();
                res.close();
                
            } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            
            }
        }
        
        return null;
    }
    
    public static void guardar(Pasajero pasajero){
        Connection con = null;
        CallableStatement guardarPasajero = null;
        
        try{
            con=Conexion.conectarse();
            
            guardarPasajero = con.prepareCall("{call guardar_pasajero(?,?,?,?,?)}");
            guardarPasajero.setString(1, pasajero.getId());
            guardarPasajero.setString(2, pasajero.getNombre());
            guardarPasajero.setString(3, pasajero.getAsiento());
            guardarPasajero.setString(4, pasajero.getClase());
            guardarPasajero.setString(5, pasajero.getVuelo());
            
            guardarPasajero.execute();
            JOptionPane.showMessageDialog(null, "Pasajero guardado");
            
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            
        } finally{
            try{
                con.close();
                guardarPasajero.close();
                
            } catch (Exception e){
                JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
                
            }
        }
    }
    
    public static void actualizar(Pasajero cliente){
        /*Connection con = null;
        CallableStatement actualizarCliente = null;
        
        try{
            con = Conexion.conectarse();
            
            actualizarCliente = con.prepareCall("{CALL actualizar_cliente(?,?,?)}");
            actualizarCliente.setInt(1, cliente.getNumeroCliente());
            actualizarCliente.setInt(2, cliente.getNumeroAlmacen());
            actualizarCliente.setString(3, cliente.getNombreCliente());
        
            actualizarCliente.execute();
            JOptionPane.showMessageDialog(null, "Cliente actualizado");
        
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            
        } finally{
            try{
                con.close();
                actualizarCliente.close();
                
            } catch(Exception e){
                JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
                
            }
        }*/
    }

    public static void eliminar(String id){
        /*Connection con = null;
        Statement cons = null;
        
        try{
            con = Conexion.conectarse();

            cons = con.createStatement();
            cons.executeQuery("DELETE FROM cliente WHERE numero_cliente = " + id);
            
            JOptionPane.showMessageDialog(null, "Cliente eliminado");
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage() + "\nCausa: " + e.getCause());
        }*/
    }
}
