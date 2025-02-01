package com.bemtevi.app.model;

public class UsuarioComum extends Usuario{

    public UsuarioComum(String nome, String email, String telefone, String senha) {
        super(nome, email, telefone, senha);
    }

    @Override
    public boolean validarSenha(String senha) {
        return this.getSenha().equals(senha);
    }
}
