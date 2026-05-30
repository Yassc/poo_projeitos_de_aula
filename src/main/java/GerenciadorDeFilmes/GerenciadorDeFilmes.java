package GerenciadorDeFilmes;

import java.util.ArrayList;
import java.util.List;

public class GerenciadorDeFilmes {
    private List<Filme> listaDeFilmes;
    private List<Filme> filmesFavoritos;


    public GerenciadorDeFilmes() {
        this.listaDeFilmes = new ArrayList<>();
    }

    public void adicionarFilme(Filme f){
        this.listaDeFilmes.add(f);
        this.filmesFavoritos = new ArrayList<>();
    }

    public Filme buscarPorTitulo(String titulo) throws filmeNaoEncontradoException {
        for (Filme f : listaDeFilmes){
            if (f.getTitulo().equalsIgnoreCase(titulo)){
                return f;
            }
        }
        throw new filmeNaoEncontradoException("O filme " + titulo + " não existe no catálogo.");
    }

    public String removerPorAno(int ano) throws filmeNaoEncontradoException {
        for (Filme f : listaDeFilmes) {
            if (f.getAno() == ano) {
                listaDeFilmes.remove(f);
                return "GerenciadorDeFilmes.Filme removido!";
            }
        }
        throw new filmeNaoEncontradoException("Não há filmes do " + ano + " no catálogo.\n Falha ao remover!");
    }

    public String adicionarAosFavoritos(String titulo) throws filmeNaoEncontradoException {
        for (Filme f : listaDeFilmes){
            if (f.getTitulo().equalsIgnoreCase(titulo)){
                filmesFavoritos.add(f);
                return "O filme " + titulo + " foi adicionado aos seus favoritos!";
            }
        }
        throw new filmeNaoEncontradoException("O filme " + titulo + " não existe no catálogo.");
    }
    public void listarFavoritos() {
        if (filmesFavoritos.isEmpty()) {
            System.out.println("Sua lista de favoritos está vazia.");
        } else {
            System.out.println("\n--- MEUS FAVORITOS ---");
            for (Filme f : filmesFavoritos) {
                System.out.println(f.ExibirDetalhes());
                System.out.println("-----------------------");
            }
        }
    }
}

