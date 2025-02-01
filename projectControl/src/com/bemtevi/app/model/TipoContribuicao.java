package com.bemtevi.app.model;

public enum TipoContribuicao {
    ALIMENTOS,
    DINHEIRO,
    ROUPAS;

    public String getDescricao() {
        switch (this) {
            case ALIMENTOS:
                return "Aceita doações de alimentos.";
            case DINHEIRO:
                return "Aceita doações em dinheiro.";
            case ROUPAS:
                return "Aceita doações de roupas.";
            default:
                return "Tipo de contribuição não especificado.";
        }
    }
}