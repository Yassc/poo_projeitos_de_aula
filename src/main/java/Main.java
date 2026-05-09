import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GerenciadorDeFilmes catalogo = new GerenciadorDeFilmes();
        int menu = 0;

        while (menu != 5) {

            System.out.println("\n--- MENU CINEMA ---");
            System.out.println("1. Adicionar Filme");
            System.out.println("2. Buscar por Título");
            System.out.println("3. Adicionar aos favoritos");
            System.out.println("4. Remover por Ano");
            System.out.println("5. Ver Favoritos");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");

            if (scanner.hasNextInt()) {
                menu = scanner.nextInt();
                scanner.nextLine();
            } else {
                System.out.println("Erro: Digite apenas números de 1 a 5!");
                scanner.nextLine();
                continue;
            }

            try {
                switch (menu) {
                    case 1:
                        System.out.println("\n---ADICIONAR FILME---");
                        System.out.print("Titulo: ");
                        String titulo = scanner.nextLine();
                        System.out.print("Diretor: ");
                        String diretor = scanner.nextLine();
                        System.out.print("Ano de lançamento: ");
                        int ano = scanner.nextInt();
                        System.out.print("Duração (min): ");
                        int duracao = scanner.nextInt();

                        catalogo.adicionarFilme(new Filme(titulo, diretor, ano, duracao));
                        System.out.println("Filme cadastrado!");
                        break;

                    case 2:
                        System.out.print("Digite o título para buscar: ");
                        String busca = scanner.nextLine();
                        Filme f = catalogo.buscarPorTitulo(busca);
                        System.out.println("Resultado: " + f.ExibirDetalhes());
                        break;

                    case 3:
                        System.out.print("Filme que deseja adicionar à lista de favoritos: ");
                        String favorito = scanner.nextLine();
                        System.out.println(catalogo.adicionarAosFavoritos(favorito));
                        break;

                    case 4:
                        System.out.print("Digite o ano para remover: ");
                        int anoRemover = scanner.nextInt();
                        System.out.println(catalogo.removerPorAno(anoRemover));
                        break;

                    case 5:
                        catalogo.listarFavoritos();
                        break;

                    case 6:
                        System.out.println("Encerrando sistema...");
                        break;

                    default:
                        System.out.println("Opção inválida!");

                }
            } catch (filmeNaoEncontradoException e) {
                System.out.println("Erro: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Ocorreu um erro inesperado.");
            }


        }
        scanner.close();
    }
}