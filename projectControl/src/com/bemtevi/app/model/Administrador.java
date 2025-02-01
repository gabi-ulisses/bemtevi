package com.bemtevi.app.model;

public class Administrador extends Usuario{
    private String mfa;

    public Administrador(String nome, String email, String telefone, String senha, String mfa){
        super("admin", email, telefone, "root12@3");
        this.mfa = "123IF@AG";
    }

    public String getMfa() {
        return mfa;
    }

    public void setMfa(String mfa) {
        this.mfa = mfa;
    }

    @Override
    public boolean validarSenha(String senha) {
        return this.getSenha().equals(senha);
    }
}
