package org.example.Service;

import org.example.Model.Emprestimo;
import org.example.Repository.EmprestimoDAO;
import org.example.Repository.LivroDAO;

import java.sql.SQLException;

public class EmprestimoService {

    public static void cadastroEmprestimo(Emprestimo emprestimo) throws SQLException {

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

    public static void devolucaoLivro(Emprestimo emprestimo) throws SQLException {

        var emprestimoDAO = new EmprestimoDAO();
        var livroDAO = new LivroDAO();

        try {
            livroDAO.livroDisponivel(emprestimo.getIdLivro(), true);
            emprestimoDAO.devolucaoLivro(emprestimo);
            System.out.println("Sucesso: Devolução registrada!");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro: Devolução não cadastrada no Banco de Dados!");
        }
    }

}