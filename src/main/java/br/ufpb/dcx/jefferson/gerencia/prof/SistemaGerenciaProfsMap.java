package br.ufpb.dcx.jefferson.gerencia.prof;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SistemaGerenciaProfsMap implements SistemaGerenciaProfs {
    private Map<Integer, Professor> professores;
    private Map<Integer, Disciplina> disciplinas;

    public SistemaGerenciaProfsMap(){
        this.professores = new HashMap<>();
        this.disciplinas = new HashMap<>();
    }

    @Override
    public List<Horario> consultaHorariosDeAulaDoProfessor(int matriculaProf) throws ProfessorInexistenteException {
        if(this.professores.containsKey(matriculaProf)){
            return this.disciplinas.get(matriculaProf).getHorarios();
        } else {
            throw new ProfessorInexistenteException("Não há professor cadastrado a matrícula "+matriculaProf);
        }
    }

    @Override
    public List<String> consultaNomesDisciplinasDoProfessor(int matriculaProf) throws ProfessorInexistenteException{
        List<String> disciplinasDoProf = new ArrayList<>();
        if(this.professores.containsKey(matriculaProf)){
            disciplinasDoProf.add(this.disciplinas.get(matriculaProf).getNome());
        } else {
            throw new ProfessorInexistenteException("Não há professor cadastrado com a matrícula "+matriculaProf);
        }
        return disciplinasDoProf;
    }

    @Override
    public void cadastraProfessor(int matriculaProf, String nome) throws ProfessorJaExisteException {
        if(!this.professores.containsKey(matriculaProf)){
            this.professores.put(matriculaProf, new Professor(nome, matriculaProf));
        } else {
            throw new ProfessorJaExisteException("Já há um professor cadastrado com a matrícula "+matriculaProf);
        }
    }

    @Override
    public void cadastraDisciplina(String nomeDisciplina, int codigoDisciplina, int matriculaProfessor, List<Horario> horarios)
            throws DisciplinaJaExisteException, ProfessorInexistenteException {
        if(this.professores.containsKey(matriculaProfessor)){
            if(!this.disciplinas.containsKey(codigoDisciplina)){
                this.disciplinas.put(codigoDisciplina, new Disciplina(nomeDisciplina,codigoDisciplina,horarios,matriculaProfessor));
            } else {
                throw new DisciplinaJaExisteException("A disciplina do código "+codigoDisciplina+" já está cadastrada");
            }
        } else {
            throw new ProfessorInexistenteException("Não há professor cadastrado com a matrícula "+matriculaProfessor);
        }

    }

    @Override //Não entendi pq o método retorna void na atividade
    public Disciplina pesquisaDisciplina(int codigoDisciplina) throws DisciplinaInexistenteException {
        if(this.disciplinas.containsKey(codigoDisciplina)){
            return this.disciplinas.get(codigoDisciplina);
        } else {
            throw new DisciplinaInexistenteException("Não há disciplina cadastrada com o código "+codigoDisciplina);
        }
    }

    @Override //Não entendi pq o método retorna void na atividade
    public Professor pesquisaProfessor(int matriculaProfessor) throws ProfessorInexistenteException {
        if(this.professores.containsKey(matriculaProfessor)){
            return this.professores.get(matriculaProfessor);
        } else {
            throw new ProfessorInexistenteException("Não há professor cadastrado com a matrícula "+matriculaProfessor);
        }

    }
}
