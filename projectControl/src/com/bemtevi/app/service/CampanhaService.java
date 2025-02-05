package com.bemtevi.app.service;

import com.bemtevi.app.model.Campanha;
import com.bemtevi.app.model.Ong;
import com.bemtevi.app.interfaces.Gerenciavel;

import java.util.List;

/**
 * Classe responsável pelos serviços de gerenciamento de campanhas.
 * 
 * A classe implementa a interface Gerenciavel<Campanha> e oferece métodos para:
 * - Cadastrar novas campanhas
 * - Listar todas as campanhas cadastradas
 * - Listar campanhas específicas de uma ONG logada
 * 
 * Os métodos interagem com a lista de campanhas e permitem que a ONG gerencie suas campanhas, 
 * como visualizar suas próprias campanhas e visualizar todas as campanhas cadastradas no sistema.
 */
public class CampanhaService implements Gerenciavel<Campanha> {

    @Override
    public void cadastrar(Campanha campanha, List<Campanha> lista) {
        lista.add(campanha);
        System.out.println("Campanha cadastrada: " + campanha.getNome());
    }

    @Override
    public List<Campanha> listar(List<Campanha> lista) {
        if (lista.isEmpty()) {
            System.out.println("Nenhuma campanha cadastrada.");
        } else {
            System.out.println("Campanhas disponíveis:");
            for (Campanha item : lista) {
                System.out.println(item);
            }
        }
        return lista;
    }

    // Método para listar as campanhas de uma ONG específica
    public void listarCampanhasDaOng(Ong ong, List<Campanha> lista) {
        boolean encontrou = false;
        System.out.println("\nMinhas campanhas:");
        for (Campanha campanha : lista) {
            if (campanha.getOrganizacao().equals(ong)) { // Verifica se a campanha pertence à ONG
                System.out.println("Código da Campanha: " + campanha.getCodigo() + 
                                   ", Nome: " + campanha.getNome() + 
                                   ", Tipo de Contribuição: " + campanha.getTipoContribuicao().getDescricao());
                encontrou = true;
            }
        }
        if (!encontrou) {
            System.out.println("Nenhuma campanha encontrada para esta ONG.");
        }
    }
}