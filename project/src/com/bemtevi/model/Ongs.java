package com.bemtevi.model;

public class Ongs extends Usuario{

    private String cnpj;
    
    public Ongs(String nome, String email, int telefone, String senha, String cnpj) {
        super(nome, email, telefone, senha);
        this.cnpj = cnpj;
    }

    @Override
    public void cadastrarUsuario() {
       
    }
    
}
