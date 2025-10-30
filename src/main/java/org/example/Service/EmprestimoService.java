package org.example.Service;

import org.example.Model.Emprestimo;
import org.example.Repository.EmprestimoDAO;
import org.example.Repository.LivroDAO;

import java.sql.SQLException;

public class EmprestimoService {

    public static void cadastroEmprestimo(Emprestimo emprestimo) {

        var emprestimoDAO = new EmprestimoDAO();
        var livroDAO = new LivroDAO();

        try {
            livroDAO.livroDisponivel(emprestimo.getIdLivro(), false);
            emprestimoDAO.cadastroEmprestimo(emprestimo);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro: Emprestimo não cadastrado no Banco de Dados!");
        }
    }

}


// livroRepository.atualizarDisponibilidade(emprestimo.getIdLivro(), false);