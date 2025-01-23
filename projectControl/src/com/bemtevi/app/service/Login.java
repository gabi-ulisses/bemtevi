package com.bemtevi.app.service;
import java.util.List;

import com.bemtevi.app.model.Usuario;

public interface Login {
    Usuario autenticar(List<Usuario> usuarios, String email, String senha);   
    void verificarSenha(List<Usuario> usuarios, String email, String senha);
    void verificarEmail(List<Usuario> usuarios, String email);
}