package com.bemtevi.view;

import com.bemtevi.model.Usuario;
import com.bemtevi.model.UsuarioComum;
import com.bemtevi.model.Campanha;
import com.bemtevi.model.Ong;
import com.bemtevi.model.DesastreNatural;
import com.bemtevi.model.Incidente;
import com.bemtevi.model.Contribuicao;
import com.bemtevi.model.Administrador;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        List<Usuario> usuarios = new ArrayList<>();
        List<Campanha> campanhas = new ArrayList<>();
        List<DesastreNatural> desastres = new ArrayList<>();
        List<Incidente> incidentes = new ArrayList<>();
        List<Contribuicao> contribuicoes = new ArrayList<>();

        Administrador adm = new Administrador();

        // Adicionando alguns usuários iniciais
        Usuario u1 = new UsuarioComum("Ana", "ana@email.com", "senha123", "(16) 1111-2345");
        Usuario u2 = new UsuarioComum("Gabi", "gabi@email.com", "senha1234", "(16) 2222-3456");
        Usuario o1 = new Ong("ONG Esperança", "teste@teste", "(16) 1111-2345", "ONG125", "12.345.678/0001-95");

        usuarios.add(u1);
        usuarios.add(u2);
        usuarios.add(o1);

        Campanha c1 = new Campanha(1, "Campanha de alimentos", "Campanha de alimentos para o Rio Grande do Sul", true, 1000, 60, "Rio Grande do Sul");
        Campanha c2 = new Campanha(2, "Campanha de dinheiro", "Campanha de dinheiro para o Rio Grande do Sul", true, 10000, 60, "Rio Grande do Sul");

        campanhas.add(c1);
        campanhas.add(c2);

        listarCampanhas(campanhas);

        DesastreNatural d1 = new DesastreNatural("Enchente");
        DesastreNatural d2 = new DesastreNatural("Terremoto");
        DesastreNatural d3 = new DesastreNatural("Tsunami");
        DesastreNatural d4 = new DesastreNatural("Incêndio Florestal");
        DesastreNatural d5 = new DesastreNatural("Furacão");


        Contribuicao cont1 = new Contribuicao("Alimentos");
        Contribuicao cont2 = new Contribuicao("Roupas");
        Contribuicao cont3 = new Contribuicao("Brinquedos");
        Contribuicao cont4 = new Contribuicao("Dinheiro");
        Contribuicao cont5 = new Contribuicao("Produtos de Higiene");


        cadastrar(contribuicoes);
        listar(contribuicoes);

        cadastrar(desastres);
        listar(desastres);

        cadastrar(incidentes);
        listarIncidentesPorData("20/03/2025");
        listarIncidentesPorLocal("Rio Grande do Sul");
        
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
            ler.nextLine(); 

            if (opcao == 1) {
                // Processo de login
                System.out.println("\nLogin:");

                System.out.print("\nE-mail: ");
                String email = ler.nextLine();

                if(verificarEmail(usuarios, email)){
                    System.out.print("Senha: ");
                    String senha = ler.nextLine();
                    verificarSenha(usuarios, email, senha);
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
                ler.nextLine(); 

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