package br.ufpb.dcx.jefferson.amigo.secreto;


import java.util.*;

public class SistemaAmigoMap {

    private List<Mensagem> mensagens; //chave é o email
    private Map<String, Amigo> amigos; //chave é o email da pessoa

    public SistemaAmigoMap(){
        this.mensagens = new ArrayList<>();
        this.amigos = new HashMap<>();
    }

    public void cadastraAmigo(String nomeAmigo, String emailAmigo)
            throws AmigoJaExisteException{
        Amigo amigo = new Amigo (nomeAmigo,emailAmigo);
        if(this.amigos.containsKey(nomeAmigo)){
            throw new AmigoJaExisteException("Já existe um amigo cadastrado com esse email");
        }
        this.amigos.put(emailAmigo ,amigo);
    }
    public Amigo pesquisaAmigo(String emailAmigo) throws AmigoInexistenteException{
        if(this.amigos.containsKey(emailAmigo)){
            return this.amigos.get(emailAmigo);
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
        return (List<Amigo>) this.amigos;
    }
    public void configuraAmigoSecretoDe(String emailDaPessoa, String emailAmigoSecreto)
            throws AmigoInexistenteException{
        if(this.amigos.containsKey(emailDaPessoa)){
            this.amigos.get(emailDaPessoa).setEmailAmigoSorteado(emailAmigoSecreto);
        } else {

        }

        /** codigo da atividade antiga
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
         */
    }
    public String pesquisaAmigoSecretoDe(String emailDaPessoa)
            throws AmigoInexistenteException, AmigoNaoSorteadoException{
        if(this.amigos.containsKey(emailDaPessoa)){
            String nomeDoAmigo = this.amigos.get(emailDaPessoa).getEmailAmigoSorteado();
            if(nomeDoAmigo == null){
                throw new AmigoNaoSorteadoException();
            } else {
                return nomeDoAmigo;
            }
        } else {
            throw new AmigoInexistenteException();
        }


       /** codigo antigo
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
        */
    }

    //Não consegui fazer
    public void sortear(){
        List<Amigo> amigosNaoSorteados = (List<Amigo>) this.amigos;
        for (Amigo a: this.amigos.values()){
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
