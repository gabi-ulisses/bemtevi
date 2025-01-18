package com.bemtevi.model;

public class UsuarioComum extends Usuario {

    // Construtor
    public UsuarioComum(String nome, String email, String telefone, String senha) {
        super(nome, email, telefone, senha);
    }

    @Override
    public void cadastrarUsuario() {
        System.out.println("Usuário Comum cadastrado: " + getNome());
    }
}
