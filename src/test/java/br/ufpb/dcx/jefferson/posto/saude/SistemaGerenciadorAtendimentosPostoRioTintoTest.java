package br.ufpb.dcx.jefferson.posto.saude;

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
            assertTrue(atendimentoData.size() == 1);
            sistema.cadastrarMedico("22222", "Jefferson Bezerro");
            sistema.cadastrarAtendimento("456", CategoriaAtendimento.ORTOPEDICO, "333.333.333-33","22222", new Data (8,8,2024));
            assertTrue(sistema.contaAtendimentosDaCategoria(CategoriaAtendimento.ORTOPEDICO) == 1);
            assertTrue(sistema.pesquisaAtendimentosDoDia(new Data(8,8,2024)).size() == 2);
        } catch (Exception e){
            fail("Não deveria lançar a exceção");
        }
    }
}
