package com.bemtevi.app.model;

/**
 * Enumeração que representa os tipos de desastres possíveis no sistema.
 * 
 * O `TipoDesastre` enum define as categorias de desastres, como terremotos, tsunamis, furacões, entre outros. Cada tipo de desastre
 * tem uma descrição associada que é utilizada para identificar o tipo de desastre no sistema.
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
    TERREMOTO,
    TSUNAMI,
    FURACAO,
    INCENDIO_FLORESTAL,
    DESLIZAMENTO_TERRA,
    OUTRO;

    // Método que retorna a descrição do tipo de desastre
    public String getDescricao() {
        switch (this) {
            case TERREMOTO:
                return "Terremoto";
            case TSUNAMI:
                return "Tsunami";
            case FURACAO:
                return "Furacão";
            case INCENDIO_FLORESTAL:
                return "Incêndio Florestal";
            case DESLIZAMENTO_TERRA:
                return "Deslizamento de Terra";
            case OUTRO:
                return "Outro";
            default:
                return "Tipo de desastre não especificado.";
        }
    }

    // Método para verificar se o tipo de desastre existe a partir de uma string
    public static boolean existeTipoDesastre(String tipo) {
        for (TipoDesastre td : TipoDesastre.values()) {
            if (td.getDescricao().equalsIgnoreCase(tipo)) {
                return true;
            }
        }
        return false;
    }
}
