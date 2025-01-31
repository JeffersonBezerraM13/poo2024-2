package br.ufpb.dcx.jefferson.posto.saude;

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
    public void cadastrarAtendimento(String codigoFicha, CategoriaAtendimento categoria, String cpfPaciente, String crmMedico, Data diaAtendimento)
            throws MedicoNaoCadastradoException, AtendimentoJaCadastradoException {
        if(this.atendimentos.containsKey(codigoFicha)){
            throw new AtendimentoJaCadastradoException("Esse atendimento já está cadastrado");
        } else if (!this.medicos.containsKey(crmMedico)){
            throw new MedicoNaoCadastradoException();
        } else {
            AtendimentoMedico atm = new AtendimentoMedico(codigoFicha,categoria,cpfPaciente,crmMedico,diaAtendimento);
            this.atendimentos.put(codigoFicha, atm);
        }
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
        Collection<AtendimentoMedico> atendimentoMedicoCollection = new LinkedList<>();
        for (AtendimentoMedico at: this.atendimentos.values()){
            if(at.getDiaAtendimento().equals(diaAtendimento)){
                atendimentoMedicoCollection.add(at);
            }
        }
        return atendimentoMedicoCollection;
    }

    @Override
    public int contaAtendimentosDaCategoria(CategoriaAtendimento categoria) {
        int quantAtendimentoDaCategoria = 0;
        for (AtendimentoMedico at: this.atendimentos.values()){
            if(at.getCategoria().equals(categoria)){
                quantAtendimentoDaCategoria++;
            }
        }
        return quantAtendimentoDaCategoria;
    }
}

