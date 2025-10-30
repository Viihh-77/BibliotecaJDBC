package org.example.View;

import org.example.Model.Emprestimo;
import org.example.Model.Livro;
import org.example.Service.EmprestimoService;
import org.example.Service.LivroService;

import java.util.Scanner;

public class BibliotecaView {

    static Scanner input = new Scanner(System.in);

    public static void inicio() {
        mostrarMenu();
        int escolha = capturarOpcao();

        switch (escolha) {

            case 1 -> {
                cadastroLivro();
            }

            case 2 -> {
                cadastroEmprestimo();
            }

            case 3 -> {
                devolucaoLivro();
            }

            case 4 -> {
                consulta();
            }
        }
    }

    public static void mostrarMenu() {
        System.out.println(" ");
        System.out.println(" -------------------------- ");
        System.out.println("|         --MENU--         |");
        System.out.println("| 1 - Cadastro Livro       |");
        System.out.println("| 2 - Cadastro Empréstimo  |");
        System.out.println("| 3 - Devolução livro      |");
        System.out.println("| 4 - Consultas            |");
        System.out.println(" -------------------------- ");
        System.out.println(" ");
    }

    public static int capturarOpcao() {
        System.out.println(" ");
        int escolha = input.nextInt();
        input.nextLine();
        return escolha;
    }

    public static void cadastroLivro() {

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

    public static void cadastroEmprestimo() {

        System.out.println(" ");
        System.out.println(" --EMPRESTIMO DE LIVRO-- ");

        System.out.println(" -- ID Livro: ");
        int idLivro = input.nextInt();
        input.nextLine();

        System.out.println(" -- ID Usuario: ");
        int idUsuario = input.nextInt();
        input.nextLine();

        EmprestimoService.cadastroEmprestimo(new Emprestimo(idLivro, idUsuario));
    }

    public static void devolucaoLivro() {

    }

    public static void consulta() {

    }
}
