package AtrativosTuristicosRecife;

import java.util.List;

public interface SistemaAtrativos {
    void cadastraAtrativo(AtrativoTuristico atrativo) throws AtrativoJaExisteException;

    AtrativoTuristico pesquisaAtrativo(String nome) throws AtrativoNaoExisteException;

    List<AtrativoTuristico> pesquisaAtrativosDoTipo(TipoAtrativo tipo);

    List<String> pesquisaSitesComMaisInformacoesSobreAtrativo(String nomeAtrativo)
            throws AtrativoNaoExisteException;

    int contaAtrativosDoTipo(TipoAtrativo tipo);

    boolean existeAtrativo(String nome);

}
