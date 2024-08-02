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
/**
 *
 * @author Estivo
 */
public class SQLTransacciones {
    private Connection con;
    private ConexionDB conexion;

    public SQLTransacciones() {
        conexion = new ConexionDB();
    }

    public boolean agregarTransaccion(Transacciones transaccion) {
        PreparedStatement ps = null;
        Connection con = conexion.getConexion();
        String sql = "INSERT INTO transacciones (usuario, tipo_transaccion, fecha, descripcion, monto) VALUES (?, ?, ?, ?, ?)";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, transaccion.getUsuario());
            ps.setString(2, transaccion.getTipoTransaccion());
            ps.setDate(3, new java.sql.Date(transaccion.getFecha().getTime()));
            ps.setString(4, transaccion.getDescripcion());
            ps.setDouble(5, transaccion.getMonto());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                if (con != null) con.close();
                if (ps != null) ps.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
}
