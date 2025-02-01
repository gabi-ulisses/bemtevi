package com.bemtevi.app.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.bemtevi.app.model.Campanha;
import com.bemtevi.app.service.CampanhaService;

public class AdministradorView {
    private static List<Campanha> campanhas = new ArrayList<>();
    private static CampanhaService campanhaService = new CampanhaService();

    public static void menu() {
        Scanner ler = new Scanner(System.in);
        while (true) {
            System.out.println("\n=== MENU ADMINISTRADOR ===");
            System.out.println("1 - Cadastrar Campanha");
            System.out.println("2 - Gerar Relatórios");
            System.out.println("3 - Sair");
            int opcao = ler.nextInt();
            ler.nextLine();

            if (opcao == 1) {
                System.out.print("Nome da campanha: ");
                String nome = ler.nextLine();
                campanhaService.cadastrar(new Campanha(nome), campanhas);
            } else if (opcao == 2) {
                System.out.println("Gerando relatório...");
            } else {
                break;
            }
        }
        ler.close();
    }
}
