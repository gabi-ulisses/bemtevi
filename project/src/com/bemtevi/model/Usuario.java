package com.bemtevi.model;

import java.util.List;

public abstract class Usuario implements Login {
    private String nome;
    private String email;
    private String telefone;
    private String senha;

    public Usuario(String nome, String email, String telefone, String senha) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.senha = senha;
    }

    // Implementação do método da interface Login
    @Override
    public Usuario autenticar(List<Usuario> usuarios, String email, String senha) {
        for (Usuario usuario : usuarios) {
            if (usuario.getEmail().equals(email) && usuario.validarSenha(senha)) {
                return usuario;
            }
        }
        return null; 
    }

    // Métodos adicionais
    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public boolean validarSenha(String senha) {
        return this.senha.equals(senha);
    }

    // Método abstrato
    public abstract void cadastrarUsuario();
}