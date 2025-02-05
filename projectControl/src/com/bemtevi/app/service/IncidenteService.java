package com.bemtevi.app.service;

import com.bemtevi.app.interfaces.Gerenciavel;
import com.bemtevi.app.model.Campanha;
import com.bemtevi.app.model.Incidente;
import java.time.LocalDate;
import java.util.List;

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
        }else{
            System.out.println("Incidentes cadastrados:");
            for (Incidente incidente : lista) {
                System.out.println(incidente);
            }
        }
        return lista;
    }

    // Listar incidentes por data
    public void listarIncidentesPorDataHora(String data, List<Incidente> lista) {
        LocalDate dataConsultada = LocalDate.parse(data); // Converte a string de data para LocalDate

        System.out.println("Incidentes na data: " + data);
        for (Incidente incidente : lista) {
            // Verifica se a data do incidente é igual à data consultada
            if (incidente.getDataHora().toLocalDate().isEqual(dataConsultada)) {
                System.out.println(incidente);
            }
        }
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