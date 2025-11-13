package org.example.View;

import org.example.Model.Emprestimo;
import org.example.Model.Livro;
import org.example.Model.Usuario;
import org.example.Service.EmprestimoService;
import org.example.Service.LivroService;
import org.example.Service.UsuarioService;

import java.sql.Date;
import java.sql.SQLException;
import java.util.Scanner;

public class BibliotecaView {

    static Scanner input = new Scanner(System.in);

    public static void inicio() throws SQLException {
        mostrarMenu();
        int escolha = capturarOpcao();

        switch (escolha) {

            case 1 -> {
                cadastroLivro();
            }

            case 2 -> {
                cadastroUsuario();
            }

            case 3 -> {
                cadastroEmprestimo();
            }

            case 4 -> {
                devolucaoLivro();
            }

            case 5 -> {
                consulta();
            }
        }
    }

    public static void mostrarMenu() {
        System.out.println(" ");
        System.out.println(" -------------------------- ");
        System.out.println("|         --MENU--         |");
        System.out.println("| 1 - Cadastro Livro       |");
        System.out.println("| 2 - Cadastro Usuário     |");
        System.out.println("| 3 - Cadastro Empréstimo  |");
        System.out.println("| 4 - Devolução livro      |");
        System.out.println("| 5 - Consultas            |");
        System.out.println(" -------------------------- ");
        System.out.println(" ");
    }

    public static int capturarOpcao() {
        System.out.println(" ");
        int escolha = input.nextInt();
        input.nextLine();
        return escolha;
    }

    public static void cadastroLivro() throws SQLException {

        System.out.println(" ");
        System.out.println(" --CADASTRO DE LIVRO-- ");

        System.out.println(" -- Titulo: ");
        String titulo = input.nextLine();

        System.out.println(" -- Autor: ");
        String autor = input.nextLine();

        System.out.println(" -- Ano Publicação: ");
        int anoPubli = input.nextInt();
        input.nextLine();

        LivroService.casdastroLivro(new Livro(titulo,autor,anoPubli));
        inicio();
    }

    public static void cadastroUsuario() throws SQLException {

        System.out.println(" ");
        System.out.println(" --CADASTRO DE USUARIO-- ");

        System.out.println(" ");
        System.out.println(" -- Nome Usuario: ");
        String nomeUser = input.nextLine();

        System.out.println(" ");
        System.out.println(" -- Email Usuario: ");
        String emailUser = input.nextLine();

        UsuarioService.cadastroUsuario(new Usuario(nomeUser,emailUser));
        inicio();
    }

    public static void cadastroEmprestimo() throws SQLException {

        System.out.println(" ");
        System.out.println(" --EMPRESTIMO DE LIVRO-- ");

        System.out.println(" -- ID Livro: ");
        int idLivro = input.nextInt();
        input.nextLine();

        System.out.println(" -- ID Usuario: ");
        int idUsuario = input.nextInt();
        input.nextLine();

        EmprestimoService.cadastroEmprestimo(new Emprestimo(idLivro, idUsuario));
        inicio();
    }

    public static void devolucaoLivro() throws SQLException {

        System.out.println(" ");
        System.out.println(" --DEVOLUÇÃO DO LIVRO-- ");

        System.out.println(" -- ID Empréstimo: ");
        int idEmprestimo = input.nextInt();
        input.nextLine();

        System.out.println(" -- Data de Devolução: ");
        String data = input.nextLine();
        Date dataDevolucao = Date.valueOf(data);

        EmprestimoService.devolucaoLivro(new Emprestimo(idEmprestimo, dataDevolucao));
        inicio();
    }

    public static void consulta() {

    }
}
