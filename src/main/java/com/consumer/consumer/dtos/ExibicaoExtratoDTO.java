package com.consumer.consumer.dtos;

public class ExibicaoExtratoDTO {
    private String nomeDocCliente;
    private String tipoAcao;
    private String saldoTotal;
    private String remetente;
    private String valorTransferencia;
    private String dataDaAcao;
    private String cpfCliente;

    public ExibicaoExtratoDTO() {
    }

    public ExibicaoExtratoDTO(String nomeDocCliente, String tipoAcao, String saldoTotal, String remetente,
                              String valorTransferencia, String dataDaAcao, String cpfCliente) {
        this.nomeDocCliente = nomeDocCliente;
        this.tipoAcao = tipoAcao;
        this.saldoTotal = saldoTotal;
        this.remetente = remetente;
        this.valorTransferencia = valorTransferencia;
        this.dataDaAcao = dataDaAcao;
        this.cpfCliente = cpfCliente;
    }

    public String getNomeDocCliente() {
        return nomeDocCliente;
    }

    public void setNomeDocCliente(String nomeDocCliente) {
        this.nomeDocCliente = nomeDocCliente;
    }

    public String getTipoAcao() {
        return tipoAcao;
    }

    public void setTipoAcao(String tipoAcao) {
        this.tipoAcao = tipoAcao;
    }

    public String getSaldoTotal() {
        return saldoTotal;
    }

    public void setSaldoTotal(String saldoTotal) {
        this.saldoTotal = saldoTotal;
    }

    public String getRemetente() {
        return remetente;
    }

    public void setRemetente(String remetente) {
        this.remetente = remetente;
    }

    public String getValorTransferencia() {
        return valorTransferencia;
    }

    public void setValorTransferencia(String valorTransferencia) {
        this.valorTransferencia = valorTransferencia;
    }

    public String getDataDaAcao() {
        return dataDaAcao;
    }

    public void setDataDaAcao(String dataDaAcao) {
        this.dataDaAcao = dataDaAcao;
    }

    public String getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }

}
