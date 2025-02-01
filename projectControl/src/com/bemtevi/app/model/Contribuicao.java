package com.bemtevi.app.model;

public class Contribuicao {
    private TipoContribuicao tipoContribuicao;  // Alterando para usar o enum
    private Usuario usuario;                    // Pessoa que está contribuindo
    private Campanha campanha;                  // Campanha à qual está sendo feita a contribuição

    // Construtor
    public Contribuicao(TipoContribuicao tipoContribuicao, Usuario usuario, Campanha campanha) {
        this.tipoContribuicao = tipoContribuicao;
        this.usuario = usuario;
        this.campanha = campanha;
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
}
