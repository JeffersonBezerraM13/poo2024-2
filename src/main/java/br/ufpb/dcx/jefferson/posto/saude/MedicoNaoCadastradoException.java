package br.ufpb.dcx.jefferson.posto.saude;

public class MedicoNaoCadastradoException extends Exception {

    public MedicoNaoCadastradoException(String msg){
        super(msg);
    }
    public MedicoNaoCadastradoException(){
        super();
    }
}
