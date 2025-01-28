package br.ufpb.dcx.jefferson.posto.saude;

public class Medico {
    private String crmMedico;
    private String nomeMedico;

    public Medico(String crmMedico, String nomeMedico){
        this.crmMedico = crmMedico;
        this.nomeMedico = nomeMedico;
    }

    public String getCrmMedico() {
        return crmMedico;
    }

    public void setCrmMedico(String crmMedico) {
        this.crmMedico = crmMedico;
    }
    public String getNomeMedico(){
        return nomeMedico;
    }

    public void setNomeMedico(String nomeMedico) {
        this.nomeMedico = nomeMedico;
    }

    public String toString(){
        return "Medico de CRM: "+this.crmMedico+"\n e nome:"+this.nomeMedico;
    }
}
