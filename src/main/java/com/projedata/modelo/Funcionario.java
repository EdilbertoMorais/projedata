package com.projedata.modelo;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

//2 – Classe Funcionário que estenda a classe Pessoa, com os atributos: salário (BigDecimal) e função (String).
public class Funcionario extends Pessoa {
    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    public static final NumberFormat CURRENCY_FORMATTER = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));

    private BigDecimal salario;
    private String funcao;

    public Funcionario(String nome, String dataNascimento, BigDecimal salario, String funcao) {
        super(nome, dataNascimento);
        this.salario = salario;
        this.funcao = funcao;
    }

    public BigDecimal getSalario() {
        return salario.setScale(2, RoundingMode.HALF_EVEN);
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public String getFuncao() {
        return funcao;
    }

    @Override
    public String toString() {
        return
                "\n" + "Nome: " + this.getNome() + "\n" +
                "Data de Nascimento: " + this.getDataNascimento().format(DATE_FORMATTER) + "\n" +
                "Salário: " + CURRENCY_FORMATTER.format(this.getSalario()) + "\n" +
                "Função: " + this.getFuncao() + "\n";
    }

    public BigDecimal getSalariosMinimos(BigDecimal salarioMinimo) {
        return this.getSalario().divide(salarioMinimo, 2, RoundingMode.HALF_UP);
    }
}
