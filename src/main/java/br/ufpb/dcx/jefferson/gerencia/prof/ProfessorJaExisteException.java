package br.ufpb.dcx.jefferson.gerencia.prof;

public class ProfessorJaExisteException extends Exception {
    public ProfessorJaExisteException(String msg){
        super(msg);
    }
    public ProfessorJaExisteException(){
        super();
    }
}
