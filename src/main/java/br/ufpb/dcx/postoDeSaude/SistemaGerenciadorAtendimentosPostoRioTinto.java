package br.ufpb.dcx.postoDeSaude;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
    public AtendimentoMedico pesquisaAtendimento(String codigoFicha) throws AtendimentoNaoCadastradoException {
        return null;
    }

    @Override
    public Collection<AtendimentoMedico> pesquisaAtendimentosDoDia(Data diaAtendimento) {
        return List.of();
    }

    @Override
    public int contaAtendimentosDaCategoria(CategoriaAtendimento categoria) {
        return 0;
    }
}
//Demais métodos da classe considerando que implementa a interface
// e que lança em seus métodos mesmas exceções dos métodos da interface.

