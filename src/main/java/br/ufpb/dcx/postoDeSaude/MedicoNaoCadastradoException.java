package br.ufpb.dcx.postoDeSaude;

public class MedicoNaoCadastradoException extends Exception {

    public MedicoNaoCadastradoException(String msg){
        super(msg);
    }
    public MedicoNaoCadastradoException(){
        super();
    }
}
