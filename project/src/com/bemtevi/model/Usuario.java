package com.bemtevi.model;

public abstract class Usuario {
    private String nome;
    private String email;
    private int telefone;
    private String senha;


    public Usuario(String nome, String email, int telefone, String senha){
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }

    public abstract void cadastrarUsuario();
    // fazerLogin ?
}
