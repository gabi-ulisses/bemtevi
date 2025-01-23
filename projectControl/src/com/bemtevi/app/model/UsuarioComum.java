package com.bemtevi.model;

import com.bemtevi.service.UsuarioService;

public class UsuarioComum extends Usuario{

    // Construtor
    public UsuarioComum(String nome, String email, String telefone, String senha) {
        super(nome, email, telefone, senha);
    }
}
