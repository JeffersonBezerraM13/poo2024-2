package br.ufpb.dcx.jefferson.amigo.secreto;

import javax.swing.*;
import java.util.List;

public class TestaSistemaAmigoGUI {
    public static void main(String [] args){
        //a) Inicialize a variável do tipo SistemaAmigo.
        SistemaAmigo sistema = new SistemaAmigo();
        //b) Leia a quantidade total de amigos a participar da brincadeira
        int quant = Integer.parseInt(JOptionPane.showInputDialog(null,"Quantos amigos vão participar da brincadeira?"));
        //c) Leia os dados (nome e e-mail) de cada um dos amigos e os cadastre.
        for (int x = 0; x<quant; x++){
            String nome = JOptionPane.showInputDialog(null,"Insira o nome:","Insira os dados do "+(x+1)+"º participante", JOptionPane.QUESTION_MESSAGE);
            String email = JOptionPane.showInputDialog(null,"Email:","Insira os dados do "+(x+1)+"º participante",JOptionPane.QUESTION_MESSAGE);
            try{
                sistema.cadastraAmigo(nome,email);
                JOptionPane.showMessageDialog(null,"Cadastro do participante "+(x+1)+" realizado com sucesso!","Mensagem do sistema", JOptionPane.INFORMATION_MESSAGE);
            } catch (AmigoJaExisteException e){
                JOptionPane.showMessageDialog(null,"Esse participante já está cadastrado","Mesangem do sistema",JOptionPane.INFORMATION_MESSAGE);
            }
        }
        //d) Cadastre os resultados do sorteio dos amigos secretos (diga quem pegou quem).
        //Obs.: Eu criei esse método "pesquisaTodosOsAmigos()"
        List<Amigo> todosOsAmigos = sistema.pesquisaTodosOsAmigos();
        for (Amigo amigoDaVez : todosOsAmigos) {
            String emailAmigo = JOptionPane.showInputDialog(null, "Insira o email do amigo sorteado de " + amigoDaVez.getNome(), "Selecionando os sorteados", JOptionPane.QUESTION_MESSAGE);
            amigoDaVez.setEmailAmigoSorteado(emailAmigo);
            System.out.println(amigoDaVez.getNome() + " tirou " + amigoDaVez.getEmailAmigoSorteado());
        }
        //e) Envie uma mensagem de algum dos amigos para todos, coletando para isso os dados necessários (ex: remetente,  texto, se a mensagem é anônima ou não).
        String emailReme = JOptionPane.showInputDialog(null, "Insira o seu os seguintes dados\n\nEmail do remetente:", "Enviar mensagem para todos",JOptionPane.QUESTION_MESSAGE);
        String msg = JOptionPane.showInputDialog(null, "Insira a mensagem que deseja enviar:","Enviar mensagem para todos",JOptionPane.QUESTION_MESSAGE);
        boolean anonima = false;
        String anonimaStr = JOptionPane.showInputDialog(null,"Deseja que seja anonima?(S/N)","Enviar mensagem para todos",JOptionPane.QUESTION_MESSAGE);
        if(anonimaStr.equalsIgnoreCase("s")){
            anonima = true;
        }
        sistema.enviarMensagemParaTodos(msg,emailReme,anonima);
        //Questão 5
        //Não consegui fazer, ta dando erro
        sistema.sortear();
        String amigosStr = "";
        for(Amigo a: sistema.pesquisaTodosOsAmigos()){
            amigosStr += a.toString();
        }
        JOptionPane.showMessageDialog(null,amigosStr,"Relatório dos amigos sorteados", JOptionPane.INFORMATION_MESSAGE);
    }
}
