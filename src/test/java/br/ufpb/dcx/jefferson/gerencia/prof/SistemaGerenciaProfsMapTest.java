package br.ufpb.dcx.jefferson.gerencia.prof;

import org.junit.jupiter.api.BeforeEach;
import  org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.*;

public class SistemaGerenciaProfsMapTest {
    @Test
    public void Tests(){
        SistemaGerenciaProfsMap sistemaGerenciaProfs = new SistemaGerenciaProfsMap();
        try {
            sistemaGerenciaProfs.cadastraProfessor(111, "José");
            List<String> disciplinasDoProf = sistemaGerenciaProfs.consultaNomesDisciplinasDoProfessor(111);
            assertTrue(disciplinasDoProf.size()==0);

            List<Horario> horarios = new ArrayList<>();
            horarios.add(new Horario(10,12, DiaDaSemana.TERCA));
            horarios.add(new Horario(13,15, DiaDaSemana.TERCA));

            sistemaGerenciaProfs.cadastraDisciplina("POO",22, 111, horarios);
            assertTrue(sistemaGerenciaProfs.consultaNomesDisciplinasDoProfessor(111).size()==1);

            List<Horario> horariosTeste = sistemaGerenciaProfs.pesquisaDisciplina(22).getHorarios();
            assertTrue(horariosTeste.get(1).toString().equals("TERCA: 10 - 12"));
            //assertTrue(horariosTeste.get(2).toString().equals("TERCA: 13 - 15"));


        } catch (Exception e){
            e.printStackTrace();
            fail();
        }
    }
}
