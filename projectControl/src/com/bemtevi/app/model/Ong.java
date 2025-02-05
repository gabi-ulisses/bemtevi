package com.bemtevi.app.model;

public class Ong extends Usuario{

    private String cnpj;

    public Ong(String nome, String email, String telefone, String senha, String cnpj) {
        super(nome, email, telefone, senha);
        this.cnpj = cnpj;
    }

    public Ong(){
        super("ong1", "ong@", "1234", "12");
        this.cnpj = "1234567";
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    @Override
    public boolean validarSenha(String senha) {
        return this.getSenha().equals(senha);
    }

}
