package org.example.Repository;

import org.example.Model.Usuario;
import org.example.Util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {

    public static void cadastroUsuario(Usuario usuario) throws SQLException {

        String query = """
                INSERT INTO usuarios
                (nome,email)
                VALUES
                (?,?)
                """;

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEmail());
            stmt.executeUpdate();
        }
    }

    public static boolean verificaDuplicidade(Usuario usuario) throws SQLException {

        String query = """
                SELECT COUNT(*) AS linhas
                FROM usuarios
                WHERE nome = ?
                """;

        try (Connection conn = Conexao.conectar();
        PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, usuario.getNome());
            ResultSet rs = stmt.executeQuery();

            if (rs.next() && rs.getInt("linhas") > 0) {
                return true;
            }
        }
        return false;
    }
}
