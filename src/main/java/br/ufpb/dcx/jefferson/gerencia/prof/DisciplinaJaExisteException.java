package br.ufpb.dcx.jefferson.gerencia.prof;

public class DisciplinaJaExisteException extends Exception {
    public DisciplinaJaExisteException(String msg){
        super(msg);
    }
    public DisciplinaJaExisteException(){
        super();
    }
}
