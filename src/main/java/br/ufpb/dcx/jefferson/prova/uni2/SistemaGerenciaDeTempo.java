package br.ufpb.dcx.jefferson.prova.uni2;

import java.util.Collection;
public interface SistemaGerenciaDeTempo {
    void cadastrarTarefa(String codigo, String descricao, CategoriaTarefa categoria,
                                int tempoEmMinutos) throws TarefaJaExisteException;
    Collection<Tarefa> pesquisarTarefasDaCategoria(CategoriaTarefa categoria);
    Collection<Tarefa> pesquisarTarefasQueDuraramMaisDe(int tempoEmMinutos);
    int calcularTempoTotalDeTarefasDaCategoria(CategoriaTarefa categoriaTarefa);
    int calcularTempoTotalDeTarefasComDescricao(String descricaoTarefa);
    Collection<Tarefa> pesquisarTarefasPorDescricao(String descricao);
    void alterarTempoDeTarefa(String codigoTarefa, int novoTempo)
            throws TarefaNaoExisteException;
}

