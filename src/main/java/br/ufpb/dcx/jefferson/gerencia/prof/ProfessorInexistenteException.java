package br.ufpb.dcx.jefferson.gerencia.prof;

public class ProfessorInexistenteException extends Exception {
    public ProfessorInexistenteException(String msg){
        super(msg);
    }
    public ProfessorInexistenteException(){
        super();
    }
}
