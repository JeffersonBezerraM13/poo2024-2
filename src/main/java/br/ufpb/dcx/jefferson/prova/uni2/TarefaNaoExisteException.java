package br.ufpb.dcx.jefferson.prova.uni2;

public class TarefaNaoExisteException extends RuntimeException {
    public TarefaNaoExisteException(String message) {
        super(message);
    }
}
