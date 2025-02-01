package com.bemtevi.app.model;

public class Campanha {
    private String codigo;
    private String nome;
    private String descricao;
    private boolean identificacaoFiscal;
    private double metaArrecadacao;
    private int duracao;
    private String localAtuacao;
    private Ong organizacao;
    private String causa;
    private TipoContribuicao tipoContribuicao;  // Tipo de contribuição usando o enum

    public Campanha(String codigo) {
        this.codigo = codigo;
    }

    public Campanha(Ong organizacao, TipoContribuicao tipoContribuicao,  String causa, String codigo, String nome, String descricao, boolean identificacaoFiscal, double metaArrecadacao, int duracao, String localAtuacao) {
        this.organizacao = organizacao;
        this.causa = causa;
        this.tipoContribuicao = tipoContribuicao;
        this.codigo = codigo;
        this.nome = nome;
        this.descricao = descricao;
        this.identificacaoFiscal = identificacaoFiscal;
        this.metaArrecadacao = metaArrecadacao;
        this.duracao = duracao;
        this.localAtuacao = localAtuacao;
    }

    // Getters e Setters
    public TipoContribuicao getTipoContribuicao() {
        return tipoContribuicao;
    }

    public void setTipoContribuicao(TipoContribuicao tipoContribuicao) {
        this.tipoContribuicao = tipoContribuicao;
    }

    
    public String getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public Ong getOrganizacao() {
        return organizacao;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public String toString() {
        return "Campanha{" +
                "codigo='" + codigo + '\'' +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", identificacaoFiscal=" + identificacaoFiscal +
                ", metaArrecadacao=" + metaArrecadacao +
                ", duracao=" + duracao +
                ", localAtuacao='" + localAtuacao + '\'' +
                ", organizacao=" + organizacao.getNome() +
                ", causa='" + causa + '\'' +
                ", tipoContribuicao=" + tipoContribuicao.getDescricao() +  // Exibindo descrição do tipo de contribuição
                '}';
    }
}