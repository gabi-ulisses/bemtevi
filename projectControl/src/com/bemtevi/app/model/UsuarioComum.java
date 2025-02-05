package com.bemtevi.app.model;

/**
 * Classe que representa um usuário comum no sistema.
 * 
 * O usuário comum herda da classe `Usuario` e representa um tipo específico de usuário,
 * com características básicas como nome, email, telefone e senha.
 * 
 * A classe implementa o método `validarSenha`, que compara a senha fornecida com a senha
 * do usuário armazenada no sistema.
 */
public class UsuarioComum extends Usuario {

    public UsuarioComum(String nome, String email, String telefone, String senha) {
        super(nome, email, telefone, senha);
    }

    public UsuarioComum(){
        super("ana", "ana@", "1234", "12");
    }

    @Override
    public boolean validarSenha(String senha) {
        return this.getSenha().equals(senha);
    }
}
