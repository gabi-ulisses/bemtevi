package com.bemtevi.app.model;

/**
 * Enumeração que representa os tipos de desastres possíveis no sistema.
 * 
 * O `TipoDesastre` enum define as categorias de desastres, como terremotos, tsunamis, furacões, entre outros. Cada tipo de desastre
 * tem uma descrição associada que é utilizada para identificar o tipo de desastre no sistema. O enum também inclui um método
 * estático `existeTipoDesastre`, que verifica se um determinado tipo de desastre (em formato de string) é válido, ou seja, se 
 * corresponde a algum dos tipos definidos.
 * 
 * Os tipos de desastre incluem:
 * - TERREMOTO
 * - TSUNAMI
 * - FURACAO
 * - INCENDIO_FLORESTAL
 * - DESLIZAMENTO_TERRA
 * - OUTRO
 */
public enum TipoDesastre {
    TERREMOTO("Terremoto"),
    TSUNAMI("Tsunami"),
    FURACAO("Furacão"),
    INCENDIO_FLORESTAL("Incêndio Florestal"),
    DESLIZAMENTO_TERRA("Deslizamento de Terra"),
    OUTRO("Outro");

    private final String descricao;

    // Construtor para associar a descrição ao tipo de desastre
    TipoDesastre(String descricao) {
        this.descricao = descricao;
    }

    // Método para retornar a descrição do tipo de desastre
    public String getDescricao() {
        return descricao;
    }

    // Sobrescrita do método toString para retornar a descrição diretamente
    @Override
    public String toString() {
        return descricao;
    }

    // Método para verificar se o tipo de desastre existe a partir de uma string
    public static boolean existeTipoDesastre(String tipo) {
        for (TipoDesastre td : TipoDesastre.values()) {
            if (td.descricao.equalsIgnoreCase(tipo)) {
                return true;
            }
        }
        return false;
    }
}
