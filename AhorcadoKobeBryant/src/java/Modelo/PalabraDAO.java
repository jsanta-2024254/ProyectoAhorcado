package modelo;

import Config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PalabraDAO {

    private Connection conexion;

    public List<Palabra> listarPalabras() {
        List<Palabra> lista = new ArrayList<>();
        String sql = "SELECT codigo_Palabra, Palabra, pista FROM Palabras";

        try {
            // ✅ Usamos tu clase Conexion
            Conexion con = new Conexion();
            conexion = con.Conexion();
            
            PreparedStatement ps = conexion.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Palabra palabra = new Palabra();
                palabra.setCodigoPalabra(rs.getInt("codigo_Palabra"));
                palabra.setPalabra(rs.getString("Palabra"));
                palabra.setPista(rs.getString("pista"));
                lista.add(palabra);
            }

            rs.close();
            ps.close();
            conexion.close();

        } catch (SQLException e) {
            System.out.println("Error al listar palabras: " + e.getMessage());
            e.printStackTrace();
        }

        return lista;
    }
}
