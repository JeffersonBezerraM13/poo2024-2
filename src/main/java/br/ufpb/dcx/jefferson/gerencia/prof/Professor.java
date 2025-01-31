package br.ufpb.dcx.jefferson.gerencia.prof;

public class Professor {
    private String nome;
    private Integer matricula;

    public Professor(String nome, Integer matricula) {
        this.nome = nome;
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public Integer getMatricula() {
        return matricula;
    }
}
