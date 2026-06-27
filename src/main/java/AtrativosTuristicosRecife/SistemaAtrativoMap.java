package AtrativosTuristicosRecife;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SistemaAtrativoMap implements SistemaAtrativos {

    private final Map<String, AtrativoTuristico> atrativos;

    public SistemaAtrativoMap() {
        this.atrativos = new HashMap<String, AtrativoTuristico>();
    }

    @Override
    public void cadastraAtrativo(AtrativoTuristico atrativo) throws AtrativoJaExisteException {
        if (this.atrativos.containsKey(atrativo.getNome())) {
            throw new AtrativoJaExisteException("Já existe atrativo com este nome");
        } else {
            this.atrativos.put(atrativo.getNome(), atrativo);
        }
    }

    public AtrativoTuristico pesquisaAtrativo(String nome) {
        if  (this.atrativos.containsKey(nome)) {
            return this.atrativos.get(nome);
        }
        return null;
    }

    public List<AtrativoTuristico> pesquisaAtrativosDoTipo(TipoAtrativo tipo) {
        List<AtrativoTuristico> atrativosDoTipo = new ArrayList<>();
        for (AtrativoTuristico atrativo : this.atrativos.values()) {
            if (atrativo.getTipo().equals(tipo)) {
                atrativosDoTipo.add(atrativo);
            }
        }
        return atrativosDoTipo;

    }

    public List<String> pesquisaSitesComMaisInformacoesSobreAtrativo(String nomeAtrativo) {
        List<String> SiteComMaisInformacoesSobreAtrativo;
        SiteComMaisInformacoesSobreAtrativo = new ArrayList<>();
        for (String site : this.atrativos.keySet()) {
            if (site.equals(nomeAtrativo)) {
                SiteComMaisInformacoesSobreAtrativo.add(site);
            }
        }
        return SiteComMaisInformacoesSobreAtrativo;

    }

    public int contaAtrativosDoTipo(TipoAtrativo tipo) {
        int contador= 0;
        for (AtrativoTuristico atrativo : this.atrativos.values()) {
            if (atrativo.getTipo().equals(tipo)) {
                contador++;
            }
        }
        return contador;
    }

    public boolean existeAtrativo(String nome){
        return this.atrativos.containsKey(nome);
    }
}
