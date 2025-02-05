package com.bemtevi.app.view;

import com.bemtevi.app.model.*;
import com.bemtevi.app.service.AdministradorService;
import java.util.List;
import java.util.Scanner;

/**
 * Classe responsável pela visualização das interações do Administrador com o sistema.
 * 
 * O menu do Administrador oferece opções para listar campanhas, listar usuários, gerar relatórios gerais de cadastros
 * e realizar o logout. A classe interage com os serviços relacionados à gestão de campanhas, usuários e relatórios,
 * facilitando a administração do sistema.
 */
public class AdministradorView {
    public static void menu(Administrador administrador, List<Usuario> usuarios, List<Incidente> incidentes, List<Campanha> campanhas, Scanner ler) {
        boolean continua = true;

        while (continua) {
            System.out.println("\n=== MENU ADMINISTRADOR ===\n");
            System.out.println("    1 - Listar Campanhas");
            System.out.println("    2 - Listar Usuários");
            System.out.println("    3 - Relatório geral de cadastros");
            System.out.println("    4 - Logout\n");
            System.out.print("Opção: ");
            int opcao = ler.nextInt();
            ler.nextLine();

            switch (opcao) {
                case 1:
                    AdministradorService.listarCampanhas(campanhas);
                    break;
                case 2:
                    AdministradorService.listarUsuarios(usuarios);
                    break;
                case 3:
                    AdministradorService.gerarRelatorios(usuarios, incidentes, campanhas);
                    break;
                case 4:
                    continua = false;
                    System.out.println("\n          Obrigada por utilizar nosso sistema, " + administrador.getNome() +"!");
                    break;
                default:
                    System.out.println("\nOpção inválida! Tente novamente.");
            }
        }
    }
}