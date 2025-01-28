package br.ufpb.dcx.jefferson.posto.saude;

public class AtendimentoNaoCadastradoException extends Exception {

    public AtendimentoNaoCadastradoException(String msg){
        super(msg);
    }
    public AtendimentoNaoCadastradoException(){
        super();
    }
}
