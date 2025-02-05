package com.bemtevi.app.model;

/**
 * Classe abstrata que representa um usuário no sistema.
 * 
 * A classe `Usuario` serve como base para diferentes tipos de usuários (como `UsuarioComum`, `Administrador`, etc.) e contém
 * informações comuns como nome, email, telefone e senha. Além disso, define um método abstrato `validarSenha` que deve ser
 * implementado pelas subclasses para verificar a validade da senha de acordo com as regras específicas de cada tipo de usuário.
 * 
 * A classe também sobrescreve o método `toString` para fornecer uma representação em string dos dados principais do usuário.
 */
public abstract class Usuario{
    private String nome;
    private String email;
    private String telefone;
    private String senha;

    // Construtor que inicializa os atributos básicos do usuário
    public Usuario(String nome, String email, String telefone, String senha) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.senha = senha;
    }

    // Métodos getters para acessar os atributos privados
    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getSenha() {
        return senha;
    }

    // Método abstrato que deve ser implementado pelas subclasses para validar a senha
    public abstract boolean validarSenha(String senha);

    // Método sobrescrito para retornar uma representação em string do usuário
    @Override
    public String toString() {
        return "\nUsuario{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", telefone='" + telefone + '\'' +
                '}';
    }
}
