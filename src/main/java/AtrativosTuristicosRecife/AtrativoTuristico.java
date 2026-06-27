package AtrativosTuristicosRecife;

import java.util.ArrayList;
import java.util.List;

public class AtrativoTuristico {
    private String nome;
    private String descricao;
    private TipoAtrativo tipo;
    private List<String> sitesParaMaisInfo;

    public AtrativoTuristico(String nome, String descricao, TipoAtrativo tipo, List<String> sitesParaMaisInfo) {
        this.nome = nome;
        this.descricao = descricao;
        this.tipo = tipo;
        this.sitesParaMaisInfo = sitesParaMaisInfo;
    }

    public AtrativoTuristico() {
        this("","",null,new ArrayList<>());

    }
    public boolean ehDoTipo(TipoAtrativo tipo) {
        return this.tipo == tipo;


    }

    public void adicionaSiteMaisInfo(String novoSite) {}

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public TipoAtrativo getTipo() {
        return tipo;
    }

    public void setTipo(TipoAtrativo tipo) {
        this.tipo = tipo;
    }

    public List<String> getSitesParaMaisInfo() {
        return sitesParaMaisInfo;
    }

    public void setSitesParaMaisInfo(List<String> sitesParaMaisInfo) {
        this.sitesParaMaisInfo = sitesParaMaisInfo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
