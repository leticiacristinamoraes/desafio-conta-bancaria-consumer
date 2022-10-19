package com.consumer.client;

import com.consumer.consumer.dtos.ExibicaoConsumerDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(url = "http://localhost:8080", name = "contas")
public interface ContaBancariaClient {

    @RequestMapping(method = RequestMethod.POST, value = "/contas")
    public ExibicaoConsumerDTO save(@RequestBody ExibicaoConsumerDTO exibicaoConsumerDTO);

    @RequestMapping(method = RequestMethod.GET, value = "/contas")
    public List<ExibicaoConsumerDTO> findAll();

    @RequestMapping(method = RequestMethod.GET, value = "/contas/transferencia/{cpf}")
    public ExibicaoConsumerDTO findByCpf(@PathVariable String cpf);

    @RequestMapping(method = RequestMethod.POST, value = "/contas/update")
    public ExibicaoConsumerDTO atualizarSaldo(@RequestBody ExibicaoConsumerDTO exibicaoConsumerDTO);

    @RequestMapping(method = RequestMethod.GET, value = "/contas/delete/{id}")
    public Boolean inativarUser(@PathVariable Long id);

}
