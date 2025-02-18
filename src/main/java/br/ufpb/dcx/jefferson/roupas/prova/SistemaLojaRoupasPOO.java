package br.ufpb.dcx.jefferson.roupas.prova;

import java.io.IOException;
import java.util.*;

public class SistemaLojaRoupasPOO implements SistemaLojaRoupas{
    private Map<String, Roupa> roupasMap;
    private GravadorDeRoupas gravador;

    public SistemaLojaRoupasPOO() {
        this.roupasMap = new HashMap<>();
        this.gravador = new GravadorDeRoupas();
    }

    public void recuperaRoupas() throws IOException, RoupaJaExisteException {
        Collection<Roupa> roupasAchadas = this.gravador.recuperaRoupas();
        for(Roupa r: roupasAchadas){
            this.cadastraRoupa(r.getCodigo(),r.getDescricao(),r.getTamanho(),r.getQuantidade());
        }
    }

    public void salvarRoupas() throws IOException{
        this.gravador.gravaRoupas(this.roupasMap.values());
    }

    @Override
    public List<Roupa> pesquisaRoupasPorTamanho(Tamanho tamanhoRoupa) {
        List<Roupa> roupasTamanho =  new ArrayList<>();
        for(Roupa r: this.roupasMap.values()){
            if(r.getTamanho() == tamanhoRoupa){
                roupasTamanho.add(r);
            }
        }
        return roupasTamanho;
    }

    @Override
    public List<Roupa> pesquisaRoupasComDescricaoComecandoCom(String prefixoDescricao) {
        List<Roupa> roupasDescricao = new ArrayList<>();
        for(Roupa r: this.roupasMap.values()){
            if(r.getDescricao().startsWith(prefixoDescricao)){
                roupasDescricao.add(r);
            }
        }
        return roupasDescricao;
    }

    @Override
    public Tamanho consultaTamanhoDaRoyhpa(String codigoRoupa) throws RoupaInexistenteException {
        if(this.roupasMap.containsKey(codigoRoupa)){
            return this.roupasMap.get(codigoRoupa).getTamanho();
        } else {
            throw new RoupaInexistenteException("A roupa com o código "+codigoRoupa+" não existe");
        }
    }

    @Override
    public void cadastraRoupa(String codigoRoupa, String descricao, Tamanho tamanho, int quantidade) throws RoupaJaExisteException {
        if(!this.roupasMap.containsKey(codigoRoupa)){
            this.roupasMap.put(codigoRoupa, new Roupa(codigoRoupa,descricao,quantidade, tamanho));
        } else {
            throw new RoupaJaExisteException("Roupa com o código "+codigoRoupa+" já existe");
        }
    }

    @Override
    public void alteraQuantidadeDeRoupaNoEstoque(String codigoRoupa, int novaQuantidade) throws RoupaInexistenteException {
        if(this.roupasMap.containsKey(codigoRoupa)){
            this.roupasMap.get(codigoRoupa).setQuantidade(novaQuantidade);
        } else {
            throw new RoupaInexistenteException("A roupa com o código "+codigoRoupa+ "não existe");
        }
    }

    @Override
    public int pesquisaQuantidadeDeRoupaNoEstoque(String codigoRoupa) throws RoupaInexistenteException {
        int quantRoupa = 0;
        if (this.roupasMap.containsKey(codigoRoupa)) {
           quantRoupa = this.roupasMap.get(codigoRoupa).getQuantidade();
        } else {
            throw new RoupaInexistenteException("A roupa com o código "+codigoRoupa+ "não existe");
        }
        return quantRoupa;
    }

    @Override
    public Roupa pesquisaRoupa(String codigoRoupa) throws RoupaInexistenteException {
        if(this.roupasMap.containsKey(codigoRoupa)){
            return this.roupasMap.get(codigoRoupa);
        } else {
            throw new RoupaInexistenteException("A roupa com o código "+codigoRoupa+ "não existe");
        }
    }
}
