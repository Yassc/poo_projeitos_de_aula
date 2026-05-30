package SistemaAmigoSecreto;

import org.testng.annotations.Test;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertNotNull;
import static org.testng.AssertJUnit.fail;
import java.util.List;

public class TestaSistemaMap {

    @Test
    public void testCadastroEPesquisaDeAmigo() {
        SistemaAmigoMap sistema = new SistemaAmigoMap();

        sistema.cadastraAmigo("Maria", "maria@email.com");

        Amigo amigoCadastrado = sistema.pesquisaAmigo("maria@email.com");

        assertNotNull(amigoCadastrado);
        assertEquals("Maria", amigoCadastrado.getNome());
    }

    @Test
    public void testConfigurarAmigoSecreto() {
        SistemaAmigoMap sistema = new SistemaAmigoMap();

        sistema.cadastraAmigo("Maria", "maria@email.com");
        sistema.cadastraAmigo("José", "jose@email.com");

        sistema.configuraAmigoSecretoDe("maria@email.com", "jose@email.com");

        String sorteado = sistema.pesquisaAmigoSecretoDe("maria@email.com");

        assertEquals("jose@email.com", sorteado);
    }

    @Test
    public void testEnvioEPesquisaDeMensagensAnonimas() {
        SistemaAmigoMap sistema = new SistemaAmigoMap();

        sistema.cadastraAmigo("Maria", "maria@email.com");
        sistema.cadastraAmigo("José", "jose@email.com");

        sistema.enviarMensagemParaAlguem("Texto Secreto", "maria@email.com", "jose@email.com", true);
        sistema.enviarMensagemParaAlguem("Texto Aberto", "jose@email.com", "maria@email.com", false);

        List<Mensagem> anonimas = sistema.pesquisarMensagensAnonimas();

        assertEquals(1, anonimas.size());
        assertEquals("Texto Secreto", anonimas.get(0).getTexto());
    }

    @Test
    public void testExcecaoAmigoInexistente() {
        SistemaAmigoMap sistema = new SistemaAmigoMap();

        sistema.pesquisaAmigoSecretoDe("email_fantasma@email.com");
        fail("Deveria ter lançado AmigoInexistenteException");
    }
}