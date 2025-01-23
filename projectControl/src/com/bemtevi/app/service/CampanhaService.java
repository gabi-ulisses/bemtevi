package com.bemtevi.app.service;

import com.bemtevi.app.model.Campanha;

import java.util.List;

public class CampanhaService implements Gerenciamento {

    @Override
    public void cadastrar(List<Campanha> campanhas) {
        // Lógica para cadastrar uma nova campanha
        Campanha novaCampanha = new Campanha(new Contribuicao(), 1, "Campanha A", "Descrição da campanha", true, 5000.0, 30, "São Paulo");
        campanhas.add(novaCampanha);
        System.out.println("Campanha cadastrada: " + novaCampanha.getNome());
    }

    @Override
    public void listar(List<Campanha> campanhas) {
        if (campanhas.isEmpty()) {
            System.out.println("Nenhuma campanha cadastrada.");
        } else {
            System.out.println("Campanhas disponíveis:");
            for (Campanha campanha : campanhas) {
                System.out.println(campanha);
            }
        }
    }
}
