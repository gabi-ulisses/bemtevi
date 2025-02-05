package com.bemtevi.app.model;

/**
 * Classe responsável por representar uma contribuição para uma campanha,
 * contendo informações sobre o tipo de contribuição, o usuário que contribui,
 * a campanha à qual a contribuição é direcionada e o valor da contribuição.
 * 
 * A classe permite manipular as informações de contribuições, incluindo o tipo de
 * contribuição (definido por um enum `TipoContribuicao`), o usuário que fez a contribuição,
 * a campanha relacionada e o valor associado, caso exista.
 * 
 * Métodos principais:
 * - **getTipoContribuicao**: Retorna o tipo de contribuição (ex: dinheiro, doação de bens).
 * - **getUsuario**: Retorna o usuário que fez a contribuição.
 * - **getCampanha**: Retorna a campanha para a qual a contribuição foi feita.
 * - **getValor**: Retorna o valor monetário da contribuição, se houver.
 * - **toString**: Retorna uma representação textual da contribuição, incluindo
 *   o tipo, o nome do usuário, a campanha e o valor.
 */
public class Contribuicao {
    private TipoContribuicao tipoContribuicao;  // Alterando para usar o enum
    private Usuario usuario;                    // Pessoa que está contribuindo
    private Campanha campanha;                  // Campanha à qual está sendo feita a contribuição
    private double valor;                        // O valor da contribuição (opcional, caso queira adicionar)

    // Construtor
    public Contribuicao(TipoContribuicao tipoContribuicao, Usuario usuario, Campanha campanha) {
        this.tipoContribuicao = tipoContribuicao;
        this.usuario = usuario;
        this.campanha = campanha;
        this.valor = 0; // Caso não queira lidar com valor agora
    }

    public Contribuicao(TipoContribuicao tipoContribuicao, Usuario usuario, Campanha campanha, double valor) {
        this.tipoContribuicao = tipoContribuicao;
        this.usuario = usuario;
        this.campanha = campanha;
        this.valor = valor;
    }

    // Getters e Setters
    public TipoContribuicao getTipoContribuicao() {
        return tipoContribuicao;
    }

    public void setTipoContribuicao(TipoContribuicao tipoContribuicao) {
        this.tipoContribuicao = tipoContribuicao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Campanha getCampanha() {
        return campanha;
    }

    public void setCampanha(Campanha campanha) {
        this.campanha = campanha;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Contribuição [Tipo: " + tipoContribuicao + ", Usuário: " + usuario.getNome() + 
               ", Campanha: " + campanha.getNome() + ", Valor: R$ " + valor + "]";
    }
}