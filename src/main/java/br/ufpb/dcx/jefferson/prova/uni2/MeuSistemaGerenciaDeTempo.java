package br.ufpb.dcx.jefferson.prova.uni2;

import javax.lang.model.type.ArrayType;
import java.util.*;

public class MeuSistemaGerenciaDeTempo implements SistemaGerenciaDeTempo {
    private Map<String, Tarefa> tarefas;

    public MeuSistemaGerenciaDeTempo() {
        this.tarefas = new HashMap<>();
    }


    @Override
    public void cadastrarTarefa(String codigo, String descricao, CategoriaTarefa categoria, int tempoEmMinutos) throws TarefaJaExisteException {
        if(!this.tarefas.containsKey(codigo)){
            this.tarefas.put(codigo, new Tarefa(codigo,descricao,categoria,tempoEmMinutos));
        } else {
            throw new TarefaJaExisteException("A tarefa com o código "+codigo+" já está cadastrada");
        }
    }

    @Override
    public Collection<Tarefa> pesquisarTarefasDaCategoria(CategoriaTarefa categoria) {
        Collection<Tarefa> tarefasPesq = new LinkedList<>();
        for (Tarefa tarefa : this.tarefas.values()) {
            if (tarefa.getCategoria() == (categoria)) {
                tarefasPesq.add(tarefa);
            }
        }
        return tarefasPesq;
    }

    @Override
    public Collection<Tarefa> pesquisarTarefasQueDuraramMaisDe(int tempoEmMinutos) {
        Collection<Tarefa> tarefasQueDuramMais = new ArrayList<>();
        for(Tarefa t: this.tarefas.values()){
            if(t.getTempoTarefaEmMinutos() > tempoEmMinutos){
                tarefasQueDuramMais.add(t);
            }
        }
        return tarefasQueDuramMais;
    }

    @Override
    public int calcularTempoTotalDeTarefasDaCategoria(CategoriaTarefa categoriaTarefa) {
        int cont = 0;
        for(Tarefa t: this.tarefas.values()){
            if(t.getCategoria() == categoriaTarefa){
                cont += t.getTempoTarefaEmMinutos();
            }
        }
        return cont;
    }

    @Override
    public int calcularTempoTotalDeTarefasComDescricao(String descricaoTarefa) {
        int cont = 0;
        for(Tarefa t: this.tarefas.values()){
            if(t.getDescricao().equalsIgnoreCase(descricaoTarefa)){
                cont += t.getTempoTarefaEmMinutos();
            }
        }
        return cont;
    }

    @Override
    public Collection<Tarefa> pesquisarTarefasPorDescricao(String descricao) {
        Collection<Tarefa> tarefasPorDescricao = new ArrayList<>();
        for(Tarefa t: this.tarefas.values()){
            if(t.getDescricao().equalsIgnoreCase(descricao)){
                tarefasPorDescricao.add(t);
            }
        }
        return tarefasPorDescricao;
    }

    @Override
    public void alterarTempoDeTarefa(String codigoTarefa, int novoTempo) throws TarefaNaoExisteException {
        if(this.tarefas.containsKey(codigoTarefa)){
            this.tarefas.get(codigoTarefa).setTempoTarefaEmMinutos(novoTempo);
        } else {
            throw new TarefaNaoExisteException("A tarefa com o código "+codigoTarefa+" não foi encontrada");
        }
    }
}