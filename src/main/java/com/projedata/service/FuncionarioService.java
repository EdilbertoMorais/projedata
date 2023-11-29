package com.projedata.service;

import com.projedata.modelo.Funcionario;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.stream.Collectors;

public class FuncionarioService {

    private final List<Funcionario> funcionarios = new ArrayList<>();

    public void adicionaFuncionario(Funcionario funcionario) {
        funcionarios.add(funcionario);
    }

    public void removerFuncionarioPorNome(String nome) {
        funcionarios.removeIf(funcionario -> nome.equals(funcionario.getNome()));
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void aumentarSalarios(int percentual) {
        BigDecimal percentualDecimal = BigDecimal.valueOf(percentual).divide(BigDecimal.valueOf(100), 4, RoundingMode.HALF_UP);

        for (Funcionario funcionario : funcionarios) {
            BigDecimal salarioAtual = funcionario.getSalario();
            BigDecimal aumento = salarioAtual.multiply(percentualDecimal);
            BigDecimal novoSalario = salarioAtual.add(aumento);
            funcionario.setSalario(novoSalario);
        }
    }

    public Map<String, List<Funcionario>> agruparPorFuncao() {
        return funcionarios.stream().collect(Collectors.groupingBy(Funcionario::getFuncao));
    }

    public List<Funcionario> getAniversariantesDoMes(int... meses) {
        return funcionarios.stream()
                .filter(funcionario -> {
                    int mesAniversario = funcionario.getDataNascimento().getMonthValue();
                    return Arrays.stream(meses).boxed().toList().contains(mesAniversario);
                })
                .collect(Collectors.toList());
    }

    public Funcionario getFuncionarioMaisVelho() {
        return funcionarios.stream()
                .min(Comparator.comparing(Funcionario::getDataNascimento))
                .orElse(null);
    }

    public List<Funcionario> getListaPorOrdemAlfabetica() {
        return funcionarios.stream()
                .sorted(Comparator.comparing(Funcionario::getNome))
                .collect(Collectors.toList());
    }

    public BigDecimal somaSalarios() {
        return funcionarios.stream()
                .map(Funcionario::getSalario)
                .reduce(BigDecimal.ZERO, BigDecimal::add).setScale(2, RoundingMode.HALF_UP);
    }
}
