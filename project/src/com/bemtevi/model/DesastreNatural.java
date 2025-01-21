package com.bemtevi.model;

import java.util.ArrayList;
import java.util.List;

public class DesastreNatural {
    private String nome;

    private static List<DesastreNatural> desastres = new ArrayList<>();


    public DesastreNatural(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public static void adicionarDesastre(DesastreNatural desastre) {
        desastres.add(desastre);
    }

    public static List<DesastreNatural> listarDesastres() {
        return desastres;
    }

    @Override
    public String toString() {
        return nome;
    }

    static {
        adicionarDesastre(new DesastreNatural("Enchente"));
        adicionarDesastre(new DesastreNatural("Terremoto"));
        adicionarDesastre(new DesastreNatural("Tsunami"));
        adicionarDesastre(new DesastreNatural("Incêndio Florestal"));
        adicionarDesastre(new DesastreNatural("Furacão"));
    }
    
}
