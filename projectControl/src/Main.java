import com.bemtevi.app.model.*;
import com.bemtevi.app.service.*;
import com.bemtevi.app.view.AdministradorView;
import com.bemtevi.app.view.OngView;
import com.bemtevi.app.view.UsuarioComumView;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

        boolean continua = true;

        Administrador admin = new Administrador();
        usuarios.add(admin);

        while (continua) {
            System.out.println("\n\nEscolha uma opção:\n\n    1 - Login\n    2 - Cadastro\n    3 - Fechar\n");
            System.out.print("Opção: ");
            int escolha = ler.nextInt();
            ler.nextLine();

            Usuario usuarioLogado = null;
            switch (escolha) {
                case 1:
                    {
                        // LOGIN
                        System.out.print("\n    Email: ");
                        String email = ler.nextLine();
                        System.out.print("    Senha: ");
                        String senha = ler.nextLine();
                        usuarioLogado = usuarioService.autenticar(usuarios, email, senha);
                        if (usuarioLogado != null) {
                            
                            // Acesso ao menu do usuário após login bem-sucedido
                            
                            if (usuarioLogado instanceof Administrador) {
                                AdministradorView.menu(usuarios, incidentes, campanhas, ler);
                            } else if (usuarioLogado instanceof Ong) {
                                
                                Ong ongLogada = (Ong) usuarioLogado; // Passa diretamente o objeto Ong para o menu
                                OngView.menu(ongLogada, campanhas, ler);
                            } else {
                                UsuarioComumView.menu(usuarioLogado, campanhas, ler);
                            }
                        } else {
                            System.out.println("Falha na autenticação!");
                        }       break;
                    }
                case 2:
                    {
                        // CADASTRO
                        System.out.print("\n    Informe seus dados para realizar o cadastro:\n\n");
                        System.out.print("      Nome: ");
                        String nome = ler.nextLine();
                        System.out.print("      Email: ");
                        String email = ler.nextLine();
                        System.out.print("      Telefone: ");
                        String telefone = ler.nextLine();
                        System.out.print("      Senha: ");
                        String senha = ler.nextLine();
                        System.out.print("      Tipo de usuário (1 - Usuário Comum, 2 - ONG): ");
                        int tipo = ler.nextInt();
                        ler.nextLine();
                        if (tipo == 1) {
                            usuarioLogado = new UsuarioComum(nome, email, telefone, senha);
                        } else if (tipo == 2) {
                            System.out.print("      CNPJ: ");
                            String cnpj = ler.nextLine();
                            usuarioLogado = new Ong(nome, email, telefone, senha, cnpj);
                        }       if (usuarioLogado != null) {
                            usuarios.add(usuarioLogado);
                            System.out.println("\nCadastro realizado com sucesso!");
                        } else {
                            System.out.println("Tipo de usuário inválido!");
                        }       break;
                    }
                case 3:
                    // SAIR
                    System.out.println("Saindo...");
                default:
                    break;
            }
        }

        ler.close();
    }
}
