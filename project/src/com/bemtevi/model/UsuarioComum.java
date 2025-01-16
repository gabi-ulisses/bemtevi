package com.bemtevi.model;

public class UsuarioComum extends Usuario{
    
    public UsuarioComum(String nome, String email, int telefone, String senha){
        super(nome, email, telefone, senha);
    }

    @Override
    public void cadastrarUsuario() {
        
    }
}
