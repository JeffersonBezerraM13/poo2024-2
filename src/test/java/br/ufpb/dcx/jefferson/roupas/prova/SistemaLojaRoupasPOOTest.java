package br.ufpb.dcx.jefferson.roupas.prova;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SistemaLojaRoupasPOOTest {
    @Test
    public void TestaSistemaLojaRoupasPOOTest(){
        SistemaLojaRoupasPOO sistema = new SistemaLojaRoupasPOO();
        try {
            sistema.cadastraRoupa("001", "Camisa Polo Azul Mascuslina", Tamanho.M, 10);
            Roupa r = sistema.pesquisaRoupa("001");
            assertEquals(10, r.getQuantidade());
            sistema.cadastraRoupa("002", "Camisa Vermelha feminina", Tamanho.M, 2);
            List<Roupa> roupasList = sistema.pesquisaRoupasComDescricaoComecandoCom("Camisa");
            assertEquals(2,roupasList.size());
            sistema.alteraQuantidadeDeRoupaNoEstoque("001", 9);
            int quant = sistema.pesquisaQuantidadeDeRoupaNoEstoque("001");
            assertEquals(9, quant);
        } catch(Exception e){
            e.printStackTrace();
            fail("Não deveria falhar");
        }
    }
}
