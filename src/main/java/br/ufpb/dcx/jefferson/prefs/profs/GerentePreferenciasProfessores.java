package br.ufpb.dcx.jefferson.prefs.profs;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public class GerentePreferenciasProfessores implements ProfessoresPrefs{
    private Map<String,DisciplinaInexistenteException> disciplinas;
    private Map<String,Professor> professores;
    private Map<String,Area> areas;
    private Map<Disciplina, RelatorioInteressePorProfessor> interessePorDisciplina;
    private Map<Professor,RelatorioInteressePorProfessor> interessePorProfessor;
    private Map<Area,RelatorioInteressePorArea> interessePorArea;

    public GerentePreferenciasProfessores(Map<String, DisciplinaInexistenteException> disciplinas,
                                          Map<String, Professor> professores,
                                          Map<String, Area> areas,
                                          Map<Disciplina, RelatorioInteressePorProfessor> interessePorDisciplina,
                                          Map<Professor, RelatorioInteressePorProfessor> interessePorProfessor,
                                          Map<Area, RelatorioInteressePorArea> interessePorArea) {
        this.disciplinas = disciplinas;
        this.professores = professores;
        this.areas = areas;
        this.interessePorDisciplina = interessePorDisciplina;
        this.interessePorProfessor = interessePorProfessor;
        this.interessePorArea = interessePorArea;
    }

    @Override
    public void cadastraDisciplina(String codDisciplina, String nomeDisciplina) throws DisciplinaJaExisteException {

    }

    @Override
    public void cadastraProfessor(String matriculaProf, String nomeProf) throws ProfessorJaExisteException {

    }

    @Override
    public void cadastraInteresseDeProfessorPorDisciplina(String matriculaProf, String codDisciplina, NivelInteresse nivel) throws ProfessorInexistenteException, DisciplinaInexistenteException {

    }

    @Override
    public void cadastraArea(String codArea, String nomeArea) throws AreaExistenteException {

    }

    @Override
    public void cadastraInteresseDeProfessorPorArea(String matriculaProf, String codArea) throws ProfessorInexistenteException, AreaInexistenteException {

    }

    @Override
    public Professor pesquisaProfessor(String matriculaProf) throws ProfessorInexistenteException {
        return null;
    }

    @Override
    public Disciplina pesquisaDisciplina(String codDisciplina) throws DisciplinaInexistenteException {
        return null;
    }

    @Override
    public Area pesquisaArea(String codArea) throws AreaInexistenteException {
        return null;
    }

    @Override
    public Collection<Professor> getProfessoresInteressadosPorArea(String codArea) {
        return List.of();
    }

    @Override
    public Collection<Professor> getProfessoresInteressadosPorDisciplina(String codDisciplina, NivelInteresse nivel) {
        return List.of();
    }

    @Override
    public NivelInteresse getNivelInteresseDeProfessorPorDisciplina(String matriculaProf, String codDisciplina) throws ProfessorInexistenteException, DisciplinaInexistenteException {
        return null;
    }
}
