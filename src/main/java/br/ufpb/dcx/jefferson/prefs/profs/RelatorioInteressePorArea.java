package br.ufpb.dcx.jefferson.prefs.profs;

import java.util.Collection;

public class RelatorioInteressePorArea {
    private Disciplina disciplina;
    private NivelInteresse nivelInteresse;
    private Professor professor;
    private Area area;

    public RelatorioInteressePorArea(Area area){
        this.area = area;
    }
    public void adicionaProfessor(Professor prof){
        this.professor = prof;
    }
    public Collection<Professor> getInteressadors(){
}
