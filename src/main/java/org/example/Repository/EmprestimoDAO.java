package org.example.Repository;

import org.example.Model.Emprestimo;
import org.example.Util.Conexao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

public class EmprestimoDAO {

    public void cadastroEmprestimo(Emprestimo emprestimo) throws SQLException {
        String query = """
                INSERT INTO emprestimos
                (livro_id, usuario_id, data_emprestimo)
                VALUES
                (?,?,?)
                """;

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, emprestimo.getIdLivro());
            stmt.setInt(2, emprestimo.getIdUsuario());
            stmt.setDate(3, Date.valueOf(LocalDate.now()));
            stmt.executeUpdate();
        }
    }


}
