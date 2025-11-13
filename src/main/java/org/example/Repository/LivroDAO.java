package org.example.Repository;

import org.example.Model.Livro;
import org.example.Util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LivroDAO {

    public void cadastroLivro(Livro livro) throws SQLException {
        String query = """
                INSERT INTO livros
                (titulo, autor, ano, disponivel)
                VALUES
                (?,?,?,?)
                """;

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, livro.getTitulo());
            stmt.setString(2, livro.getAutor());
            stmt.setInt(3, livro.getAno());
            stmt.setBoolean(4, true);
            stmt.executeUpdate();
        }
    }

    public void livroDisponivel(int idLivro, boolean disponivel) throws SQLException {
        String query = """
                UPDATE livros
                SET disponivel = ?
                WHERE id = ?
                """;

        try (Connection conn = Conexao.conectar();
        PreparedStatement stmt = conn.prepareStatement(query)){

            stmt.setBoolean(1, disponivel);
            stmt.setInt(2, idLivro);
            stmt.executeUpdate();
        }
    }

    public boolean verificaDuplicidade(Livro livro) throws SQLException {

        String query = """
                SELECT COUNT(*) AS linhas
                FROM livros
                WHERE titulo = ?
                """;

        try (Connection conn = Conexao.conectar();
        PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, livro.getTitulo());
            ResultSet rs = stmt.executeQuery();

            if (rs.next() && rs.getInt("linhas") > 0) {
                return true;
            }
        }
        return false;
    }

}
