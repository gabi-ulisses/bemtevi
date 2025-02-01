package com.bemtevi.app.service;

import com.bemtevi.app.model.Usuario;
import java.util.List;

public class UsuarioService {

    public Usuario autenticar(List<Usuario> usuarios, String email, String senha) {
        for (Usuario usuario : usuarios) {
            if (usuario.getEmail().equals(email) && usuario.validarSenha(senha)) {
                System.out.println("Bem-vindo(a), " + usuario.getNome() + "!");
                return usuario;
            }
        }
        System.out.println("Email ou senha inválidos.");
        return null;
    }

    // Métodos de verificação de email e senha
    public void verificarSenha(List<Usuario> usuarios, String email, String senha) {
        for (Usuario usuario : usuarios) {
            if (usuario.getEmail().equals(email) && usuario.validarSenha(senha)) {
                System.out.println("Senha correta.");
                return;
            }
        }
        System.out.println("Senha inválida.");
    }

    public void verificarEmail(List<Usuario> usuarios, String email) {
        for (Usuario usuario : usuarios) {
            if (usuario.getEmail().equals(email)) {
                System.out.println("E-mail encontrado.");
                return;
            }
        }
        System.out.println("E-mail não encontrado.");
    }
}