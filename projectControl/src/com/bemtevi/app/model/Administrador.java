package com.bemtevi.app.model;

/**
 * Classe responsável por representar um administrador do sistema, que herda da classe `Usuario`.
 * Além dos atributos padrão de um usuário, como nome, email, telefone e senha, um administrador
 * tem um código de autenticação multifatorial (MFA).
 * 
 * Métodos principais:
 * - **validarSenha**: Valida a senha do administrador comparando-a com a senha armazenada.
 * - **validarMFA**: Valida o código de autenticação multifatorial (MFA) do administrador.
 * 
 * O administrador é responsável por ações de controle mais avançadas no sistema, como verificar
 * a identidade através do código MFA.
 */
public class Administrador extends Usuario{
    private String mfa;

    public Administrador(){
        super("admin", "root@", "40028922", "root");
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

    public boolean validarMFA(String codigoMFA){
        return this.mfa.equals(codigoMFA);
    }
}
