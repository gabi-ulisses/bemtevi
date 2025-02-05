package com.bemtevi.app.model;

/**
 * Enumeração que representa os tipos de contribuição possíveis no sistema.
 * 
 * O `TipoContribuicao` enum define as categorias de contribuições que podem ser feitas, como alimentos, dinheiro e roupas. Cada tipo
 * de contribuição possui uma descrição associada, fornecida pelo método `getDescricao()`. O método utiliza um `switch` para retornar
 * a descrição apropriada com base no tipo de contribuição selecionado.
 * 
 * Os tipos de contribuição incluem:
 * - ALIMENTOS: Aceita doações de alimentos.
 * - DINHEIRO: Aceita doações em dinheiro.
 * - ROUPAS: Aceita doações de roupas.
 */
public enum TipoContribuicao {
    ALIMENTOS,
    DINHEIRO,
    ROUPAS;

    // Método que retorna a descrição do tipo de contribuição
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
