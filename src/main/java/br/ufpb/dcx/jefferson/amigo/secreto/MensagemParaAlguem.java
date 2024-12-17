package br.ufpb.dcx.jefferson.amigo.secreto;

public class MensagemParaAlguem extends Mensagem{
    private String emailDestinatario;

    public MensagemParaAlguem(
            String texto,
            String emailRemetente,
            String emailDestinatario,
            boolean anonimo){
        super(texto, emailRemetente, anonimo);
        this.emailDestinatario = emailDestinatario;
    }
    public String getEmailDestinatario(){
        return this.emailDestinatario;
    }
    public void setEmailDestinatario(String emailDestinatario){
        this.emailDestinatario = emailDestinatario;
    }
    @Override
    public String getTextoCompletoAExibir(){
        if(ehAnonima()){
            return ("Mensagem para "+this.emailDestinatario+". Texto: "+super.getTexto());
        } else {
            return ("Mensagem de: "+super.getEmailRemetente()+" para "+this.emailDestinatario+". Texto: "+super.getTexto());
        }
    }
}
