package AtrativosTuristicosRecife;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.testng.Assert.assertEquals;
import static org.testng.AssertJUnit.fail;

class SistemaAtrativosMapTest {
    @Test
    public void test() {
        SistemaAtrativoMap sistema = new SistemaAtrativoMap();
        String descricao = "Praia em João Pessoa com vários bares, restaurantes e hoteis";
        AtrativoTuristico atrativo1 = new AtrativoTuristico("Praia de Manaíra",
                descricao, TipoAtrativo.PRAIA, new ArrayList<>());
        atrativo1.adicionaSiteMaisInfo("https://paraondeir.blog/praia-de-manaira/");
        try {
            sistema.cadastraAtrativo(atrativo1);
            AtrativoTuristico atrativoAchado = sistema.pesquisaAtrativo("Praia de Manaíra");
            assertEquals(atrativoAchado.getDescricao(), descricao);
            //TODO: ACRESCENTAR CÓDIGO AQUI
        } catch (AtrativoJaExisteException e) {
            Assertions.fail("Não deveria lançar exceções nestes casos");
        }
    }
}
