package com.bemtevi.app.model;

import com.bemtevi.app.service.Gerenciamento;
import com.bemtevi.app.model.Usuario;

public class Ong extends Usuario{

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
}
