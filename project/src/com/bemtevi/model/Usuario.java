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

    public static void verificarEmail(List<Usuario> usuarios, String email){
        boolean emailExistente = false;
        for (Usuario usuario : usuarios) {
            if (usuario.getEmail().equals(email)) {
                emailExistente = true;
                break; 
            }
        }

        if (!emailExistente) {
            System.out.println("E-mail inválido. Tente novamente."); 
        }
    }

    public static void verificarSenha(List<Usuario> usuarios, String email, String senha){

        Usuario usuarioLogado = null;

        // Verifica a senha para o e-mail encontrado
        for (Usuario usuario : usuarios) {
            if (usuario.getEmail().equals(email) && usuario.validarSenha(senha)) {
                usuarioLogado = usuario;
                break;  
            }
        }

        if (usuarioLogado != null) {
            System.out.println("Bem-vindo(a), " + usuarioLogado.getNome() + "!");
        } else {
            System.out.println("Senha inválida. Tente novamente.");
        }
    }

    // Método abstrato
    public abstract void cadastrarUsuario();
}