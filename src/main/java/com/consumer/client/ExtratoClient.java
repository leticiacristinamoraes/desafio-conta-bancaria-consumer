package com.consumer.client;

import com.consumer.consumer.dtos.ExtratoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(url = "http://localhost:8080", name = "extratos")
public interface ExtratoClient {

    @RequestMapping(method = RequestMethod.POST, value = "/extratos")
    public ExtratoDTO save(@RequestBody ExtratoDTO extratoDTO);

    @RequestMapping(method = RequestMethod.GET, value = "/extratos/{idDestinatario}")
    public List<ExtratoDTO> mostrarExtratosDestinatario(@PathVariable Long idDestinatario);

}
