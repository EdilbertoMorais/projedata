package com.projedata.modelo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


// 1– Classe Pessoa com os atributos: nome (String) e data nascimento (LocalDate).
public class Pessoa {

    private String nome;
    private LocalDate dataNascimento;

    public Pessoa(String nome, String dataNascimento) {
        this.nome = nome;
        this.dataNascimento = LocalDate.parse(dataNascimento, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}
