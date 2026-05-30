package SistemaAmigoSecreto;

import java.util.List;

public class TestaSistemaAmigo {
    public static void main(String[] args) {
        SistemaAmigo sistema = new SistemaAmigo();

        sistema.cadastraAmigo("José", "jose@email.com");
        sistema.cadastraAmigo("Maria", "maria@email.com");

        try {
            sistema.configuraAmigoSecretoDe("jose@email.com", "maria@email.com");
            sistema.configuraAmigoSecretoDe("maria@email.com", "jose@email.com");
        } catch (AmigoInexistenteException e) {
            System.out.println("Erro ao configurar amigo secreto: " + e.getMessage());
        }

        sistema.enviarMensagemParaAlguem("Olá José, adivinhe quem é?", "maria@email.com", "jose@email.com", true);

        sistema.enviarMensagemParaTodos("Feliz Amigo Secreto a todos!", "maria@email.com", true);

        System.out.println("--- Mensagens Anônimas Encontradas ---");
        List<Mensagem> anonimas = sistema.pesquisaMensagensAnonimas();
        for (Mensagem m : anonimas) {
            System.out.println(m.getTextoCompletoAExibir());
        }
        
        System.out.println("\n--- Verificação do Sorteio ---");
        try {
            String emailSorteado = sistema.pesquisaAmigoSecretoDe("jose@email.com");
            if (emailSorteado.equals("maria@email.com")) {
                System.out.println("Ok");
            }
        } catch (AmigoInexistenteException | AmigoNaoSorteadoException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        }
    }
}