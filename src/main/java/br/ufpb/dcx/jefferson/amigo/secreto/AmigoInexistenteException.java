package br.ufpb.dcx.jefferson.amigo.secreto;

public class AmigoInexistenteException extends RuntimeException {
    public AmigoInexistenteException(String message) {
        super(message);
    }
    public AmigoInexistenteException(){
        super();
    }
}
