package SistemaAmigoSecreto;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class SistemaAmigoMap {

    private Map<String, Amigo> amigos;
    private List<Mensagem> mensagens;

    public SistemaAmigoMap() {
        this.amigos = new HashMap<>();
        this.mensagens = new ArrayList<>();
    }


    public void cadastraAmigo(String nomeAmigo, String emailAmigo) {
        Amigo novoAmigo = new Amigo(nomeAmigo, emailAmigo);
        this.amigos.put(emailAmigo, novoAmigo);
    }


    public Amigo pesquisaAmigo(String emailAmigo) {
        return this.amigos.get(emailAmigo);
    }


    public void enviarMensagemParaTodos(String texto, String emailRemetente, Boolean ehAnonima) {
        Mensagem mensagemParaTodos = new MensagemParaTodos(texto, emailRemetente, ehAnonima);
        this.mensagens.add(mensagemParaTodos);
    }


    public void enviarMensagemParaAlguem(String texto, String emailRemetente, String emailDestinatario, boolean anonima) {
        Mensagem mensagemParaAlguem = new MensagemParaAlguem(texto, emailRemetente, emailDestinatario, anonima);
        this.mensagens.add(mensagemParaAlguem);
    }


    public List<Mensagem> pesquisarMensagensAnonimas() {
        List<Mensagem> anonimas = new ArrayList<>();
        for (Mensagem msg : this.mensagens) {
            if (msg.ehAnonima()) {
                anonimas.add(msg);
            }
        }
        return anonimas;
    }


    public List<Mensagem> pesquisarTodasAsMensagens() {
        List<Mensagem> todas = new ArrayList<>();
        for (Mensagem msg : this.mensagens) {
            todas.add(msg);
        }
        return todas;
    }


    public void configuraAmigoSecretoDe(String emailDaPessoa, String emailSorteado) {
        Amigo pessoa = pesquisaAmigo(emailDaPessoa);
        if (pessoa != null) {
            pessoa.setEmailAmigoSorteado(emailSorteado);
        }
    }


    public String pesquisaAmigoSecretoDe(String emailDaPessoa) {
        Amigo pessoa = pesquisaAmigo(emailDaPessoa);
        if (pessoa != null) {
            return pessoa.getEmailAmigoSorteado();
        }
        return null;
    }
}