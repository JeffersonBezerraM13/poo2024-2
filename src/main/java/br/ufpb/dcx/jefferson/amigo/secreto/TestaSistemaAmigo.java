package br.ufpb.dcx.jefferson.amigo.secreto;

import java.util.List;

public class TestaSistemaAmigo {
    public static void main(String [] args){
        SistemaAmigo sistema = new SistemaAmigo();
        sistema.cadastraAmigo("José", "jose.silva@gmail.com");
        sistema.cadastraAmigo("Maria", "maria.santos@gmail.com");
        try {
            sistema.configuraAmigoSecretoDe(
                    "jose.silva@gmail.com",
                    "maria.santos@gmail.com");
            sistema.configuraAmigoSecretoDe(
                    "maria.santos@gmail.com",
                    "jose.silva@gmail.com");
        } catch (AmigoInexistenteException e){
            System.out.println("Amigo não encontrado");
            e.printStackTrace();
        }
        sistema.enviarMensagemParaAlguem("Oi",
                "maria.santos@gmail.com",
                "jose.silva@gmail.com",
                true);
        sistema.enviarMensagemParaTodos("Oi pessoal",
                "maria.santos@gmail.com",
                true);
        List<Mensagem> msgAnonimas = sistema.pesquisaMensagensAnonimas();
        for(Mensagem m: msgAnonimas){
            System.out.println(m.getTextoCompletoAExibir());
        }
        if(sistema.pesquisaAmigoSecretoDe("jose.silva@gmail.com").equalsIgnoreCase("maria.santos@gmail.com")){
            System.out.println("Ok");
        } else {
            System.out.println("Não é");
        }

    }
}
