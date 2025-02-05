package com.bemtevi.app.service;

import com.bemtevi.app.interfaces.Autenticavel;
import com.bemtevi.app.model.Usuario;
import java.util.List;

/**
 * Classe responsável pelos serviços de autenticação e verificação de usuários.
 * 
 * A classe implementa a interface `Autenticavel` e fornece métodos para autenticar um usuário,
 * além de verificar se o e-mail e a senha fornecidos estão corretos.
 * Os métodos disponíveis são:
 * - `autenticar`: Autentica o usuário a partir do e-mail e senha fornecidos.
 * - `verificarSenha`: Verifica se a senha fornecida está correta para o e-mail informado.
 * - `verificarEmail`: Verifica se o e-mail informado existe na lista de usuários.
 */
public class UsuarioService implements Autenticavel {

    @Override
    public Usuario autenticar(List<Usuario> usuarios, String email, String senha) {
        for (Usuario usuario : usuarios) {
            if (usuario.getEmail().equals(email) && usuario.validarSenha(senha)) {
                return usuario;
            }
        }
        System.out.println("\nEmail ou senha inválidos.");
        return null;
    }

    // Métodos de verificação de email e senha
    @Override
    public void verificarSenha(List<Usuario> usuarios, String email, String senha) {
        for (Usuario usuario : usuarios) {
            if (usuario.getEmail().equals(email) && usuario.validarSenha(senha)) {
                System.out.println("Senha correta.");
                return;
            }
        }
        System.out.println("Senha inválida.");
    }

    @Override
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