package com.bemtevi.app.model;

/**
 * Classe responsável por representar um incidente e suas informações.
 * 
 * A classe contém atributos como tipo de desastre, local e uma descrição customizada,
 * no caso do tipo de desastre ser "OUTRO". Ela permite manipular e acessar as informações
 * relacionadas a um incidente, como o tipo de desastre ocorrido, o local do incidente e
 * qualquer descrição adicional fornecida para incidentes classificados como "OUTRO".
 * 
 * Métodos principais:
 * - **getTipoDesastre**: Retorna o tipo de desastre do incidente.
 * - **getLocal**: Retorna o local onde o incidente ocorreu.
 * - **getDescricao**: Retorna a descrição customizada do incidente, se houver.
 * - **listarDesastres**: Método estático que lista todos os tipos de desastres disponíveis.
 * - **toString**: Método que retorna uma representação textual do incidente, incluindo
 *   a descrição customizada se for um incidente do tipo "OUTRO".
 */
public class Incidente {
    private String local;
    private TipoDesastre tipoDesastre;
    private String descricao;  // Para armazenar a descrição customizada se for "OUTRO"

    // Construtor normal
    public Incidente(TipoDesastre tipoDesastre, String local) {
        this.tipoDesastre = tipoDesastre;
        this.local = local;
        this.descricao = null;  // Nenhuma descrição extra
    }

    // Construtor para o caso "OUTRO"
    public Incidente(TipoDesastre tipoDesastre, String local, String descricao) {
        this.tipoDesastre = tipoDesastre;
        this.local = local;
        this.descricao = descricao;  // A descrição será salva se for "OUTRO"
    }

    // Métodos de acesso
    public TipoDesastre getTipoDesastre() {
        return tipoDesastre;
    }

    public String getLocal() {
        return local;
    }

    public String getDescricao() {
        return descricao;
    }

    /**
     * Método responsável por listar todos os desastres disponíveis no sistema.
     * Exibe a descrição de cada tipo de desastre.
     */
    public static void listarDesastres() {
        for (TipoDesastre desastre : TipoDesastre.values()) {
            System.out.println(" •  " + desastre.getDescricao());
        }
    }

    @Override
    public String toString() {
        // Mostra a descrição personalizada se for "OUTRO"
        return "\nIncidente{" +
                "   Classificação='" + tipoDesastre.getDescricao() + '\'' +
                ", Local='" + local + '\'' +
                (descricao != null ? ", Descrição='" + descricao + '\'' : "") +
                '}';
    }
}