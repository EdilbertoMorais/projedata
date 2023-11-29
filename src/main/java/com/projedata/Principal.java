package com.projedata;

import com.projedata.service.FuncionarioService;
import com.projedata.modelo.Funcionario;
import com.projedata.service.Impressora;

import java.math.BigDecimal;

public class Principal {


    public static void main(String[] args) {

        //3.1 – Inserir todos os funcionários, na mesma ordem e informações da tabela acima (Imagem da tabela fornecida no teste).
        FuncionarioService funcionarioDAO = new FuncionarioService();
        populaLista(funcionarioDAO);
        Impressora impressora = new Impressora(funcionarioDAO);
        impressora.imprimirTodosFuncionarios();

        //3.2 – Remover o funcionário “João” da lista.
        funcionarioDAO.removerFuncionarioPorNome("João");

        //3.3 – Imprimir todos os funcionários com todas suas informações, sendo que:
        //• informação de data deve ser exibido no formato dd/mm/aaaa;
        //• informação de valor numérico deve ser exibida no formatado com separador de milhar como ponto e decimal como vírgula.
        System.out.println("========= Impressão após a exclusão do João =========");
        impressora.imprimirTodosFuncionarios();

        //3.4 – Os funcionários receberam 10% de aumento de salário, atualizar a lista de funcionários com novo valor.
        funcionarioDAO.aumentarSalarios(10);
        impressora.imprimirTodosFuncionarios();

        //3.5 – Agrupar os funcionários por função em um MAP, sendo a chave a “função” e o valor a “lista de funcionários”.
        //3.6 – Imprimir os funcionários, agrupados por função.
        impressora.imprimirTodosFuncionariosPorFuncao();

        //3.7 – Não aparece no teste enviado

        //3.8 – Imprimir os funcionários que fazem aniversário no mês 10 e 12.
        impressora.imprimirAniversariantes(10, 12);

        //3.9 – Imprimir o funcionário com a maior idade, exibir os atributos: nome e idade.
        impressora.imprimirFuncionarioMaiorIdade();

        //3.10 – Imprimir a lista de funcionários por ordem alfabética.
        impressora.imprimirFuncionariosEmOrdemAlfabetica();

        //3.11 – Imprimir o total dos salários dos funcionários.
        impressora.imprimirTotalSalarios();

        //3.12 – Imprimir quantos salários mínimos ganha cada funcionário, considerando que o salário mínimo é R$1212.00.
        impressora.imprimirSalariosEmSalariosMinimos();
    }

    public static void populaLista(FuncionarioService funcionarioDao) {
            funcionarioDao.adicionaFuncionario(new Funcionario("Maria", "18/10/2000", new BigDecimal("2009.44"), "Operador"));
            funcionarioDao.adicionaFuncionario(new Funcionario("João", "12/05/1990", new BigDecimal("2284.38"), "Operador"));
            funcionarioDao.adicionaFuncionario(new Funcionario("Caio", "02/05/1961", new BigDecimal("9836.14"), "Coordenador"));
            funcionarioDao.adicionaFuncionario(new Funcionario("Miguel", "14/10/1988", new BigDecimal("19119.88"), "Diretor"));
            funcionarioDao.adicionaFuncionario(new Funcionario("Alice", "05/01/1995", new BigDecimal("2234.68"), "Recepcionista"));
            funcionarioDao.adicionaFuncionario(new Funcionario("Heitor", "19/11/1999", new BigDecimal("1582.72"), "Operador"));
            funcionarioDao.adicionaFuncionario(new Funcionario("Arthur", "31/03/1993", new BigDecimal("4071.84"), "Contador"));
            funcionarioDao.adicionaFuncionario(new Funcionario("Laura", "08/07/1994", new BigDecimal("3017.45"), "Gerente"));
            funcionarioDao.adicionaFuncionario(new Funcionario("Heloisa", "24/05/2003", new BigDecimal("1606.85"), "Eletricista"));
            funcionarioDao.adicionaFuncionario(new Funcionario("Helena", "02/09/1996", new BigDecimal("2799.93"), "Gerente"));
            funcionarioDao.adicionaFuncionario(new Funcionario("TESTE", "25/12/1986", new BigDecimal("1000.00"), "TESTE"));
        }
}

