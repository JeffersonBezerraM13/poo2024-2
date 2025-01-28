package br.ufpb.dcx.postoDeSaude;

import java.text.CollationElementIterator;
import java.util.*;

public class SistemaGerenciadorAtendimentosPostoRioTinto implements
        SistemaGerenciadorDeAtendimentos {


    private Map<String, Medico> medicos;
    private Map<String, AtendimentoMedico> atendimentos;

    public SistemaGerenciadorAtendimentosPostoRioTinto() {
        this.medicos = new HashMap<>();
        this.atendimentos = new HashMap<>();
    }


    @Override
    public void cadastrarMedico(String crmMedico, String nomeMedico)
            throws MedicoJaCadastradoException {
        if (this.medicos.containsKey(crmMedico)) { //verifica se a chave do medico já foi cadastrado, no caso o crm.
            throw new MedicoJaCadastradoException(
                    "Já existe médico com o CRM " + crmMedico);
        } else {
            this.medicos.put(crmMedico, new Medico(crmMedico, nomeMedico)); //put de map = add de list
        }

    }

    @Override
    public int contaAtendimentosDeMedicoNoMes(String crmMedico, int mes, int ano) {
        return 0;
    }

    @Override
    public void cadastrarAtendimento(String codigoFicha, CategoriaAtendimento categoria, String cpfPaciente, String crmMedico, Data diaAtendimento) throws MedicoNaoCadastradoException, AtendimentoJaCadastradoException {

    }

    @Override
    public AtendimentoMedico pesquisaAtendimento(String codigoFicha)
            throws AtendimentoNaoCadastradoException {
        if(this.atendimentos.containsKey(codigoFicha)){
            return this.atendimentos.get(codigoFicha);
        } else {
            throw new AtendimentoNaoCadastradoException("Não existe atendimento para a ficha "+codigoFicha);
        }
    }

    @Override
    public Collection<AtendimentoMedico> pesquisaAtendimentosDoDia(Data diaAtendimento) {
        Collection<AtendimentoMedico> atendimentosDia = new LinkedList<>();
        for(AtendimentoMedico at: this.atendimentos.values()){
            if(at.getDiaAtendimento().equals(diaAtendimento)){
                atendimentosDia.add(at);
            }
        }
        return atendimentosDia;
    }

    @Override
    public int contaAtendimentosDaCategoria(CategoriaAtendimento categoria) {
        int quantAtendimentosDaCategoria = 0;
        for (AtendimentoMedico at: this.atendimentos.values()){
            if(at.getCategoria() == categoria)
                quantAtendimentosDaCategoria++;
        }
        return quantAtendimentosDaCategoria;
    }
}

