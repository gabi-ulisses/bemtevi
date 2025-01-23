package com.bemtevi.controller;

import com.bemtevi.model.Usuario;
import com.bemtevi.service.UsuarioService;
import java.util.List;

public class LoginController {
    private UsuarioService usuarioService;

    public LoginController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    public Usuario realizarLogin(List<Usuario> usuarios, String email, String senha) {
        return usuarioService.autenticar(usuarios, email, senha);
    }
}
