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
public class DAOVuelo {
    
    public static ArrayList <Vuelo> obtenerTodo(){
        Connection con = null;
        ArrayList<Vuelo> vuelos = null;
        Statement cons = null;
        ResultSet res = null;
        
        try{
            con = Conexion.conectarse();
            vuelos = new ArrayList<>();
            
            cons = con.createStatement();
            res = cons.executeQuery("SELECT * FROM vuelo");
            
            while(res.next()){
                String id = res.getString(1);
                String fecha = res.getString(2);
                String origen = res.getString(3);
                String destino = res.getString(4);
                String avion = res.getString(5);

                Vuelo vuelo = new Vuelo(id, fecha, origen, destino, avion);
                vuelos.add(vuelo);
            }
            
            return vuelos;
            
        } catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        } finally{
            try{
                con.close();
                cons.close();
                res.close();
            } catch (Exception e){
                System.out.println("Error: " + e.getMessage());
            }
        }
        
        return null;
    }
    
    public static void guardar(Vuelo avion){
        Connection con = null;
        CallableStatement guardarVuelo = null;
        
        try{
            con=Conexion.conectarse();

            guardarVuelo = con.prepareCall("{call guardar_vuelo(?,?,?,?,?)}");
            guardarVuelo.setString(1, avion.getId());
            guardarVuelo.setString(2, avion.getFecha());
            guardarVuelo.setString(3, avion.getOrigen());
            guardarVuelo.setString(4, avion.getDestino());
            guardarVuelo.setString(5, avion.getAvion());
            
            guardarVuelo.execute();
            JOptionPane.showMessageDialog(null, "Vuelo guardado");
            
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        } finally{
            try{
                con.close();
                guardarVuelo.close();
            } catch (Exception e){
                JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            }
        }
    }
    
    public static void actualizar(Vuelo vendedor){
        /*Connection con = null;
        CallableStatement actualizarVendedor = null;
        
        try{
            con = Conexion.conectarse();
            
            actualizarVendedor = con.prepareCall("{CALL actualizar_vendedor(?,?)}");
            actualizarVendedor.setInt(1, vendedor.getNumeroVendedor());
            actualizarVendedor.setString(2, vendedor.getNombreVendedor());
            actualizarVendedor.setString(3, vendedor.getAreaVentas());
        
            actualizarVendedor.execute();
            JOptionPane.showMessageDialog(null, "Vendedor actualizado");
        
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            
        } finally{
            try{
                con.close();
                actualizarVendedor.close();
                
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
            cons.executeQuery("DELETE FROM vendedor WHERE numero_vendedor = " + id);
            
            JOptionPane.showMessageDialog(null, "Vendedor eliminado");
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage() + "\nCausa: " + e.getCause());
        }*/
    }
}
