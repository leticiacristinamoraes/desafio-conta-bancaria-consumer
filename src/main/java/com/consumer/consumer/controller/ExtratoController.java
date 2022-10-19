package com.consumer.consumer.controller;

import com.consumer.consumer.dtos.ExibicaoConsumerDTO;
import com.consumer.consumer.dtos.ExibicaoExtratoDTO;
import com.consumer.consumer.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/extratos")
public class ExtratoController {

    @Autowired
    private ConsumerService consumerService;

    @GetMapping("/{cpf}")
    public List<ExibicaoExtratoDTO> exibirExtratoId(@PathVariable String cpf) {
        ExibicaoConsumerDTO consumerCpf = consumerService.findByCpf(cpf);
        if (consumerCpf != null) {
          List<ExibicaoExtratoDTO> destinatario = consumerService.exibirExtratosDestinatario(consumerCpf.getId());
          return destinatario;
        } else {
            return null;
        }
    }

}
