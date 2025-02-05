package com.bemtevi.app.interfaces;

import java.util.List;
import com.bemtevi.app.model.Usuario;

/**
 * Interface responsável por fornecer métodos para autenticação de usuários.
 * Contém métodos para autenticar, verificar senha e verificar email.
 * 
 * Métodos principais:
 * - **autenticar**: Realiza a autenticação do usuário com base no email e senha fornecidos.
 * - **verificarSenha**: Verifica se a senha fornecida corresponde à senha do usuário.
 * - **verificarEmail**: Verifica se o email fornecido existe na lista de usuários.
 * 
 * A interface pode ser implementada por classes que necessitam de funcionalidades de autenticação de usuários.
 */
public interface Autenticavel {
    Usuario autenticar(List<Usuario> usuarios, String email, String senha);
}
