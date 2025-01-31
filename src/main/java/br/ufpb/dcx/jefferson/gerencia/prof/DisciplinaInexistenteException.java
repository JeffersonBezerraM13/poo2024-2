package br.ufpb.dcx.jefferson.gerencia.prof;

public class DisciplinaInexistenteException extends Exception {
    public DisciplinaInexistenteException(String msg){
        super(msg);
    }
    public DisciplinaInexistenteException(){
        super();
    }
}
