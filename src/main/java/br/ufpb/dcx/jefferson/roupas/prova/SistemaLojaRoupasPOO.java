package br.ufpb.dcx.jefferson.roupas.prova;

import com.sun.source.tree.BinaryTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SistemaLojaRoupasPOO implements SistemaLojaRoupas{
    private Map<String, Roupa> roupasMap;

    public SistemaLojaRoupasPOO() {
        this.roupasMap = new HashMap<>();
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
