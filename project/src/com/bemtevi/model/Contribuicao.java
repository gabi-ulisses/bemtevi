package com.bemtevi.model;

public class Contribuicao {
    // TipoContribuicao: alimento, dinheiro, roupas, brinquedos

      
    /*
        Métodos:

     *  valorArrecadado - se for Dinheiro
     *  kilosArrecadado - se for Alimento, roupas e brinquedos
     */


    private String TipoContribuicao;

    public Contribuicao(String TipoContribuicao){
        this.TipoContribuicao = TipoContribuicao;
    }

    public String getTipoContribuicao(){
        return TipoContribuicao;
    }

    public void setTipoContribuicao(String tipoContribuicao){
        this.tipoContribuicao = tipoContribuicao;
    }

    @Override
    public void cadastrar(List<Contribuicao> contribuicoes) {
        for (Contribuicao c : Contribuicao) {
            campanhas.add(c);        
        }
    }


    @Override
    public void listar(List<Contribuicao> contribuicoes) {
        if (contribuicoes.isEmpty()) {
            System.out.println("Nenhuma contribuição cadastrada.");
        } else {
            System.out.println("Contribuições disponíveis:");
            for (Contribuicao c : contribuicoes) {
                System.out.println(c);
            }
        }
    }



}
