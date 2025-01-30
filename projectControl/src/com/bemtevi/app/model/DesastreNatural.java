package com.bemtevi.app.model;
import java.util.List;

import com.bemtevi.app.service.Gerenciamento;

public class DesastreNatural implements Gerenciamento{
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
}
