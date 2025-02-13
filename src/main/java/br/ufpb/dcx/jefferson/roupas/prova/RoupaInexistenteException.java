package br.ufpb.dcx.jefferson.roupas.prova;

public class RoupaInexistenteException extends RuntimeException {
    public RoupaInexistenteException(String message) {
        super(message);
    }
    public RoupaInexistenteException(){super();}
}
