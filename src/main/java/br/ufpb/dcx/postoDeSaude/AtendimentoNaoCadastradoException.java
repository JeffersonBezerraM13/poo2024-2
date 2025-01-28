package br.ufpb.dcx.postoDeSaude;

public class AtendimentoNaoCadastradoException extends Exception {

    public AtendimentoNaoCadastradoException(String msg){
        super(msg);
    }
    public AtendimentoNaoCadastradoException(){
        super();
    }
}
