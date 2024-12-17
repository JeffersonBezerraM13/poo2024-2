package br.ufpb.dcx.jefferson.amigo.secreto;

public class AmigoJaExisteException extends RuntimeException {
    public AmigoJaExisteException(String message) {
        super(message);
    }
    public AmigoJaExisteException(){
        super();
    }
}
