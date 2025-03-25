package br.ufpb.dcx.jefferson.prova.uni2;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Collection;
import org.junit.jupiter.api.Test;


public class MeuSistemaGerenciaDeTempoTest {


    @Test
    public void testaCadastroEPesquisa() {
        MeuSistemaGerenciaDeTempo sistema = new MeuSistemaGerenciaDeTempo();
        try {
            sistema.cadastrarTarefa("T001", "Estudar LP", CategoriaTarefa.ESTUDO, 120);
            assertEquals(120,
                    sistema.calcularTempoTotalDeTarefasDaCategoria(CategoriaTarefa.ESTUDO));
            sistema.alterarTempoDeTarefa("T001", 20);
            assertEquals(20,
                    sistema.calcularTempoTotalDeTarefasDaCategoria(CategoriaTarefa.ESTUDO));
            sistema.cadastrarTarefa("T002","EstudarPOO", CategoriaTarefa.ESTUDO, 40);
            Collection<Tarefa> tarefasEstudo = sistema.pesquisarTarefasDaCategoria(CategoriaTarefa.ESTUDO);
            assertEquals(2, tarefasEstudo.size());


        } catch (TarefaJaExisteException | TarefaNaoExisteException e){
            fail("Não deveria lançar exceção aqui");
        }
    }
}
