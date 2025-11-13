package org.example.Service;

import org.example.Model.Livro;
import org.example.Repository.LivroDAO;

import java.sql.SQLException;

public class LivroService {

    public static void casdastroLivro(Livro livro) throws SQLException {

        var livroDAO = new LivroDAO();

        try {
            if (!livroDAO.verificaDuplicidade(livro)) {
                livroDAO.cadastroLivro(livro);
                System.out.println("Sucesso: O livro foi cadastrado!");
            } else {
                System.out.println("Erro: Um livro com esse nome já existe!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro: Livro nao cadastrado no Banco de Dados!");
        }
    }

}
