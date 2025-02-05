package com.bemtevi.app.service;

import com.bemtevi.app.interfaces.Gerenciavel;
import com.bemtevi.app.model.Incidente;

import java.util.List;

/**
 * Classe responsável pela gestão de incidentes.
 * 
 * A classe implementa a interface `Gerenciavel` para fornecer os serviços de cadastro e listagem de incidentes.
 * 
 * Métodos disponíveis:
 * - `cadastrar`: Cadastra um novo incidente na lista.
 * - `listar`: Exibe todos os incidentes cadastrados.
 * - `listarIncidentesPorLocal`: Exibe os incidentes filtrados por local.
 */
public class IncidenteService implements Gerenciavel<Incidente> {

    @Override
    public void cadastrar(Incidente incidente, List<Incidente> lista) {
        lista.add(incidente);
        System.out.println("Incidente cadastrado com sucesso!");
    }

    @Override
    public List<Incidente> listar(List<Incidente> lista) {
        if (lista.isEmpty()) {
            System.out.println("Nenhum incidente cadastrado.");
        } else {
            System.out.println("Incidentes cadastrados:");
            for (Incidente incidente : lista) {
                System.out.println(incidente);
            }
        }
        return lista;
    }

    // Listar incidentes por local
    public void listarIncidentesPorLocal(String local, List<Incidente> lista) {
        System.out.println("Incidentes no local: " + local);
        for (Incidente incidente : lista) {
            if (incidente.getLocal().equalsIgnoreCase(local)) {
                System.out.println(incidente);
            }
        }
    }
}
