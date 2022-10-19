package com.consumer.consumer.service;

import com.consumer.consumer.dtos.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ConsumerService {
    public ExibicaoConsumerDTO salvarConsumer(ExibicaoConsumerDTO exibicaoConsumerDTO);

    public List<ExibicaoConsumerDTO> findAll();

    public ExibicaoConsumerDTO findById(Long id);

    public ExibicaoConsumerDTO findByCpf(String cpf);

    public String updateTransferencia(TransferenciaDTO transferenciaDTO, ExibicaoConsumerDTO remetente, ExibicaoConsumerDTO destinatario);

    public String deposito(TransferenciaDTO transferenciaDTO, ExibicaoConsumerDTO destinatario);

    public List<ExibicaoExtratoDTO> exibirExtratosDestinatario(Long idDestinatario);

    public Boolean inativarUser(Long id);
}
