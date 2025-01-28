package br.ufpb.dcx.postoDeSaude;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.Collection;

public class SistemaGerenciadorAtendimentosPostoRioTintoTest {

    @Test
    public void testaCadastroMedico(){
        SistemaGerenciadorAtendimentosPostoRioTinto sistema = new SistemaGerenciadorAtendimentosPostoRioTinto();
        try{
            sistema.cadastrarMedico("11111", "Ana Julia Lopes");
            sistema.cadastrarAtendimento("123", CategoriaAtendimento.CARDIOLOGICO, "222.222.222-22","11111" ,new Data(8,8,2024));
            Collection<AtendimentoMedico> atendimentoData = sistema.pesquisaAtendimentosDoDia(new Data(8,8,2024));
            assertTrue(atendimentoData.size() == 1); //terminar o metodo do atendimento
        } catch (Exception e){
            fail("Não deveria lançar a exceção");
        }
    }
}
