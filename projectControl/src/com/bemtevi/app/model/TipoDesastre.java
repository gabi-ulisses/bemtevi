package com.bemtevi.app.model;

public enum TipoDesastre {
    TERREMOTO("Terremoto"),
    TSUNAMI("Tsunami"),
    FURACAO("Furacão"),
    INCENDIO_FLORESTAL("Incêndio Florestal"),
    DESLIZAMENTO_TERRA("Deslizamento de Terra"),
    OUTRO("Outro");

    private final String descricao;

    TipoDesastre(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public String toString() {
        return descricao;
    }

    // Método para verificar se o tipo de desastre existe
    public static boolean existeTipoDesastre(String tipo) {
        for (TipoDesastre td : TipoDesastre.values()) {
            if (td.descricao.equalsIgnoreCase(tipo)) {
                return true;
            }
        }
        return false;
    }
}
