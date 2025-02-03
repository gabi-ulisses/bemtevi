package com.bemtevi.app.view;

import com.bemtevi.app.model.*;
import com.bemtevi.app.service.CampanhaService;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdministradorView {
    private static final List<Campanha> campanhas = new ArrayList<>();
    private static final CampanhaService campanhaService = new CampanhaService();

    public static void menu(List<Usuario> usuarios, List<Incidente> incidentes) {
        Scanner ler = new Scanner(System.in); 
        boolean continua = true;

        while (continua) {
            System.out.println("\n=== MENU ADMINISTRADOR ===");
            System.out.println("1 - Listar Campanhas");
            System.out.println("2 - Listar Usuários");
            System.out.println("3 - Gerar Relatórios");
            System.out.println("4 - Sair");
            System.out.print("Opção: ");
            int opcao = ler.nextInt();
            ler.nextLine();

            switch (opcao) {
                case 1:
                    listarCampanhas();
                    break;
                case 2:
                    listarUsuarios(usuarios);
                    break;
                case 3:
                    gerarRelatorios(usuarios, incidentes);
                    break;
                case 4:
                    continua = false;
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }
        ler.close(); 
    }

    private static void listarCampanhas() {
        if (campanhas.isEmpty()) {
            System.out.println("Nenhuma campanha cadastrada.");
        } else {
            System.out.println("Campanhas cadastradas:");
            for (Campanha campanha : campanhas) {
                System.out.println("- " + campanha.getNome() + " (Código: " + campanha.getCodigo() + ")");
            }
        }
    }

    private static void listarUsuarios(List<Usuario> usuarios) {
        if (usuarios.isEmpty()) {
            System.out.println("Nenhum usuário cadastrado.");
        } else {
            System.out.println("Usuários cadastrados:");
            for (Usuario usuario : usuarios) {
                System.out.println("- " + usuario.getNome() + " (" + usuario.getEmail() + ")");
            }
        }
    }

    private static void gerarRelatorios(List<Usuario> usuarios, List<Incidente> incidentes) {
        int totalCampanhas = campanhas.size();
        int totalUsuarios = usuarios.size();
        int totalIncidentes = incidentes.size();

        System.out.println("\n=== RELATÓRIO ===");
        System.out.println("Total de Campanhas: " + totalCampanhas);
        System.out.println("Total de Usuários: " + totalUsuarios);
        System.out.println("Total de Incidentes: " + totalIncidentes);
    }
}
