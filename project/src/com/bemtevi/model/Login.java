package com.bemtevi.model;
import java.util.List;

public interface Login {
    Usuario autenticar(List<Usuario> usuarios, String email, String senha);   
}