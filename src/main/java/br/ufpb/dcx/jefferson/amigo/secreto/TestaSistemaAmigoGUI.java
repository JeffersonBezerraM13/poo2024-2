package br.ufpb.dcx.jefferson.amigo.secreto;

import java.util.Scanner;

public class TestaSistemaAmigoGUI {
    public static void main(String [] args){
        SistemaAmigo sistema = new SistemaAmigo();
        Scanner leitor = new Scanner(System.in);
        System.out.print("Quando amigos vão participar da brincadeira?");
        int quant = Integer.parseInt(leitor.nextLine());
        for (int x = 0; x<quant; x++){
            System.out.println("Insira os dados do "+x+"º participante");
            System.out.println("Insira o nome:");
            String nome = leitor.next();
            System.out.println("Email:");
            String email = leitor.next();
            try{
                sistema.cadastraAmigo(nome,email);
            } catch (AmigoJaExisteException e){
                System.out.println("Esse participante já está cadastrado");
            }
        }
        sistema.sortear();

        System.out.println("Se você quer enviar mensagem para todos\nInsira o seu os seguintes dados:\nEmail remetente:");
        String emailReme = leitor.nextLine();
        System.out.println("Insira a mensagem que deseja enviar");
        String msg = leitor.nextLine();
        boolean anonima = false;
        System.out.println("Deseja que a mensagem seja anonima?(S/N)");
        if(leitor.nextLine().equalsIgnoreCase("s")){
            anonima = true;
        }
        sistema.enviarMensagemParaTodos(msg,emailReme,anonima);

        System.out.println("Relatório de quem tirou quem");
        for(Amigo a: sistema.pesquisaTodosOsAmigos()){
            System.out.println(a.getEmail()+"tirou "+a.getEmailAmigoSorteado()+" como amigo secreto");
        }
        leitor.close();
    }
}
