package org.example.Service;

import org.example.Model.Livro;
import org.example.Repository.LivroDAO;

import java.sql.SQLException;

public class LivroService {

    public static void casdastroLivro(Livro livro) {

        var livroDAO = new LivroDAO();

        try {
            livroDAO.cadastroLivro(livro);
            System.out.println("Sucesso: O livro foi cadastrado!");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro: Livro nao cadastrado no Banco de Dados!");
        }
    }

}
