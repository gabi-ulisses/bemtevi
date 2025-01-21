package com.bemtevi.model;
import java.util.ArrayList;
import java.util.List;

    // Associação do desastre natural = o tipo do desastre
    // local e hora da ocorrência
    // Métodos: listarIncidentesPorData e listarIncidentesPorLocal 

public class Incidente {
    private DesastreNatural tipoDesastre; // Associação com DesastreNatural
    private String local;                
    private String dataHora;              

    private static List<Incidente> incidentes = new ArrayList<>();

    public Incidente(DesastreNatural tipoDesastre, String local, String dataHora) {
        this.tipoDesastre = tipoDesastre;
        this.local = local;
        this.dataHora = dataHora;
    }

    public DesastreNatural getTipoDesastre() {
        return tipoDesastre;
    }

    public void setTipoDesastre(DesastreNatural tipoDesastre) {
        this.tipoDesastre = tipoDesastre;
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

    public static void adicionarIncidente(Incidente incidente) {
        incidentes.add(incidente);
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
    

    @Override
    public String toString() {
        return "Incidente{" +
                "tipoDesastre=" + tipoDesastre +
                ", local='" + local + '\'' +
                ", dataHora='" + dataHora + '\'' +
                '}';
    }
}
