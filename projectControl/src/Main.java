
 import com.bemtevi.app.model.*;
 import com.bemtevi.app.service.*;
 import com.bemtevi.app.view.AdministradorView;
 import com.bemtevi.app.view.OngView;
 import com.bemtevi.app.view.UsuarioComumView;
 import java.util.ArrayList;
 import java.util.List;
 import java.util.Scanner;

 /*
 * Aplicação: BemTeVi
 * 
 * Descrição:
 *   Este programa representa a aplicação principal do sistema BemTeVi, 
 *   permitindo a autenticação e gerenciamento de usuários, campanhas e incidentes. 
 *   Ele oferece opções de login, cadastro e interação com menus específicos
 *   para administradores, ONGs e usuários comuns.
 * 
 * Funcionalidades:
 *   - Exibição da tela de boas-vindas
 *   - Login com autenticação MFA para administradores
 *   - Cadastro de usuários comuns e ONGs
 *   - Redirecionamento para menus específicos conforme o tipo de usuário
 *   - Encerramento da aplicação
 * 
 * Autores: Gabrielle Ulisses e Ana Beatriz R. Duarte
 * Data: 05/02/2025
 */
 
public class Main {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        List<Usuario> usuarios = new ArrayList<>();
        List<Incidente> incidentes = new ArrayList<>();
        List<Campanha> campanhas = new ArrayList<>();
        UsuarioService usuarioService = new UsuarioService();

        System.out.println("\n\n");
        System.out.println("  BBBBB   EEEEE  M     M  TTTTT  EEEEE  V   V  III");
        System.out.println("  B    B  E      MM   MM    T    E      V   V   I ");
        System.out.println("  BBBBB   EEEE   M M M M    T    EEEE   V   V   I ");
        System.out.println("  B    B  E      M  M  M    T    E      V   V   I ");
        System.out.println("  BBBBB   EEEEE  M     M    T    EEEEE   VVV    I ");
        System.out.println("\n\nBem-vindo!");

        
        Administrador admin = new Administrador();
        usuarios.add(admin);

        boolean continua = true;

        while (continua) {
            System.out.println("\n\nEscolha uma opção:\n\n    1 - Login\n    2 - Cadastro\n    3 - Fechar\n");
            System.out.print("Opção: ");
            int escolha = ler.nextInt();
            ler.nextLine();

            Usuario usuarioLogado = null;

            if ((escolha != 1) && (escolha != 2) && (escolha != 3)) {
                System.out.println("\nOpção inválida!");
            }else {
                switch (escolha) {
                    case 1:
                        System.out.print("\n    Email: ");
                        String email = ler.nextLine();
                        System.out.print("    Senha: ");
                        String senha = ler.nextLine();

                        usuarioLogado = usuarioService.autenticar(usuarios, email, senha);

                        if (usuarioLogado != null) {
                            if (usuarioLogado instanceof Administrador) {
                                System.out.print("\n    Confirme o código MFA: ");
                                String codigoMFA = ler.nextLine();

                                if (((Administrador) usuarioLogado).validarMFA(codigoMFA)) {
                                    AdministradorView.menu((Administrador) usuarioLogado, usuarios, incidentes, campanhas, ler);
                                } else {
                                    System.out.println("Código MFA inválido! Acesso negado.");
                                }
                            } else if (usuarioLogado instanceof Ong) {
                                OngView.menu((Ong) usuarioLogado, campanhas, ler);
                            } else {
                                UsuarioComumView.menu(usuarioLogado, campanhas, ler);
                            }
                        } else {
                            System.out.println("Falha na autenticação!");
                        }
                        break;
                    case 2:
                        System.out.print("\n    Informe seus dados para realizar o cadastro:\n\n");
                        System.out.print("      Nome: ");
                        String nome = ler.nextLine();
                        System.out.print("      Email: ");
                        email = ler.nextLine();
                        System.out.print("      Telefone: ");
                        String telefone = ler.nextLine();
                        System.out.print("      Senha: ");
                        senha = ler.nextLine();
                        System.out.print("      Tipo de usuário (1 - Usuário Comum, 2 - ONG): ");
                        int tipo = ler.nextInt();
                        
                        if (tipo == 1) {
                            usuarioLogado = new UsuarioComum(nome, email, telefone, senha);
                        } else if (tipo == 2) {
                            System.out.print("      CNPJ: ");
                            String cnpj = ler.nextLine();
                            usuarioLogado = new Ong(nome, email, telefone, senha, cnpj);
                        }

                        if (usuarioLogado != null) {
                            usuarios.add(usuarioLogado);
                            System.out.println("\nCadastro realizado com sucesso!");
                        } else {
                            System.out.println("Erro no cadastro!");
                        }
                        break;
                    case 3:
                        System.out.println("Saindo...");
                        continua = false;
                        break;
                    default:
                        break;
                }
            }
        }
        ler.close(); 
    }
}
