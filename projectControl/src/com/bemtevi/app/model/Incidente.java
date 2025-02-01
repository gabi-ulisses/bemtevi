/**
 * Classe responsável por representar um incidente e suas informações.
 * Inclui atributos como tipo de desastre, local e data/hora.
 * 
 * A classe permite formatar e manipular dados de um incidente.
 */
package com.bemtevi.app.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Incidente {
    private String local;
    private LocalDateTime dataHora;
    private TipoDesastre tipoDesastre;
    private String descricao;  // Para armazenar a descrição customizada se for "OUTRO"

    public static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    // Construtor normal
    public Incidente(TipoDesastre tipoDesastre, String local, LocalDateTime dataHora) {
        this.tipoDesastre = tipoDesastre;
        this.local = local;
        this.dataHora = dataHora;
        this.descricao = null;  // Nenhuma descrição extra
    }

    // Construtor para o caso "OUTRO"
    public Incidente(TipoDesastre tipoDesastre, String local, LocalDateTime dataHora, String descricao) {
        this.tipoDesastre = tipoDesastre;
        this.local = local;
        this.dataHora = dataHora;
        this.descricao = descricao;  // A descrição será salva se for "OUTRO"
    }

    // Métodos de acesso
    public TipoDesastre getTipoDesastre() {
        return tipoDesastre;
    }

    public String getLocal() {
        return local;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getDataHoraFormatada() {
        return this.dataHora.format(FORMATTER);
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
        return "Incidente{" +
                "   Classificação='" + tipoDesastre.getDescricao() + '\'' +
                ", Local='" + local + '\'' +
                ", Data e hora=" + getDataHoraFormatada() +
                (descricao != null ? ", Descrição='" + descricao + '\'' : "") +
                '}';
    }
}