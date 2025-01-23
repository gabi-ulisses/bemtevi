package com.bemtevi.app.model;

import com.bemtevi.app.service.Gerenciamento;

public class Campanha{
    //private Contribuicao contribuicao;
    private int codigo;
    private String nome;
    private String descricao;
    private boolean identificacaoFiscal;
    private double metaArrecadacao;
    private int duracao;
    private String localAtuacao;

    // Construtor
    public Campanha(Contribuicao contribuicao, int codigo, String nome, String descricao, 
                    boolean identificacaoFiscal, double metaArrecadacao, int duracao, String localAtuacao) {
        this.contribuicao = contribuicao;
        this.codigo = codigo;
        this.nome = nome;
        this.descricao = descricao;
        this.identificacaoFiscal = identificacaoFiscal;
        this.metaArrecadacao = metaArrecadacao;
        this.duracao = duracao;
        this.localAtuacao = localAtuacao;
    }

    // Getters e setters
    public Contribuicao getContribuicao() {
        return contribuicao;
    }

    public void setContribuicao(Contribuicao contribuicao) {
        this.contribuicao = contribuicao;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isIdentificacaoFiscal() {
        return identificacaoFiscal;
    }

    public void setIdentificacaoFiscal(boolean identificacaoFiscal) {
        this.identificacaoFiscal = identificacaoFiscal;
    }

    public double getMetaArrecadacao() {
        return metaArrecadacao;
    }

    public void setMetaArrecadacao(double metaArrecadacao) {
        this.metaArrecadacao = metaArrecadacao;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public String getLocalAtuacao() {
        return localAtuacao;
    }

    public void setLocalAtuacao(String localAtuacao) {
        this.localAtuacao = localAtuacao;
    }

    
}
