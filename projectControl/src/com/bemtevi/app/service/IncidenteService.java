package com.bemtevi.app.service;

public class IncidenteService implements Gerenciamento{

    @override
    public void cadastrar(List<Incidente> incidentes) {
        for (Incidente i : incidentes) {
            incidentes.add(i);        
        }
    }

    // Listar incidentes por data
    public static void listarIncidentesPorData(String data) {
        System.out.println("Incidentes na data: " + data);
        for (Incidente incidente : incidentes) {
            if (incidente.getDataHora().startsWith(data)) {
                System.out.println(incidente);
            }
        }
    }

    // Listar incidentes por local
    public static void listarIncidentesPorLocal(String local) {
        System.out.println("Incidentes no local: " + local);
        for (Incidente incidente : incidentes) {
            if (incidente.getLocal().equalsIgnoreCase(local)) {
                System.out.println(incidente);
            }
        }
    }

    // Listar todos os incidentes
    @Override
    public void listar(List<Incidente> incidentes) {
        for (Usuario i : incidentes) {
            System.out.println("Local: " + i.getLocal() + ", Nome: " + i.getNome() + ", Data e  Hora: " + i.getDataHora());
        }
    }
}
