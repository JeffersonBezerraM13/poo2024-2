package br.ufpb.dcx.jefferson.prefs.profs;

import java.util.Collection;

public interface ProfessoresPrefs {

    public void cadastraDisciplina(String codDisciplina, String nomeDisciplina)
            throws DisciplinaJaExisteException;
    public void cadastraProfessor(String matriculaProf, String nomeProf)
            throws ProfessorJaExisteException;
    public void cadastraInteresseDeProfessorPorDisciplina(String matriculaProf,
                                                          String codDisciplina, NivelInteresse nivel)
            throws ProfessorInexistenteException, DisciplinaInexistenteException;
    public void cadastraArea(String codArea, String nomeArea)
            throws AreaExistenteException;
    public void cadastraInteresseDeProfessorPorArea(String matriculaProf, String codArea)
            throws ProfessorInexistenteException, AreaInexistenteException;
    public Professor pesquisaProfessor(String matriculaProf)
            throws ProfessorInexistenteException;
    public Disciplina pesquisaDisciplina(String codDisciplina)
            throws DisciplinaInexistenteException;
    public Area pesquisaArea(String codArea)  throws AreaInexistenteException;
    public Collection <Professor> getProfessoresInteressadosPorArea(String codArea);
    public Collection<Professor> getProfessoresInteressadosPorDisciplina(
            String codDisciplina, NivelInteresse nivel);
    public NivelInteresse getNivelInteresseDeProfessorPorDisciplina(
            String matriculaProf, String codDisciplina)
            throws ProfessorInexistenteException, DisciplinaInexistenteException;
}

