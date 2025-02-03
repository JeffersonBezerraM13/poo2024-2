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
        return this.nome;
    }

    public Integer getCodigo() {
        return this.codigo;
    }

    public List<Horario> getHorarios() {
        return this.horarios;
    }

    public int getMatriculaProf() {
        return this.matriculaProf;
    }
    @Override
    public String toString(){
        StringBuilder horariosToString = new StringBuilder();
        for(Horario h: this.horarios){
            horariosToString.append("\n").append(h.toString());
        }
        return  ("Disciplina de nome: "+this.nome+" código "+this.codigo+ "\nHorários: "+horariosToString);
    }
}
