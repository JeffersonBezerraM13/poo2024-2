package br.ufpb.dcx.jefferson.gerencia.prof;

import java.util.List;

public interface SistemaGerenciaProfs {
    public List <Horario> consultaHorariosDeAulaDoProfessor(int matriculaProf) throws ProfessorInexistenteException;
    public List <String> consultaNomesDisciplinasDoProfessor(int matriculaProf) throws ProfessorInexistenteException;
    public void cadastraProfessor(int matriculaProf, String nome)
            throws ProfessorJaExisteException;
    public void cadastraDisciplina(String nomeDisciplina, int codigoDisciplina,
                                   int matriculaProfessor, List<Horario> horarios) throws
            DisciplinaJaExisteException, ProfessorInexistenteException;
    public Disciplina pesquisaDisciplina(int codigoDisciplina) throws
            DisciplinaInexistenteException;
    public Professor pesquisaProfessor(int matriculaProfessor) throws
            ProfessorInexistenteException;

}
