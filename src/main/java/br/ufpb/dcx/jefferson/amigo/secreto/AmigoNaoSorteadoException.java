package br.ufpb.dcx.jefferson.amigo.secreto;

public class AmigoNaoSorteadoException extends RuntimeException {
    public AmigoNaoSorteadoException(String message) {
        super(message);
    }
    public AmigoNaoSorteadoException(){
      super();
    }
}
