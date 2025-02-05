package com.bemtevi.app.service;

import com.bemtevi.app.model.*;
import java.util.List;

public class AdministradorService {

    public AdministradorService(){}

    public static List<Campanha> listarCampanhas(List<Campanha> campanhas) {
        if (campanhas.isEmpty()) {
            System.out.println("\nNenhuma campanha cadastrada.");
        } else {
            System.out.println("\nCampanhas cadastradas:");
            for (Campanha campanha : campanhas) {
                System.out.println(campanha);
            }
        }
        return campanhas;
    }

    public static List<Usuario> listarUsuarios(List<Usuario> usuarios) {
        if (usuarios.isEmpty()) {
            System.out.println("\nNenhum usuário cadastrado.");
        } else {
            System.out.println("\nUsuários cadastrados:");
            for (Usuario usuario : usuarios) {
                System.out.println(usuario);
            }
        }
        return usuarios;
    }

    public static void gerarRelatorios(List<Usuario> usuarios, List<Incidente> incidentes, List<Campanha> campanhas) {
        int totalCampanhas = campanhas.size();
        int totalUsuarios = usuarios.size();
        int totalIncidentes = incidentes.size();

        System.out.println("\n=== RELATÓRIO ===\n");
        System.out.println("    Total de Campanhas: " + totalCampanhas);
        System.out.println("    Total de Usuários: " + totalUsuarios);
        System.out.println("    Total de Incidentes: " + totalIncidentes);
    }
}
