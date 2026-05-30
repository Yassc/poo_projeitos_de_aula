package SistemaAmigoSecreto;

public class MensagemParaTodos extends Mensagem {

    public MensagemParaTodos(String texto, String emailRemetente, boolean anonima) {
        super(texto, emailRemetente, anonima);
    }

    @Override
    public String getTextoCompletoAExibir() {
        String remetente = ehAnonima() ? "Anônimo" : getEmailRemetente();
        return "Mensagem de: " + remetente + " para TODOS\nTexto: " + getTexto();
    }
}