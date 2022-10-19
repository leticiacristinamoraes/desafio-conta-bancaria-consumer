package com.consumer.consumer.controller;

import com.consumer.consumer.dtos.ExibicaoConsumerDTO;
import com.consumer.consumer.dtos.TransferenciaDTO;
import com.consumer.consumer.service.impl.ConsumerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consumer")
public class ConsumerController {
    @Autowired
    private ConsumerServiceImpl consumerService;

    @GetMapping
    public List<ExibicaoConsumerDTO> mostrarConsumers() {
        List<ExibicaoConsumerDTO> list = consumerService.findAll();
        return list;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ExibicaoConsumerDTO cadastrarConsumer(@RequestBody ExibicaoConsumerDTO exibicaoConsumerDTO) {
        return consumerService.salvarConsumer(exibicaoConsumerDTO);
    }

    @GetMapping("/{id}")
    public ExibicaoConsumerDTO exibirConsumerId(@PathVariable Long id) {
        ExibicaoConsumerDTO consumer = consumerService.findById(id);
        return consumer;
    }

    @GetMapping("/cpf/{cpf}")
    public ExibicaoConsumerDTO exibirConsumerCPF(@PathVariable String cpf) {
        ExibicaoConsumerDTO consumerCpf = consumerService.findByCpf(cpf);
        return consumerCpf;
    }

    @PostMapping("/transferencia")
    public String transferirRecurso(@RequestBody TransferenciaDTO transferenciaDTO) {
        ExibicaoConsumerDTO destinatario = consumerService.findByCpf(transferenciaDTO.getCpfDestinatario());
        if (destinatario != null) {
            if (transferenciaDTO.getTipoTransferencia() == 1) {
                ExibicaoConsumerDTO remetente = consumerService.findByCpf(transferenciaDTO.getCpfRemetente());
                if (remetente != null) {
                    if (remetente.getSaldoDaConta() >= transferenciaDTO.getValorDeposito()) {
                        consumerService.updateTransferencia(transferenciaDTO, remetente, destinatario);
                        return ("transferencia feita com sucesso1");
                    } else {
                        return ("Saldo insuficiente para transferencia!");
                    }
                } else {
                    return ("Remetente inexistente!");
                }
            } else if (transferenciaDTO.getTipoTransferencia() == 2) {
                consumerService.deposito(transferenciaDTO, destinatario);
                return ("Deposito efetuado com sucesso!");
            } else {
                return ("informe uma operação válida: trasnferencia ou depósito.");
            }

        } else {
            return ("Destinario não encontrado.");
        }

    }

    @GetMapping("/deletar/{cpf}")
    public String deleteClient(@PathVariable String cpf) {
        ExibicaoConsumerDTO consumerCpf = consumerService.findByCpf(cpf);
        if (consumerCpf != null){
           if (consumerCpf.getSaldoDaConta() == 0) {
               Boolean user = consumerService.inativarUser(consumerCpf.getId());
               if (user){
                   return ("Conta inativada com sucesso!");
               } else {
                   return ("A conta não pode ser inativada!");
               }
           } else{
               return ("Para deletar a conta é necessário zerar o saldo");
           }
        } else{
            return ("Cliente não encontrado.");
        }

    }

}

