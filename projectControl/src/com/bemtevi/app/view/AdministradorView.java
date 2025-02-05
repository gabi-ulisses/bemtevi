package com.bemtevi.app.view;

import com.bemtevi.app.model.*;
import com.bemtevi.app.service.AdministradorService;
import java.util.List;
import java.util.Scanner;

public class AdministradorView {
    public static void menu(List<Usuario> usuarios, List<Incidente> incidentes,List<Campanha> campanhas, Scanner ler) {
        boolean continua = true;

        while (continua) {
            System.out.println("\n=== MENU ADMINISTRADOR ===\n");
            System.out.println("    1 - Listar Campanhas");
            System.out.println("    2 - Listar Usuários");
            System.out.println("    3 - Gerar Relatórios");
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
                    break;
                default:
                    System.out.println("\nOpção inválida! Tente novamente.");
            }
        }
    }
}
