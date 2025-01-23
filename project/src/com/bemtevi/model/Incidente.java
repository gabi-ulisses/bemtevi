package com.bemtevi.model;
import java.util.ArrayList;
import java.util.List;

    // Associação do desastre natural = o tipo do desastre
    // local e hora da ocorrência
    // Métodos: listarIncidentesPorData e listarIncidentesPorLocal 

public class Incidente {
    private DesastreNatural nome; // Associação com DesastreNatural
    private String local;                
    private String dataHora;              


    public Incidente(DesastreNatural nome, String local, String dataHora) {
        this.nome = nome;
        this.local = local;
        this.dataHora = dataHora;
    }

    public DesastreNatural getTipoDesastre() {
        return nome;
    }

    public void setTipoDesastre(DesastreNatural nome) {
        this.nome = nome;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getDataHora() {
        return dataHora;
    }

    public void setDataHora(String dataHora) {
        this.dataHora = dataHora;
    }

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
    
}
