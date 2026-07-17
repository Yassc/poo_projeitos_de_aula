package ProvaPOO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SistemaFuncionariosBomPrato implements SistemaFuncionarios {

    private Map<String, Funcionario> funcionarios;

    public SistemaFuncionariosBomPrato() {
        this.funcionarios = new HashMap<>();
    }

    @Override
    public void cadastrarFuncionario(Funcionario funcionario) {
        this.funcionarios.put(funcionario.getCpf(), funcionario);
    }

    @Override
    public void cadastrarFuncionario(String cpf, String nome, TipoFuncionario tipoFuncionario, double salario) {
        this.cadastrarFuncionario(new Funcionario(cpf, nome, tipoFuncionario, salario));
    }

    @Override
    public void alterarSalarioDeFuncionario(String cpfFuncionario, double novoSalario) {
        Funcionario f = pesquisarFuncionario(cpfFuncionario);
        if (f != null) {
            f.setSalario(novoSalario);
        }
    }

    @Override
    public int contarFuncionariosDoTipo(TipoFuncionario tipo) {
        int contador = 0;
        for (Funcionario f : this.funcionarios.values()) {
            if (f.getTipo() == tipo) {
                contador++;
            }
        }
        return contador;
    }

    @Override
    public boolean funcionarioJaExiste(String cpfFuncionario) {
        return this.funcionarios.containsKey(cpfFuncionario);
    }

    @Override
    public List<Funcionario> pesquisarFuncionariosPorTipo(TipoFuncionario tipo) {
        List<Funcionario> resultado = new ArrayList<>();
        for (Funcionario f : this.funcionarios.values()) {
            if (f.getTipo() == tipo) {
                resultado.add(f);
            }
        }
        return resultado;
    }

    @Override
    public Funcionario pesquisarFuncionario(String cpfFuncionario) {
        return this.funcionarios.get(cpfFuncionario);
    }

    @Override
    public List<Funcionario> pesquisarFuncionariosComSalarioMaiorQue(double valor) {
        List<Funcionario> resultado = new ArrayList<>();
        for (Funcionario f : this.funcionarios.values()) {
            if (f.getSalario() > valor) {
                resultado.add(f);
            }
        }
        return resultado;
    }
}