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
public class DAOAvion {
    
    public static ArrayList <Avion> obtenerTodo(){
        Connection con = null;
        Statement cons = null;
        ResultSet res = null;
        ArrayList<Avion> aviones = null;
        
        try{
            con = Conexion.conectarse();
            aviones = new ArrayList<>();

            cons = con.createStatement();
            res = cons.executeQuery("SELECT * FROM avion");

            while(res.next()){
                String idAvion = res.getString(1);
                String fabricante = res.getString(2);
                String modelo = res.getString(3);
                int capacidad = res.getInt(4);
                int autonomia = res.getInt(5);

                Avion avion = new Avion(idAvion, fabricante, modelo, capacidad, autonomia);
                aviones.add(avion);
            }
            
            return aviones;
            
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            
        } finally {
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
    
    public static void guardar(Avion avion){
        Connection con = null;
        CallableStatement guardarAvion = null;
        
        try{
            con=Conexion.conectarse();

            guardarAvion = con.prepareCall("{call guardar_avion(?,?,?,?,?)}");
            guardarAvion.setString(1, avion.getIdAvion());
            guardarAvion.setString(2, avion.getFabricante());
            guardarAvion.setString(3, avion.getModelo());
            guardarAvion.setInt(4, avion.getCapacidad());
            guardarAvion.setInt(5, avion.getAutonomia());
            

            guardarAvion.execute();
            JOptionPane.showMessageDialog(null, "Avión guardado");
           
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            
        } finally {
            try{
                con.close();
                guardarAvion.close();
                
            } catch (Exception e){
                JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
                
            }
        }
    }
    
    public static void actualizar(Avion avion){
        /*Connection con = null;
        CallableStatement actualizarAlmacen = null;
        
        try{
            con = Conexion.conectarse();
            
            actualizarAlmacen = con.prepareCall("{CALL actualizar_almacen(?,?)}");
            actualizarAlmacen.setInt(1, almacen.getNumeroAlmacen());
            actualizarAlmacen.setString(2, almacen.getUbicacionAlmacen());
        
            actualizarAlmacen.execute();
            JOptionPane.showMessageDialog(null, "Almacen actualizado");
        
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            
        } finally{
            try{
                con.close();
                actualizarAlmacen.close();
                
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
            cons.executeQuery("DELETE FROM almacen WHERE numero_almacen = " + id);
            
            JOptionPane.showMessageDialog(null, "Almacen eliminado");
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage() + "\nCausa: " + e.getCause());
        }*/
    }
}
