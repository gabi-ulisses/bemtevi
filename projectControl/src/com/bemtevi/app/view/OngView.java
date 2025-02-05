package com.bemtevi.app.view;

import com.bemtevi.app.model.*;
import com.bemtevi.app.service.*;

import java.util.List;
import java.util.Scanner;

/**
 * Classe responsável pela visualização das interações da ONG com o sistema.
 * 
 * O menu da ONG oferece opções para cadastrar campanhas, listar campanhas associadas à ONG logada e realizar o logout.
 * A criação de campanhas envolve a escolha do tipo de contribuição (alimentos, dinheiro, roupas), e o cadastro de dados
 * adicionais, como causa, código, nome, descrição, identificação fiscal, meta de arrecadação, duração e local de atuação.
 * 
 * A classe utiliza os serviços relacionados ao gerenciamento de campanhas, como o CampanhaService, para cadastrar e listar campanhas.
 * 
 */
public class OngView {
    private static CampanhaService campanhaService = new CampanhaService();

    public static void menu(Ong onglogada, List<Campanha> campanhas, Scanner ler) {

        while (true) {
            System.out.println("\n=== MENU ONG ===\n ");
            System.out.println("1 - Cadastrar Campanha");
            System.out.println("2 - Listar minhas campanhas");
            System.out.println("3 - Logout");
            System.out.print("\nOpção: ");
            int opcao = ler.nextInt();
            ler.nextLine(); // Consumir o newline após o nextInt

            switch (opcao) {
                case 1:
                    // Perguntar tipo de contribuição
                    System.out.println("\n  Escolha o tipo de contribuição da campanha:");
                    System.out.println("1 - Alimentos");
                    System.out.println("2 - Dinheiro");
                    System.out.println("3 - Roupas");
                    System.out.print("\nOpção: ");
                    int tipoContribuicaoEscolhido = ler.nextInt();
                    ler.nextLine(); // Consumir o newline

                    TipoContribuicao tipoContribuicao = TipoContribuicao.ALIMENTOS; // Default
                    switch (tipoContribuicaoEscolhido) {
                        case 1:
                            tipoContribuicao = TipoContribuicao.ALIMENTOS;
                            break;
                        case 2:
                            tipoContribuicao = TipoContribuicao.DINHEIRO;
                            break;
                        case 3:
                            tipoContribuicao = TipoContribuicao.ROUPAS;
                            break;
                        default:
                            System.out.println("Opção inválida. Tipo de contribuição será considerado 'Alimentos'.");
                            tipoContribuicao = TipoContribuicao.ALIMENTOS; // Default
                            break;
                    }

                    // Perguntar a causa da campanha
                    System.out.print("Causa da campanha: ");
                    String causa = ler.nextLine();

                    // Outras informações da campanha
                    System.out.print("Código da campanha: ");
                    String codigo = ler.nextLine();
                    System.out.print("Nome da campanha: ");
                    String nome = ler.nextLine();
                    System.out.print("Descrição da campanha: ");
                    String descricao = ler.nextLine();
                    System.out.print("Identificação Fiscal (true/false): ");
                    boolean identificacaoFiscal = ler.nextBoolean();
                    System.out.print("Meta de arrecadação: ");
                    double metaArrecadacao = ler.nextDouble();
                    System.out.print("Duração (em dias): ");
                    int duracao = ler.nextInt();
                    ler.nextLine(); // Consumir o newline após o nextInt
                    System.out.print("Local de atuação: ");
                    String localAtuacao = ler.nextLine();

                    // Criação da campanha associada à ONG logada
                    Campanha novaCampanha = new Campanha(onglogada, tipoContribuicao, causa, codigo, nome, descricao, identificacaoFiscal, metaArrecadacao, duracao, localAtuacao);

                    // Cadastrar a campanha
                    campanhaService.cadastrar(novaCampanha, campanhas);
                    break;

                case 2:
                    campanhaService.listarCampanhasDaOng(onglogada, campanhas);
                    break;

                case 3:
                    System.out.println("\n          Obrigada por utilizar nosso sistema, " + onglogada.getNome() +"!");
                    return;  // Termina o loop e sai do método

                default:
                    System.out.println("\nOpção inválida! Tente novamente.");
                    break;
            }
        }
    }
}