package com.bemtevi.model;

public class Ong extends Usuario {

    private String cnpj;

    public Ong(String nome, String email, String telefone, String senha, String cnpj) {
        super(nome, email, telefone, senha);
        this.cnpj = cnpj;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    @Override
    public void cadastrarUsuario() {
        System.out.println("ONG cadastrada: " + getNome() + " - CNPJ: " + cnpj);
    }
}
