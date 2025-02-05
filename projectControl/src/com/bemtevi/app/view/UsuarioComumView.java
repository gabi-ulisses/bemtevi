package com.bemtevi.app.view;

import com.bemtevi.app.model.*;
import com.bemtevi.app.service.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UsuarioComumView {
    private static List<Incidente> incidentes = new ArrayList<>();
    private static List<Campanha> campanhas = new ArrayList<>();
    private static List<Contribuicao> contribuicoes = new ArrayList<>();
    private static IncidenteService incidenteService = new IncidenteService();
    private static CampanhaService campanhaService = new CampanhaService();
    private static ContribuicaoService contribuicaoService = new ContribuicaoService();

    public static void menu(Usuario usuarioLogado, List<Campanha> campanhas, Scanner ler) {

        while (true) {
            System.out.println("\n=== MENU USUÁRIO COMUM ===\n");
            System.out.println("1 - Cadastrar Incidente");
            System.out.println("2 - Listar Incidentes");
            System.out.println("3 - Listar Campanhas");
            System.out.println("4 - Cadastrar Contribuição");
            System.out.println("5 - Logout");
            System.out.print("\nOpção: ");
            int opcao = ler.nextInt();
            ler.nextLine();

            if (opcao == 1) {
                // Exibindo as opções de desastre
                System.out.println("\n  Qual a classificação do desastre?");
                Incidente.listarDesastres();  // Usando o método da classe Incidente

                String classificacao = "";
                boolean isValid = false;

                // Loop para garantir que o tipo de desastre seja válido
                while (!isValid) {
                    System.out.print("\n    Classificação: ");
                    classificacao = ler.nextLine();

                    // Verificando se a classificação corresponde a um valor válido do enum
                    isValid = false;
                    for (TipoDesastre desastre : TipoDesastre.values()) {
                        if (desastre.getDescricao().equalsIgnoreCase(classificacao)) {
                            isValid = true;
                            break;
                        }
                    }

                    if (!isValid && !classificacao.equalsIgnoreCase("Outro")) {
                        System.out.println("\nTipo de desastre inválido. Tente novamente.");
                    }
                }

                // Se for "Outro", permitir que o usuário digite a descrição
                if (classificacao.equalsIgnoreCase("Outro")) {
                    System.out.print("    Digite o nome do desastre: ");
                    classificacao = ler.nextLine();  // O usuário digita o tipo de desastre
                }

                System.out.print("    Local do incidente: ");
                String local = ler.nextLine();

                System.out.print("    Data e hora do incidente (dd/MM/yyyy HH:mm): ");
                String dataHoraStr = ler.nextLine();
                LocalDateTime dataHora = LocalDateTime.parse(dataHoraStr, Incidente.FORMATTER);

                // Criando o incidente com a descrição fornecida
                TipoDesastre tipoDesastre = TipoDesastre.valueOf(classificacao.toUpperCase());  // Transformando para o enum

                if (tipoDesastre == TipoDesastre.OUTRO) {
                    // Para o caso "OUTRO", vamos usar a descrição personalizada digitada
                    incidenteService.cadastrar(new Incidente(tipoDesastre, local, dataHora, classificacao), incidentes);
                } else {
                    // Para os outros tipos, usamos o enum diretamente
                    incidenteService.cadastrar(new Incidente(tipoDesastre, local, dataHora), incidentes);
                }

            } else if (opcao == 2) {
                // Apresentar as opções para listar incidentes
                System.out.println("\n=== LISTAR INCIDENTES ===\n");
                System.out.println("    1 - Listagem geral de incidentes");
                System.out.println("    2 - Listar Incidentes por Hora");
                System.out.println("    3 - Listar Incidentes por Local");
                System.out.print("\nOpção: ");
                int opcaoListagem = ler.nextInt();
                ler.nextLine();  // Consumir o newline deixado pelo nextInt()

                if (opcaoListagem == 1) {
                    incidenteService.listar(incidentes);  // Listagem geral de incidentes
                } else if (opcaoListagem == 2) {
                    System.out.print("Digite a data e hora(formato dd/MM/yyyy): ");
                    String dataHora = ler.nextLine();
                    incidenteService.listarIncidentesPorDataHora(dataHora, incidentes);  // Listar incidentes por data
                } else if (opcaoListagem == 3) {
                    System.out.print("Digite o local: ");
                    String local = ler.nextLine();
                    incidenteService.listarIncidentesPorLocal(local, incidentes);  // Listar incidentes por local
                } else {
                    System.out.println("Opção inválida!");
                }
            } else if (opcao == 3) {
                campanhaService.listar(campanhas);
            } else if (opcao == 4) {
                System.out.println("\n=== CAMPANHAS DISPONÍVEIS ===\n");
                for (int i = 0; i < campanhas.size(); i++) {
                    Campanha campanha = campanhas.get(i);
                    System.out.println((i + 1) + " - " + campanha.getNome() + " - " + campanha.getDescricao());
                }
    
                System.out.print("\nEscolha a campanha para contribuir (número): ");
                int escolhaCampanha = ler.nextInt();
                ler.nextLine(); // Consumir o newline
    
                if (escolhaCampanha >= 1 && escolhaCampanha <= campanhas.size()) {
                    Campanha campanhaSelecionada = campanhas.get(escolhaCampanha - 1);

                    // Perguntar o tipo de contribuição
                    System.out.println("\nEscolha o tipo de contribuição:");
                    System.out.println("1 - Alimentos");
                    System.out.println("2 - Dinheiro");
                    System.out.println("3 - Roupas");
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
                    }

                    // Criando a contribuição associada ao usuário e à campanha
                    Contribuicao contribuicao = new Contribuicao(tipoContribuicao, usuarioLogado, campanhaSelecionada);
                    contribuicaoService.cadastrar(contribuicao, contribuicoes);

                    System.out.println("Contribuição registrada com sucesso!");
                } else {
                    System.out.println("Opção inválida! Nenhuma contribuição foi registrada.");
                }

            } else if(opcao == 5){
                System.out.println("\n          Obrigada por utilizar nosso sistema, " + usuarioLogado.getNome() +"!");
                break;
            }else{
                System.out.println("\nOpção inválida!");
            }
        }
    }
}