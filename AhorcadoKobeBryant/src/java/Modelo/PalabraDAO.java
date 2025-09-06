package modelo;

import Config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PalabraDAO {

    public List<Palabra> listarPalabras() {
        List<Palabra> lista = new ArrayList<>();
        String sql = "SELECT codigo_Palabra, Palabra, pista FROM Palabras";

        try (Connection conexion = new Conexion().Conexion();
             PreparedStatement ps = conexion.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            if (conexion == null) {
                System.out.println("Error: conexión nula a la base de datos");
                return lista;
            }

            while (rs.next()) {
                Palabra palabra = new Palabra();
                palabra.setCodigoPalabra(rs.getInt("codigo_Palabra"));
                palabra.setPalabra(rs.getString("Palabra"));
                palabra.setPista(rs.getString("pista"));
                lista.add(palabra);
            }

            System.out.println("DAO: palabras obtenidas = " + lista.size());
            for (Palabra p : lista) {
                System.out.println(p.getPalabra() + " | " + p.getPista());
            }

        } catch (SQLException e) {
            System.out.println("Error DAO: " + e.getMessage());
            e.printStackTrace();
        }

        return lista;
    }
}
