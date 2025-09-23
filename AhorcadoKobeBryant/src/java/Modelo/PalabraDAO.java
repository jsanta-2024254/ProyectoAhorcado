package modelo;

import Config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PalabraDAO {

    public List<Words> listarPalabras() {
        List<Words> lista = new ArrayList<>();
        String sql = "SELECT code_word, word, hint FROM Words";

        try (Connection conexion = new Conexion().Conexion();
             PreparedStatement ps = conexion.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            if (conexion == null) {
                System.out.println("Error: conexión nula a la base de datos");
                return lista;
            }

            while (rs.next()) {
                Words palabra = new Words();
                palabra.setCode_word(rs.getInt("code_word"));
                palabra.setWord(rs.getString("word"));
                palabra.setHint(rs.getString("hint"));
                lista.add(palabra);
            }

            System.out.println("DAO: palabras obtenidas = " + lista.size());
            for (Words p : lista) {
                System.out.println(p.getWord() + " | " + p.getHint());
            }

        } catch (SQLException e) {
            System.out.println("Error DAO: " + e.getMessage());
            e.printStackTrace();
        }

        return lista;
    }
}
