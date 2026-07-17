package ProvaPOO;

import java.util.List;

public interface SistemaFuncionarios {
    void cadastrarFuncionario(Funcionario funcionario);
    void cadastrarFuncionario(String cpf, String nome, TipoFuncionario tipoFuncionario, double salario);
    void alterarSalarioDeFuncionario(String cpfFuncionario, double novoSalario);
    int contarFuncionariosDoTipo(TipoFuncionario tipo);
    boolean funcionarioJaExiste(String cpfFuncionario);
    List<Funcionario> pesquisarFuncionariosPorTipo(TipoFuncionario tipo);
    Funcionario pesquisarFuncionario(String cpfFuncionario);
    List<Funcionario> pesquisarFuncionariosComSalarioMaiorQue(double valor);
}
