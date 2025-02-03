package br.ufpb.dcx.jefferson.gerencia.prof;

public class Horario {
    private int horaInicio;
    private int horaFim;
    private DiaDaSemana dia;

    public Horario(int horaInicio, int horaFim, DiaDaSemana dia) {
        this.horaInicio = horaInicio;
        this.horaFim = horaFim;
        this.dia = dia;
    }

    public int getHoraInicio() {
        return horaInicio;
    }

    public int getHoraFim() {
        return horaFim;
    }

    public DiaDaSemana getDia() {
        return dia;
    }
    @Override
    public String toString(){
        return (this.dia+": "+this.horaInicio+" - "+this.horaFim);
    }
}
