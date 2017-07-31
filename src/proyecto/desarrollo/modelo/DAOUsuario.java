package proyecto.desarrollo.modelo;

import java.sql.*;
import javax.swing.JOptionPane;

public class DAOUsuario {
 
    public static int validarUsuario(Usuario usuario){
        Connection con = null;
        Statement cons = null;
        ResultSet res = null;
        int valido = 0;
        
        try{
            con = Conexion.conectarse();

            cons = con.createStatement();
            res = cons.executeQuery("SELECT * FROM usuario");
            
            
            String user = usuario.getUsuario();
            String pass = usuario.getContraseña();
            
            while(res.next()){
                String id_user = res.getString(1);
                String contraseña = res.getString(2);
                
                if(user.equals(id_user)){
                    if(pass.equals(contraseña)){
                        valido = 2;
                        break;
                    } else
                        valido = 1;
                }
            }  
                
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
            return valido;
        }
    }
    
    public static void registrar(Usuario usuario){
        Connection con = null;
        CallableStatement guardarUsuario = null;
        
        try{
            con=Conexion.conectarse();
            
            guardarUsuario = con.prepareCall("{call guardar_usuario(?,?)}");
            guardarUsuario.setString(1, usuario.getUsuario());
            guardarUsuario.setString(2, usuario.getContraseña());
            
            guardarUsuario.execute();
            JOptionPane.showMessageDialog(null, "Registro exitoso");
            
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            
        } finally{
            try{
                con.close();
                guardarUsuario.close();
                
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
