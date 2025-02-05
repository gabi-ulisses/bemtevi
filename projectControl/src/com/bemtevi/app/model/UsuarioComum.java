package com.bemtevi.app.model;

public class UsuarioComum extends Usuario{

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
