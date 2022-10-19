package com.consumer.consumer.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ExibicaoConsumerDTO {
    private Long id;
    @JsonProperty("titular_da_conta")
    private String titularDaConta;
    private String cpf;
    @JsonProperty("numero_da_conta")
    private int numeroDaConta;
    @JsonProperty("agencia_bancaria")
    private int agenciaBancaria;
    @JsonProperty("saldo_da_conta")
    private Double saldoDaConta;

    @JsonProperty("status_da_conta")
    private Long statusDaConta;

    public ExibicaoConsumerDTO() {
    }

    public ExibicaoConsumerDTO(Long id, String titularDaConta, String cpf, int numeroDaConta,
                               int agenciaBancaria, Double saldoDaConta, Long statusDaConta) {
        this.id = id;
        this.titularDaConta = titularDaConta;
        this.cpf = cpf;
        this.numeroDaConta = numeroDaConta;
        this.agenciaBancaria = agenciaBancaria;
        this.saldoDaConta = saldoDaConta;
        this.statusDaConta = statusDaConta;
    }

    public Long getId() {
        return id;
    }

    public String getTitularDaConta() {
        return titularDaConta;
    }

    public int getNumeroDaConta() {
        return numeroDaConta;
    }

    public int getAgenciaBancaria() {
        return agenciaBancaria;
    }

    public Double getSaldoDaConta() {
        return saldoDaConta;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitularDaConta(String titularDaConta) {
        this.titularDaConta = titularDaConta;
    }

    public void setNumeroDaConta(int numeroDaConta) {
        this.numeroDaConta = numeroDaConta;
    }

    public void setAgenciaBancaria(int agenciaBancaria) {
        this.agenciaBancaria = agenciaBancaria;
    }

    public void setSaldoDaConta(Double saldoDaConta) {
        this.saldoDaConta = saldoDaConta;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Long getStatusDaConta() {
        return statusDaConta;
    }

    public void setStatusDaConta(Long statusDaConta) {
        this.statusDaConta = statusDaConta;
    }

}

