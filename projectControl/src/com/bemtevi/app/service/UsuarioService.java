package com.bemtevi.app.service;

import com.bemtevi.app.model.Ong;
import com.bemtevi.app.model.Usuario;

import java.util.ArrayList;
import java.util.List;

public class UsuarioService implements Gerenciamento, Login{

    private List<Usuario> usuarios = new ArrayList<>();  // Lista para armazenar os usuários cadastrados

    // Interface Login
    @Override
    public Usuario autenticar(List<Usuario> usuarios, String email, String senha) {
        for (Usuario usuario : usuarios) {
            if (usuario.getEmail().equals(email) && usuario.validarSenha(senha)) {
                return usuario;
            }
        }
        return null; 
    }

    @Override
     public void verificarEmail(List<Usuario> usuarios, String email){
        boolean emailExistente = false;
        for (Usuario usuario : usuarios) {
            if (usuario.getEmail().equals(email)) {
                emailExistente = true;
                break; 
            }
        }

        if (!emailExistente) {
            System.out.println("E-mail inválido. Tente novamente."); 
        }
    }

    @Override
    public void verificarSenha(List<Usuario> usuarios, String email, String senha){

        Usuario usuarioLogado = null;

        // Verifica a senha para o e-mail encontrado
        for (Usuario usuario : usuarios) {
            if (usuario.getEmail().equals(email) && usuario.validarSenha(senha)) {
                usuarioLogado = usuario;
                break;  
            }
        }

        if (usuarioLogado != null) {
            System.out.println("Bem-vindo(a), " + usuarioLogado.getNome() + "!");
        } else {
            System.out.println("Senha inválida. Tente novamente.");
        }
    }

    // Interface Gerenciamento

    @Override
    public void cadastrar(List<Usuario> usuarios) {
        for (Usuario u : usuarios) {
            // Adiciona o usuário à lista interna de usuários
            this.usuarios.add(u);
            
            // Verifica se o usuário é uma ONG ou um usuário comum
            if (u instanceof Ong) {
                Ong ong = (Ong) u;  // Faz o cast para Ong
                System.out.println("ONG cadastrada com CNPJ: " + ong.getCnpj());
            } else {
                System.out.println("Cadastro realizado com sucesso para o usuário comum: " + u.getNome());
            }
        }
        System.out.println(usuarios.size() + " usuários cadastrados com sucesso!");
    }

    // Método para listar todos os usuários
    @Override
    public void listar(List<Usuario> usuarios) {
        for (Usuario usuario : usuarios) {
            System.out.println("Nome: " + usuario.getNome() + ", Email: " + usuario.getEmail());
        }
    }
}
