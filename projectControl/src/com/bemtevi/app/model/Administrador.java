package com.bemtevi.app.model;

public class Administrador extends Usuario{
    private String mfa;

    public Administrador(){
        super("admin", "root@localhost", "40028922", "root12@3");
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
