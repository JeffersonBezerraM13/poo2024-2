package br.ufpb.dcx.jefferson.roupas.prova;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class GravadorDeRoupas {
    private String arquivoRoupas; //Poderia ser uma constante

    public GravadorDeRoupas(){
        this.arquivoRoupas = "roupas.dat"; //.dat indica que é um arquivo de dados
    }
    public Collection<Roupa> recuperaRoupas() throws IOException{
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(arquivoRoupas))) { //lendo o arquivo com o nome do atributo
            Collection<Roupa> roupasAchadas = (ArrayList<Roupa>) in.readObject();//pode acontecer a exception classnotfound ou classcastexception
            return roupasAchadas; //retornando o arrayList de roupas
        } catch (ClassNotFoundException | ClassCastException e){
            throw new IOException(e.getCause()); //mais detalhes sobre a exception ativado pelo classnotfound ou classcastexception mas lançado por IOException da assinatura do metodo
        }
    }

    public void gravaRoupas(Collection<Roupa> roupas) throws IOException {
        ArrayList<Roupa> roupasArrayList = new ArrayList<>(); //Usando ArrayList pois ele é serializable
        roupasArrayList.addAll(roupas); //adicionando todas a colletion no array list e novamente, usando array list pq ele é serializable já que o collection não é
        //é um outputstream pq o sistema vai mandar pra fora os arquivo serializado da minha roupa
        /** versão antiga
        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream((new FileOutputStream(arquivoRoupas)));  //o construtor desse objeto lançam exception (pois talves o arquivo não exista ou o hd esteja cheio)
            out.writeObject(roupasArrayList);
        } finally {
            if(out!=null){
                out.close();
            }
        }
         */

        //try with resources, pode ser que nas versões mais antigas ele não tenha essa opção
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(arquivoRoupas))){ //dentro do try ele vai da um "finally" para fechar automaticamente
            out.writeObject(roupasArrayList);
        }

    }
    public static void main (String [] args){
        Roupa r = new Roupa("111", "Camisa verdeeeee", 5, Tamanho.M);
        Roupa r2 = new Roupa("222", "Camisa amarela", 10, Tamanho.G);

        List<Roupa> roupa = new LinkedList<>(); //usando arraylist pq ele é serializavel e vai ter um cast para arrayList
        roupa.add(r);
        roupa.add(r2);

        GravadorDeRoupas gravadorDeRoupas = new GravadorDeRoupas();
        System.out.println("Recuperando roupas...");
        try {

            Collection<Roupa> roupasAchadas = gravadorDeRoupas.recuperaRoupas();
            System.out.println("Roupas achadas:");
            for(Roupa roupinha : roupasAchadas){
                System.out.println(roupinha.toString());
            }
            gravadorDeRoupas.gravaRoupas(roupa);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }


    }


}
