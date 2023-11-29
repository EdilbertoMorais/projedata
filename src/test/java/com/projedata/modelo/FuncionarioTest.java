package com.projedata.modelo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

class FuncionarioTest {

    @Test
    void deve_retornar_os_salarios_em_salarios_minimos() {
        Funcionario operador1 = new Funcionario("Zuma", "18/11/2000", new BigDecimal("200.00"), "Operador");
        BigDecimal salarioMinimo = new BigDecimal(10);

        BigDecimal salariosMinimos = operador1.getSalariosMinimos(salarioMinimo);

        Assertions.assertEquals(new BigDecimal(20).setScale(2, RoundingMode.HALF_UP), salariosMinimos);
    }
}