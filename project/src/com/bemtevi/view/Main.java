package com.bemtevi.view;

import com.bemtevi.model.Usuario;
import com.bemtevi.model.UsuarioComum;
import com.bemtevi.model.Ong;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        List<Usuario> usuarios = new ArrayList<>();

        // Adicionando alguns usuários iniciais
        Usuario u1 = new UsuarioComum("Ana", "ana@email.com", "senha123", "(16) 1111-2345");
        Usuario u2 = new UsuarioComum("Gabi", "gabi@email.com", "senha1234", "(16) 2222-3456");
        Usuario o1 = new Ong("ONG Esperança", "teste@teste", "(16) 1111-2345", "ONG125", "12.345.678/0001-95");

        usuarios.add(u1);
        usuarios.add(u2);
        usuarios.add(o1);

        Scanner ler = new Scanner(System.in);

        System.out.println("\n\n");
        System.out.println("  BBBBB   EEEEE  M     M  TTTTT  EEEEE  V   V  III");
        System.out.println("  B    B  E      MM   MM    T    E      V   V   I ");
        System.out.println("  BBBBB   EEEE   M M M M    T    EEEE   V   V   I ");
        System.out.println("  B    B  E      M  M  M    T    E      V   V   I ");
        System.out.println("  BBBBB   EEEEE  M     M    T    EEEEE   VVV    I ");

        while (true) {
            System.out.println("\n\nEscolha uma opção:\n\n    1 - Login\n    2 - Cadastro\n    3 - Sair\n");
            System.out.print("Opção: ");
            int opcao = ler.nextInt();
            ler.nextLine(); // Limpar o buffer do scanner

            if (opcao == 1) {
                // Processo de login
                System.out.println("\nLogin:");

                System.out.print("cE-mail: ");
                String email = ler.nextLine();

                // Verifica imediatamente se o e-mail é válido
                boolean emailExistente = false;
                for (Usuario usuario : usuarios) {
                    if (usuario.getEmail().equals(email)) {
                        emailExistente = true;
                        break; // E-mail encontrado, pode prosseguir com a senha
                    }
                }

                if (!emailExistente) {
                    System.out.println("E-mail inválido. Tente novamente.");
                    continue; // Volta para o menu para tentar novamente
                }

                // Se o e-mail for válido, solicita a senha
                System.out.print("Senha: ");
                String senha = ler.nextLine();

                Usuario usuarioLogado = null;

                // Verifica a senha para o e-mail encontrado
                for (Usuario usuario : usuarios) {
                    if (usuario.getEmail().equals(email) && usuario.validarSenha(senha)) {
                        usuarioLogado = usuario;
                        break;  // Encontra o usuário com o e-mail e senha corretos
                    }
                }

                if (usuarioLogado != null) {
                    System.out.println("Bem-vindo(a), " + usuarioLogado.getNome() + "!");
                } else {
                    System.out.println("Senha inválida. Tente novamente.");
                }

            } else if (opcao == 2) {
                // Processo de cadastro
                System.out.println("\nCadastro:");

                System.out.print("  Nome: ");
                String nome = ler.nextLine();

                System.out.print("  E-mail: ");
                String email = ler.nextLine();

                // Verifica se o e-mail já está cadastrado
                boolean emailExistenteParaCadastro = false;
                for (Usuario usuario : usuarios) {
                    if (usuario.getEmail().equals(email)) {
                        emailExistenteParaCadastro = true;
                        break;
                    }
                }

                if (emailExistenteParaCadastro) {
                    System.out.println("E-mail já cadastrado. Tente novamente.");
                    continue; // Volta para o menu para tentar novamente
                }

                // Definindo o tipo de usuário
                System.out.print("Tipo de usuário (1 - Comum / 2 - ONG): ");
                int tipoUsuario = ler.nextInt();
                ler.nextLine(); // Limpar o buffer

                String telefone = null;
                String cnpj = null;
                if (tipoUsuario == 1) {
                    // Usuário Comum
                    System.out.print("Telefone: ");
                    telefone = ler.nextLine();
                } else if (tipoUsuario == 2) {
                    // ONG
                    System.out.print("CNPJ: ");
                    cnpj = ler.nextLine();
                } else {
                    System.out.println("Opção inválida.");
                    continue;
                }

                System.out.print("Senha: ");
                String senha = ler.nextLine();

                // Criação do novo usuário com base no tipo
                Usuario novoUsuario;
                if (tipoUsuario == 1) {
                    novoUsuario = new UsuarioComum(nome, email, senha, telefone);
                } else {
                    novoUsuario = new Ong(nome, email, telefone, senha, cnpj);
                }

                // Adiciona o novo usuário à lista
                usuarios.add(novoUsuario);

                System.out.println("\nCadastro realizado com sucesso!");

            } else if (opcao == 3) {
                // Sair
                System.out.println("\nSaindo...");
                break;
            } else {
                System.out.println("\nOpção inválida. Tente novamente.");
            }
        }

        ler.close();
    }
}