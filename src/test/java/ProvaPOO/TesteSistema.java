package ProvaPOO;

import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TesteSistema {

    @Test
    public void testarSistemaBomPrato() {
        SistemaFuncionarios sistema = new SistemaFuncionariosBomPrato();

        Funcionario f1 = new Funcionario("111.111.111-11", "Ana", TipoFuncionario.GERENTE, 4500.0);
        sistema.cadastrarFuncionario(f1);

        sistema.cadastrarFuncionario("222.222.222-22", "Carlos", TipoFuncionario.GARCON, 1500.0);
        sistema.cadastrarFuncionario("333.333.333-33", "Bia", TipoFuncionario.COZINHEIRO, 2500.0);
        sistema.cadastrarFuncionario("444.444.444-44", "Daniel", TipoFuncionario.GARCON, 1600.0);

        assertTrue(sistema.funcionarioJaExiste("111.111.111-11"));
        assertTrue(sistema.funcionarioJaExiste("222.222.222-22"));
        assertFalse(sistema.funcionarioJaExiste("999.999.999-99"));

        Funcionario gerente = sistema.pesquisarFuncionario("111.111.111-11");
        assertNotNull(gerente);
        assertEquals("Ana", gerente.getNome());

        assertEquals(2, sistema.contarFuncionariosDoTipo(TipoFuncionario.GARCON));
        assertEquals(1, sistema.contarFuncionariosDoTipo(TipoFuncionario.GERENTE));

        List<Funcionario> garcons = sistema.pesquisarFuncionariosPorTipo(TipoFuncionario.GARCON);
        assertEquals(2, garcons.size());

        List<Funcionario> faxineiros = sistema.pesquisarFuncionariosPorTipo(TipoFuncionario.FAXINEIRO);
        assertEquals(0, faxineiros.size());

        sistema.alterarSalarioDeFuncionario("222.222.222-22", 1850.0);
        Funcionario carlos = sistema.pesquisarFuncionario("222.222.222-22");
        assertEquals(1850.0, carlos.getSalario());

        List<Funcionario> salariosAltos = sistema.pesquisarFuncionariosComSalarioMaiorQue(2000.0);
        assertEquals(2, salariosAltos.size());
    }
}