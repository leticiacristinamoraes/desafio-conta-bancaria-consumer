package com.consumer.consumer.dtos;

import java.time.LocalDateTime;

public class ExtratoDTO {
    private ExibicaoConsumerDTO remetente;
    private ExibicaoConsumerDTO destinatario;
    private Long tipoAcao;
    private Double valorTransferencia;
    private LocalDateTime dataTransferencia;

    public ExtratoDTO() {
    }

    public ExtratoDTO(ExibicaoConsumerDTO remetente, ExibicaoConsumerDTO destinatario,
                      Long tipoAcao, Double valorTransferencia, LocalDateTime dataTransferencia) {
        this.remetente = remetente;
        this.destinatario = destinatario;
        this.tipoAcao = tipoAcao;
        this.valorTransferencia = valorTransferencia;
        this.dataTransferencia = dataTransferencia;
    }

    public ExibicaoConsumerDTO getRemetente() {
        return remetente;
    }

    public void setRemetente(ExibicaoConsumerDTO remetente) {
        this.remetente = remetente;
    }

    public ExibicaoConsumerDTO getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(ExibicaoConsumerDTO destinatario) {
        this.destinatario = destinatario;
    }

    public Long getTipoAcao() {
        return tipoAcao;
    }

    public void setTipoAcao(Long tipoAcao) {
        this.tipoAcao = tipoAcao;
    }

    public Double getValorTransferencia() {
        return valorTransferencia;
    }

    public void setValorTransferencia(Double valorTransferencia) {
        this.valorTransferencia = valorTransferencia;
    }

    public LocalDateTime getDataTransferencia() {
        return dataTransferencia;
    }

    public void setDataTransferencia(LocalDateTime dataTransferencia) {
        this.dataTransferencia = dataTransferencia;
    }

}
