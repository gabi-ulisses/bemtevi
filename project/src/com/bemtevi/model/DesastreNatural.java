package com.bemtevi.model;
import java.util.List;

public class DesastreNatural {
    private String nome;

    public DesastreNatural(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @override
    public void cadastrar(List<DesastreNatural> desastres){
        for (DesastreNatural d : desastres) {
            desastres.add(d);        
        }
    }

    public void listar(List<DesastreNatural> desastres){
        if (desastres.isEmpty()) {
            System.out.println("Nenhum desastre cadastrada.");
        } else {
            System.out.println("Desastres disponíveis:");
            for (DesastreNatural d : desastres) {
                System.out.println(d);
            }
        }
    }

    @Override
    public String toString() {
        return nome;
    }
    
}
