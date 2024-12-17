package br.ufpb.dcx.jefferson.amigo.secreto;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SistemaAmigo {
    private List<Mensagem> mensagens;
    private List<Amigo> amigos;

    public SistemaAmigo(){
        this.mensagens = new ArrayList<>();
        this.amigos = new ArrayList<>();
    }

    public void cadastraAmigo(String nomeAmigo, String emailAmigo)
            throws AmigoJaExisteException{
        Amigo amigo = new Amigo (nomeAmigo,emailAmigo);
        for (Amigo a: this.amigos){
            if(a.equals(amigo)){
                throw new AmigoJaExisteException();
            }
        }
        this.amigos.add(amigo);
    }
    public Amigo pesquisaAmigo(String emailAmigo) throws AmigoInexistenteException{
        for(Amigo a :this.amigos){
            if(a.getEmail().equalsIgnoreCase(emailAmigo)){
                return a;
            }
        }
        throw new AmigoInexistenteException();
    }
    public void enviarMensagemParaTodos(String texto, String emailRemetente, boolean ehAnonima){
        Mensagem mensagemTodos = new MensagemParaTodos(texto,emailRemetente,ehAnonima);
        this.mensagens.add(mensagemTodos);
    }
    public void enviarMensagemParaAlguem(String texto, String emailRemetente, String emailDestinatario, boolean ehAnonima){
        Mensagem mensagemAlguem = new MensagemParaAlguem(texto,emailRemetente,emailDestinatario,ehAnonima);
        this.mensagens.add(mensagemAlguem);
    }
    public List<Mensagem> pesquisaMensagensAnonimas(){
        List<Mensagem> mensagensAnonimas = new ArrayList<>();
        for(Mensagem m: this.mensagens){
            if(m.ehAnonima()){
                mensagensAnonimas.add(m);
            }
        }
        return mensagensAnonimas;
    }
    public List<Mensagem> pesquisaTodasAsMensagens(){
        return this.mensagens;
    }
    public List<Amigo> pesquisaTodosOsAmigos(){
        return this.amigos;
    }
    public void configuraAmigoSecretoDe(String emailDaPessoa, String emailAmigoSecreto)
            throws AmigoInexistenteException{
        boolean encontrou = false;
        for(Amigo a: this.amigos){
            if(a.getEmail().equalsIgnoreCase(emailDaPessoa)){
                a.setEmailAmigoSorteado(emailAmigoSecreto);
                encontrou = true;
            }
        }
        if(!encontrou){
            throw new AmigoInexistenteException();
        }
    }
    public String pesquisaAmigoSecretoDe(String emailDaPessoa)
            throws AmigoInexistenteException, AmigoNaoSorteadoException{
        for(Amigo a: this.amigos){
            if(a.getEmail().equalsIgnoreCase(emailDaPessoa)){
                if(a.getEmailAmigoSorteado() == null){
                    throw new AmigoNaoSorteadoException();
                } else {
                    return a.getEmailAmigoSorteado();
                }
            }
        }
        throw new AmigoInexistenteException();
    }

    //Não consegui fazer
    public void sortear(){
        List<Amigo> amigosNaoSorteados = this.amigos;
        for (Amigo a: this.amigos){
            Random random = new Random();
            int posicaoDaListaSorteada = random.nextInt(1,amigosNaoSorteados.size()); //Sorteio 1 a o tamanho do List<Amigo> amigosNaoSorteados
            if(a.getNome().equalsIgnoreCase(amigosNaoSorteados.get(posicaoDaListaSorteada).getNome())){ //Se eu tirar eu mesmo
               a.setEmailAmigoSorteado(amigosNaoSorteados.get(posicaoDaListaSorteada+1).getEmail());//Coloco o proximo do amigo aleatorio para ser meu amigo secreto
                amigosNaoSorteados.remove(posicaoDaListaSorteada+1);
            } else { //Se eu tirar outra pessoa
                a.setEmailAmigoSorteado(amigosNaoSorteados.get(posicaoDaListaSorteada).getEmail()); //Defino esse email sorteado como email go amigo secreto do amigo "a" do for each
                amigosNaoSorteados.remove(amigosNaoSorteados.get(posicaoDaListaSorteada)); //e removo o email sorteado da lista de emails sorteados
            }
        }
    }
}
