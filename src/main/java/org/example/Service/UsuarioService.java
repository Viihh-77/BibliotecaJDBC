package org.example.Service;

import org.example.Model.Usuario;
import org.example.Repository.UsuarioDAO;

import java.sql.SQLException;

public class UsuarioService {

    public static void cadastroUsuario(Usuario usuario) throws SQLException {

        var usuarioDAO = new UsuarioDAO();

        try {
            if (!usuarioDAO.verificaDuplicidade(usuario)) {
                usuarioDAO.cadastroUsuario(usuario);
                System.out.println("Sucesso: Usuario cadastrado!");
            } else {
                System.out.println("Erro: Nome do usuario já cadastrado!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro: Livro nao cadastrado no Banco de Dados!");
        }
    }
}
