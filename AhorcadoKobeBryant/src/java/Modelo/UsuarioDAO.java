package modelo;

import Config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    // Método para validar usuario y contraseña
    public Useer validar(String user_name, String user_password) {
        Useer useer = null;
        String sql = "SELECT * FROM Useer WHERE user_name=? AND user_password=?";
        try {
            con = cn.Conexion(); // Obtenemos la conexión
            ps = con.prepareStatement(sql);
            ps.setString(1, user_name);
            ps.setString(2, user_password);
            rs = ps.executeQuery();
            if (rs.next()) {
                // Se simplifco el codigo a utilizar 
                useer = new Useer(rs.getInt("user_code"), rs.getString("user_name"), rs.getString("user_password"));
                //usuario = new Usuario();
                //usuario.setCodigoUsuario(rs.getInt("codigo_usuario"));
                //usuario.setNombreUsuario(rs.getString("nombre_usuario"));
                //usuario.setContraseñaUsuario(rs.getString("contraseña_usuario"));
            }
        } catch (SQLException e) {
            System.out.println("Error en UsuarioDAO.validar: " + e.getMessage());
        } finally {
            // Cerrar recursos
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
            }
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {
            }
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
            }
        }

        return useer;
    }
}
