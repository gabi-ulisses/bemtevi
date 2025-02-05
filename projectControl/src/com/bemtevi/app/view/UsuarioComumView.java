package com.bemtevi.app.view;

import com.bemtevi.app.model.*;
import com.bemtevi.app.service.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Classe responsável pela visualização das interações do usuário comum com o sistema.
 * 
 * Essa classe fornece um menu interativo com opções para o usuário realizar ações como:
 * - Cadastrar incidentes.
 * - Listar incidentes, seja de forma geral ou filtrada por local.
 * - Listar campanhas disponíveis.
 * - Registrar contribuições em campanhas.
 * - Fazer logout do sistema.
 * 
 * Os incidentes e contribuições são manipulados por meio dos serviços relacionados às suas respectivas entidades,
 * como IncidenteService, CampanhaService e ContribuicaoService. Além disso, o sistema permite a escolha de desastres
 * e contribuições, incluindo a possibilidade de cadastrar um novo tipo de desastre ou contribuição.
 * 
 * O método `menu` é o ponto de entrada para a interação do usuário, sendo um loop contínuo até que o usuário
 * escolha a opção de logout.
 * 
 * A classe depende de instâncias de:
 * - IncidenteService: Para gerenciar a criação e listagem de incidentes.
 * - CampanhaService: Para listar campanhas disponíveis.
 * - ContribuicaoService: Para registrar contribuições em campanhas.
 * 
*/

public class UsuarioComumView {
    private static List<Incidente> incidentes = new ArrayList<>();
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

            switch (opcao) {
                case 1:
  
                    System.out.println("\n  Qual a classificação do desastre?");
                    Incidente.listarDesastres();  // Usando o método da classe Incidente

                    String classificacao = "";
                    boolean isValid = false;

                        // Loop para garantir que o tipo de desastre seja válido
                        while (!isValid) {
                            System.out.print("\n    Classificação: ");
                            classificacao = ler.nextLine();

                            // Verificando se a classificação corresponde a um valor válido do enum
                            isValid = TipoDesastre.existeTipoDesastre(classificacao);

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

                        TipoDesastre tipoDesastre;
                        if (TipoDesastre.existeTipoDesastre(classificacao)) {
                            tipoDesastre = TipoDesastre.valueOf(classificacao.toUpperCase());  // Transformando para o enum
                        } else {
                            tipoDesastre = TipoDesastre.OUTRO;  // Se não corresponder, define como "OUTRO"
                        }

                        if (tipoDesastre == TipoDesastre.OUTRO) {
                            // Para o caso "OUTRO", vamos usar a descrição personalizada digitada
                            incidenteService.cadastrar(new Incidente(tipoDesastre, local, classificacao), incidentes);
                        } else {
                            // Para os outros tipos, usamos o enum diretamente
                            incidenteService.cadastrar(new Incidente(tipoDesastre, local), incidentes);
                        }

                    break;

                case 2:
                    if (incidentes.isEmpty()) {
                        System.out.println("\nNenhum incidente cadastrado.");
                    } else {
                        // Apresentar as opções para listar incidentes
                        System.out.println("\n=== LISTAR INCIDENTES ===\n");
                        System.out.println("    1 - Listagem geral de incidentes");
                        System.out.println("    2 - Listar Incidentes por Local");
                        System.out.print("\nOpção: ");
                        int opcaoListagem = ler.nextInt();
                        ler.nextLine();  // Consumir o newline deixado pelo nextInt()

                        switch (opcaoListagem) {
                            case 1:
                                incidenteService.listar(incidentes);  // Listagem geral de incidentes
                                break;
                            case 2:
                                System.out.print("Digite o local: ");
                                String localConsulta = ler.nextLine();
                                incidenteService.listarIncidentesPorLocal(localConsulta, incidentes);  // Listar incidentes por local
                                break;
                            default:
                                System.out.println("Opção inválida!");
                                break;
                        }
                    }
                    break;

                case 3:
                    if (campanhas.isEmpty()) {
                        System.out.println("\nNenhuma campanha cadastrada.");
                    } else {
                        campanhaService.listar(campanhas);
                    }
                    break;

                case 4:
                    if (campanhas.isEmpty()) {
                        System.out.println("\nNenhuma campanha cadastrada para contribuir.");
                    } else {
                        System.out.println("\n=== CAMPANHAS DISPONÍVEIS ===\n");
                        for (int i = 0; i < campanhas.size(); i++) {
                            Campanha campanha = campanhas.get(i);
                            System.out.println((i + 1) + " - " + campanha.getNome() + " - " + campanha.getDescricao());
                        }

                        System.out.print("\nEscolha a campanha para contribuir (número): ");
                        int escolhaCampanha = ler.nextInt();
                        ler.nextLine(); 

                        if (escolhaCampanha >= 1 && escolhaCampanha <= campanhas.size()) {
                            Campanha campanhaSelecionada = campanhas.get(escolhaCampanha - 1);

                            // Perguntar o tipo de contribuição
                            System.out.println("\nEscolha o tipo de contribuição:");
                            System.out.println("    1 - Alimentos");
                            System.out.println("    2 - Dinheiro");
                            System.out.println("    3 - Roupas");
                            System.out.print("\nContribuir com: ");
                            int tipoContribuicaoEscolhido = ler.nextInt();
                            ler.nextLine(); 

                            TipoContribuicao tipoContribuicao = TipoContribuicao.ALIMENTOS; 
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
                                    break;
                            }

                            // Criando a contribuição associada ao usuário e à campanha
                            Contribuicao contribuicao = new Contribuicao(tipoContribuicao, usuarioLogado, campanhaSelecionada);
                            contribuicaoService.cadastrar(contribuicao, contribuicoes);

                            System.out.println("Contribuição registrada com sucesso!");
                        } else {
                            System.out.println("Opção inválida! Nenhuma contribuição foi registrada.");
                        }
                    }
                    break;

                case 5:
                    System.out.println("\n          Obrigada por utilizar nosso sistema, " + usuarioLogado.getNome() +"!");
                    return;  // Termina o loop e sai do método

                default:
                    System.out.println("\nOpção inválida!");
                    break;
            }
        }
    }
}