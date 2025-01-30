package com.bemtevi.app.model;
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

    
}
