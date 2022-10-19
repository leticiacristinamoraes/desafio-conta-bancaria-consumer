package com.consumer.consumer.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TransferenciaDTO {
    @JsonProperty("nome_do_remetente")
    private String nomeDoRemetente;
    @JsonProperty("cpf_remetente")
    private String cpfRemetente;
    @JsonProperty("agencia_de_deposito")
    private String agenciaDeDeposito;
    @JsonProperty("numero_da_conta_de_deposito")
    private String numeroDaContaDeDeposito;
    @JsonProperty("cpf_destinatario")
    private String cpfDestinatario;
    @JsonProperty("valor_deposito")
    private Double valorDeposito;
    @JsonProperty("tipo_transferencia")
    private Integer tipoTransferencia;


    public TransferenciaDTO() {
    }

    public TransferenciaDTO(String nomeDoRemetente, String cpfRemetente, String agenciaDeDeposito,
                            String numeroDaContaDeDeposito, String cpfDestinatario, Double valorDeposito,
                            Integer tipoTransferencia) {
        this.nomeDoRemetente = nomeDoRemetente;
        this.cpfRemetente = cpfRemetente;
        this.agenciaDeDeposito = agenciaDeDeposito;
        this.numeroDaContaDeDeposito = numeroDaContaDeDeposito;
        this.cpfDestinatario = cpfDestinatario;
        this.valorDeposito = valorDeposito;
        this.tipoTransferencia = tipoTransferencia;
    }

    public String getNomeDoRemetente() {
        return nomeDoRemetente;
    }

    public String getAgenciaDeDeposito() {
        return agenciaDeDeposito;
    }

    public String getNumeroDaContaDeDeposito() {
        return numeroDaContaDeDeposito;
    }

    public Double getValorDeposito() {
        return valorDeposito;
    }

    public Integer getTipoTransferencia() {
        return tipoTransferencia;
    }

    public String getCpfRemetente() {
        return cpfRemetente;
    }

    public String getCpfDestinatario() {
        return cpfDestinatario;
    }

}
