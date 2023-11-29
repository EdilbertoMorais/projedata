package com.projedata.service;

import com.projedata.modelo.Funcionario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Map;


class FuncionarioServiceTest {

    FuncionarioService funcionarioDAO;

    @BeforeEach
    void setUp() {
        funcionarioDAO = new FuncionarioService();
    }

    @Test
    void deve_adicionar_um_funcionario() {
        Funcionario funcionario = new Funcionario("Teste", "18/10/2000", new BigDecimal("2009.44"), "Operador");
        funcionarioDAO.adicionaFuncionario(funcionario);

        Assertions.assertTrue(funcionarioDAO.getFuncionarios().contains(funcionario));

    }

    @Test
    void deve_remover_um_funcionario_que_existe_na_lista() {
        Funcionario funcionario = new Funcionario("Teste", "18/10/2000", new BigDecimal("2009.44"), "Operador");
        funcionarioDAO.adicionaFuncionario(funcionario);

        funcionarioDAO.removerFuncionarioPorNome("Teste");

        Assertions.assertFalse(funcionarioDAO.getFuncionarios().contains(funcionario));
    }

    @Test
    void nao_deve_retornar_um_erro_ao_tentar_remover_um_funcionario_que_nao_existe() {
        Funcionario funcionario = new Funcionario("Teste", "18/10/2000", new BigDecimal("2009.44"), "Operador");

        funcionarioDAO.removerFuncionarioPorNome("Teste");

        Assertions.assertFalse(funcionarioDAO.getFuncionarios().contains(funcionario));
    }

    @Test
    void deve_aumentar_o_salario_de_todos_os_funcionarios_da_lista_numa_determinada_porcentagem() {
        Funcionario funcionario1 = new Funcionario("TESTE", "18/10/2000", new BigDecimal("200.00"), "Operador");
        Funcionario funcionario2 = new Funcionario("TESTE2", "18/10/2000", new BigDecimal("100.00"), "Operador");
        funcionarioDAO.adicionaFuncionario(funcionario1);
        funcionarioDAO.adicionaFuncionario(funcionario2);

        funcionarioDAO.aumentarSalarios(10);

        List<Funcionario> funcionariosAposAumento = funcionarioDAO.getFuncionarios();

        Assertions.assertEquals(new BigDecimal("220.00").setScale(2, RoundingMode.HALF_UP), funcionariosAposAumento.get(0).getSalario());
        Assertions.assertEquals(new BigDecimal("110.00").setScale(2, RoundingMode.HALF_UP), funcionariosAposAumento.get(1).getSalario());
    }

    @Test
    void deve_agrupar_os_funcionarios_por_funcao() {
        Funcionario operador1 = new Funcionario("TESTE1", "18/10/2000", new BigDecimal("200.00"), "Operador");
        Funcionario operador2 = new Funcionario("TESTE2", "18/10/2000", new BigDecimal("100.00"), "Operador");
        Funcionario gerente = new Funcionario("TESTE3", "18/10/2000", new BigDecimal("100.00"), "Gerente");
        funcionarioDAO.adicionaFuncionario(operador1);
        funcionarioDAO.adicionaFuncionario(operador2);
        funcionarioDAO.adicionaFuncionario(gerente);

        Map<String, List<Funcionario>> funcionariosAgrupadosPorFuncao = funcionarioDAO.agruparPorFuncao();

        Assertions.assertEquals(2, funcionariosAgrupadosPorFuncao.get("Operador").size());
        Assertions.assertEquals(1, funcionariosAgrupadosPorFuncao.get("Gerente").size());

    }

    @Test
    void deve_retornar_aniversariantes_dos_meses_especificados_em_uma_lista() {
        Funcionario operador1 = new Funcionario("TESTE1", "18/11/2000", new BigDecimal("200.00"), "Operador");
        Funcionario operador2 = new Funcionario("TESTE2", "18/10/2000", new BigDecimal("100.00"), "Operador");
        Funcionario gerente = new Funcionario("TESTE3", "18/12/2000", new BigDecimal("100.00"), "Gerente");
        funcionarioDAO.adicionaFuncionario(operador1);
        funcionarioDAO.adicionaFuncionario(operador2);
        funcionarioDAO.adicionaFuncionario(gerente);

        List<Funcionario> aniversariantes = funcionarioDAO.getAniversariantesDoMes(10, 12);

        Assertions.assertEquals(2, aniversariantes.size());
        Assertions.assertEquals(operador2, aniversariantes.get(0));
        Assertions.assertEquals(gerente, aniversariantes.get(1));
    }

    @Test
    void deve_retornar_primeiro_funcionario_mais_velho_encontrado() {
        Funcionario operador1 = new Funcionario("TESTE1", "18/11/2000", new BigDecimal("200.00"), "Operador");
        Funcionario operador2 = new Funcionario("TESTE2", "18/10/2000", new BigDecimal("100.00"), "Operador");
        Funcionario operador3 = new Funcionario("TESTE4", "18/10/2000", new BigDecimal("100.00"), "Operador");
        Funcionario gerente = new Funcionario("TESTE3", "18/12/2000", new BigDecimal("100.00"), "Gerente");
        funcionarioDAO.adicionaFuncionario(operador1);
        funcionarioDAO.adicionaFuncionario(operador2);
        funcionarioDAO.adicionaFuncionario(operador3);
        funcionarioDAO.adicionaFuncionario(gerente);

        Funcionario maisVelho = funcionarioDAO.getFuncionarioMaisVelho();

        Assertions.assertEquals(operador2, maisVelho);
    }

    @Test
    void deve_uma_lista_de_funcionarios_ordenada_por_ordem_alfabetica() {
        Funcionario operador1 = new Funcionario("Zuma", "18/11/2000", new BigDecimal("200.00"), "Operador");
        Funcionario operador2 = new Funcionario("Chase", "18/10/2000", new BigDecimal("100.00"), "Operador");
        Funcionario operador3 = new Funcionario("Ruble", "18/10/2000", new BigDecimal("100.00"), "Operador");
        funcionarioDAO.adicionaFuncionario(operador1);
        funcionarioDAO.adicionaFuncionario(operador2);
        funcionarioDAO.adicionaFuncionario(operador3);

        List<Funcionario> ordenado = funcionarioDAO.getListaPorOrdemAlfabetica();

        Assertions.assertEquals(operador2, ordenado.get(0));
        Assertions.assertEquals(operador3, ordenado.get(1));
        Assertions.assertEquals(operador1, ordenado.get(2));
    }

    @Test
    void deve_fazer_o_somatorio_dos_salarios() {
        Funcionario operador1 = new Funcionario("Zuma", "18/11/2000", new BigDecimal("200.00"), "Operador");
        Funcionario operador2 = new Funcionario("Chase", "18/10/2000", new BigDecimal("100.00"), "Operador");
        Funcionario operador3 = new Funcionario("Ruble", "18/10/2000", new BigDecimal("100.00"), "Operador");
        funcionarioDAO.adicionaFuncionario(operador1);
        funcionarioDAO.adicionaFuncionario(operador2);
        funcionarioDAO.adicionaFuncionario(operador3);

        BigDecimal somatorio = funcionarioDAO.somaSalarios();

        Assertions.assertEquals(new BigDecimal("400.00").setScale(2, RoundingMode.HALF_UP), somatorio);
    }
}
