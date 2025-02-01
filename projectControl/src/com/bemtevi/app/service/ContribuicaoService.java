package com.bemtevi.app.service;

import com.bemtevi.app.interfaces.Gerenciavel;
import com.bemtevi.app.model.Contribuicao;

import java.util.List;

public class ContribuicaoService implements Gerenciavel<Contribuicao> {

    @Override
    public void cadastrar(Contribuicao contribuicao, List<Contribuicao> lista) {
        lista.add(contribuicao);
        System.out.println("Contribuição cadastrada: " + contribuicao.getTipoContribuicao());
    }

    @Override
    public List<Contribuicao> listar(List<Contribuicao> lista) {
        if (lista.isEmpty()) {
            System.out.println("Nenhuma contribuição cadastrada.");
        } else {
            System.out.println("Contribuições disponíveis:");
            for (Contribuicao item : lista) {
                System.out.println("- " + item.getTipoContribuicao());
            }
        }
        return lista;
    }
}
