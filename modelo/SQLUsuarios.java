/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.sql.*;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;


public class SQLUsuarios extends ConexionDB {
    public boolean registrar(Usuarios usuario) {
        ConexionDB conexion = new ConexionDB();
        Connection con = conexion.getConexion();
        PreparedStatement ps = null;
        String sql = "INSERT INTO usuarios (usuario, password, tipoCuenta) VALUES (?, ?, ?)";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, usuario.getUsuario());
            ps.setString(2, usuario.getPassword());
            ps.setString(3, usuario.getTipoCuenta());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
            return false;
        } finally {
            try {
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                System.err.println("Error closing connection: " + e.getMessage());
            }
        }
    }
    public int existeUsuario(String usuario) {
        ConexionDB conexion = new ConexionDB();
        Connection con = conexion.getConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT count(usuario) FROM usuarios WHERE usuario = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, usuario);
            rs = ps.executeQuery();
            
            if(rs.next()){
                return rs.getInt(1);
            }
            
            return 1;
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
            return 1;
        } finally {
            try {
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                System.err.println("Error closing connection: " + e.getMessage());
            }
        }
    }
    
public boolean login(Usuarios usr) {
        ConexionDB conexion = new ConexionDB();
        Connection con = conexion.getConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String sql = "SELECT usuario, password FROM usuarios WHERE usuario = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, usr.getUsuario());
            rs = ps.executeQuery();
            
            if(rs.next()){
                if(usr.getPassword().equals(rs.getString(2))){
                    usr.setUsuario(rs.getString(1));
                    return true;
                }else{
                    return false;
                }
            }
            
            return false;
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
            return false;
        } finally {
            try {
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                System.err.println("Error closing connection: " + e.getMessage());
            }
        }
    }
    public String obtenerNombreUsuario(Usuarios usr) {
        ConexionDB conexion = new ConexionDB();
        Connection con = conexion.getConexion();
        String nombreUsuario = null;
        String sql = "SELECT nombre FROM usuarios WHERE usuarios = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, usr.getUsuario());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                nombreUsuario = rs.getString("nombre");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nombreUsuario;
    }
}
