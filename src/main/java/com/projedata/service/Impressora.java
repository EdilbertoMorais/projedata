package com.projedata.service;

import com.projedata.modelo.Funcionario;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Map;

import static com.projedata.modelo.Funcionario.CURRENCY_FORMATTER;

public class Impressora {
    private FuncionarioService funcionarioDAO;

    public Impressora(FuncionarioService funcionarioDAO) {
        this.funcionarioDAO = funcionarioDAO;
    }

    public void imprimirTodosFuncionarios() {
        System.out.println(funcionarioDAO.getFuncionarios());
    }

    public void imprimirTodosFuncionariosPorFuncao() {
        Map<String, List<Funcionario>> funcionariosAgrupados = funcionarioDAO.agruparPorFuncao();

        System.out.println("=== Lista de Funcionários Agrupados por Função ===");
        funcionariosAgrupados.forEach((funcao, lista) -> {
            System.out.println("Função: " + funcao);
            System.out.println("Funcionários:");

            lista.forEach(System.out::println);

            System.out.println("===========================");
        });
    }

    public void imprimirAniversariantes(int... meses) {
        List<Funcionario> aniversariantes = funcionarioDAO.getAniversariantesDoMes(meses);

        System.out.println("=== Aniversariantes dos Meses ===");
        System.out.println(aniversariantes);
    }

    public void imprimirFuncionarioMaiorIdade() {
        Funcionario funcionarioMaiorIdade = funcionarioDAO.getFuncionarioMaisVelho();

        int idade = Period.between(funcionarioMaiorIdade.getDataNascimento(), LocalDate.now()).getYears();

        System.out.println("=== Funcionário com Maior Idade ===");
        System.out.println("Nome: " + funcionarioMaiorIdade.getNome());
        System.out.println("Idade: " + idade);
        System.out.println("===========================");
    }

    public void imprimirFuncionariosEmOrdemAlfabetica() {
        List<Funcionario> funcionariosOrdenados = funcionarioDAO.getListaPorOrdemAlfabetica();

        System.out.println("=== Lista de Funcionários em Ordem Alfabética ===");
        System.out.println(funcionariosOrdenados);
    }

    public void imprimirTotalSalarios() {
        BigDecimal totalSalarios = funcionarioDAO.somaSalarios();

        System.out.println("=== Total da soma dos Salários dos Funcionários ===");
        System.out.println("Total: " + CURRENCY_FORMATTER.format(totalSalarios));
        System.out.println("===========================");
    }

    public void imprimirSalariosEmSalariosMinimos() {
        List<Funcionario> funcionarios = funcionarioDAO.getFuncionarios();

        BigDecimal salarioMinimo = new BigDecimal("1212.00");

        System.out.println("=== Salários dos Funcionários em Salário Mínimo ===");
        for (Funcionario funcionario : funcionarios) {
            BigDecimal salariosMinimos = funcionario.getSalariosMinimos(salarioMinimo);
            System.out.println(funcionario.getNome() + ": recebe " + salariosMinimos + " salários mínimos");
        }
        System.out.println("===========================");
    }
}
