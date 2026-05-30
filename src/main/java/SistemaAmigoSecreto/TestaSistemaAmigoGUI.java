package SistemaAmigoSecreto;

import java.util.Scanner;

public class TestaSistemaAmigoGUI {
    public static void main(String[] args) {

        SistemaAmigo sistema = new SistemaAmigo();
        Scanner leitor = new Scanner(System.in);

        System.out.print("Digite a quantidade de participantes: ");
        int qtdAmigos = leitor.nextInt();
        leitor.nextLine();

        for (int i = 0; i < qtdAmigos; i++) {
            System.out.println("\n--- Cadastro do Participante " + (i + 1) + " ---");
            System.out.print("Nome: ");
            String nome = leitor.nextLine();
            System.out.print("E-mail: ");
            String email = leitor.nextLine();

            sistema.cadastraAmigo(nome, email);
        }

        System.out.println("\n--- Configuração do Sorteio (Quem pegou quem) ---");
        for (int i = 0; i < qtdAmigos; i++) {
            System.out.print("Digite o e-mail de quem vai tirar (Remetente): ");
            String emailDaPessoa = leitor.nextLine();
            System.out.print("Digite o e-mail do Amigo Secreto dele(a) (Sorteado): ");
            String emailAmigoSorteado = leitor.nextLine();

            try {
                sistema.configuraAmigoSecretoDe(emailDaPessoa, emailAmigoSorteado);
                System.out.println("Sorteio configurado com sucesso para este participante!");
            } catch (AmigoInexistenteException e) {
                System.out.println("Erro: " + e.getMessage() + " Tente novamente para este par.");
                i--; // Decrementa o contador para refazer a entrada deste participante se houver erro
            }
        }

        System.out.println("\n--- Envio de Mensagem para Todos ---");
        System.out.print("Digite o e-mail do remetente da mensagem: ");
        String remetenteMsg = leitor.nextLine();

        System.out.print("Digite o texto da mensagem: ");
        String textoMsg = leitor.nextLine();

        System.out.print("A mensagem deve ser anônima? (sim/nao): ");
        String opcaoAnonima = leitor.nextLine();
        boolean ehAnonima = opcaoAnonima.equalsIgnoreCase("sim");

        sistema.enviarMensagemParaTodos(textoMsg, remetenteMsg, ehAnonima);
        System.out.println("Mensagem enviada com sucesso para todos!");

        leitor.close();
    }
}