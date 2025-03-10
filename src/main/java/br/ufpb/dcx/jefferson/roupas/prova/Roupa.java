package br.ufpb.dcx.jefferson.roupas.prova;

import java.io.Serializable;

public class Roupa implements Serializable {
    private String codigo;
    private String descricao;
    private int quantidade;
    private Tamanho tamanho;

    public Roupa(String codigo, String descricao, int quantidade, Tamanho tamanho) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.tamanho = tamanho;
    }

    public String getCodigo() {
        return codigo;
    } @SuppressWarnings("CALADO")

    public String getDescricao() {
        return descricao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public Tamanho getTamanho() {
        return tamanho;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    @Override
    public String toString(){
        return codigo+descricao+quantidade+tamanho;
    }
}
