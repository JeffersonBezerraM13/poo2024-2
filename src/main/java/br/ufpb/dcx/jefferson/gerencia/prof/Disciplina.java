package br.ufpb.dcx.jefferson.gerencia.prof;

import java.util.List;

public class Disciplina {
    private String nome;
    private Integer codigo;
    private List<Horario> horarios;
    private int matriculaProf;

    public Disciplina(String nome, Integer codigo, List<Horario> horarios, int matriculaProf) {
        this.nome = nome;
        this.codigo = codigo;
        this.horarios = horarios;
        this.matriculaProf = matriculaProf;
    }

    public String getNome() {
        return nome;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public List<Horario> getHorarios() {
        return horarios;
    }

    public int getMatriculaProf() {
        return matriculaProf;
    }
}
