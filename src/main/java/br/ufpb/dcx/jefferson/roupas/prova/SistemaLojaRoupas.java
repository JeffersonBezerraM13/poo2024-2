package br.ufpb.dcx.jefferson.roupas.prova;

import java.util.List;

public interface SistemaLojaRoupas {
    List<Roupa> pesquisaRoupasPorTamanho(Tamanho tamanhoRoupa);
    List<Roupa> pesquisaRoupasComDescricaoComecandoCom(String prefixoDescricao);
    Tamanho consultaTamanhoDaRoyhpa(String codigoRoupa) throws RoupaInexistenteException;
    void cadastraRoupa(String codigoRoupa, String descricao, Tamanho tamanho, int quantidade) throws RoupaJaExisteException;
    void alteraQuantidadeDeRoupaNoEstoque(String codigoRoupa, int novaQuantidade) throws RoupaInexistenteException;
    int pesquisaQuantidadeDeRoupaNoEstoque(String codigoRoupa) throws RoupaInexistenteException;
    Roupa pesquisaRoupa(String codigoRoupa) throws RoupaInexistenteException;
}
