package br.ufpb.dcx.jefferson.gerencia.prof;

import  org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*; //lembrar de importar essas coisinhas

public class SistemaGerenciaProfsMapTest {
    @Test
    public void Tests(){
        SistemaGerenciaProfsMap sistemaGerenciaProfs = new SistemaGerenciaProfsMap();
        try {
            //i)
            sistemaGerenciaProfs.cadastraProfessor(111, "José");
            List<String> disciplinasDoProf = sistemaGerenciaProfs.consultaNomesDisciplinasDoProfessor(111);
            //ii)
            assertEquals(0,disciplinasDoProf.size());
            //iii)
            List<Horario> horarios = new ArrayList<>();
            horarios.add(new Horario(10,12, DiaDaSemana.TERCA));
            horarios.add(new Horario(13,15, DiaDaSemana.TERCA));
            sistemaGerenciaProfs.cadastraDisciplina("POO",22, 111, horarios);
            //iv)
            assertTrue(sistemaGerenciaProfs.consultaNomesDisciplinasDoProfessor(111).get(0).equals("POO"));
            //v)
            List<Horario> horariosTeste = sistemaGerenciaProfs.pesquisaDisciplina(22).getHorarios();
            assertEquals("TERCA: 10 - 12", horariosTeste.get(0).toString());
            assertEquals("TERCA: 13 - 15",horariosTeste.get(1).toString());
        } catch (Exception e){
            e.printStackTrace();
            fail("Não era para falhar :( ~tô mal");
        }
    }
}
