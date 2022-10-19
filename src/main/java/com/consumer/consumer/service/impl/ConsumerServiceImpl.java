package com.consumer.consumer.service.impl;

import com.consumer.client.ContaBancariaClient;
import com.consumer.client.ExtratoClient;
import com.consumer.consumer.dtos.ExibicaoConsumerDTO;
import com.consumer.consumer.dtos.ExibicaoExtratoDTO;
import com.consumer.consumer.dtos.ExtratoDTO;
import com.consumer.consumer.dtos.TransferenciaDTO;
import com.consumer.consumer.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class ConsumerServiceImpl implements ConsumerService {

    @Autowired
    private ContaBancariaClient contaBancariaClient;
    @Autowired
    private ExtratoClient extratoClient;

    @Override
    public ExibicaoConsumerDTO salvarConsumer(ExibicaoConsumerDTO exibicaoConsumerDTO) {

        try {
            exibicaoConsumerDTO = contaBancariaClient.save(exibicaoConsumerDTO);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return exibicaoConsumerDTO;
//        ConsumerEntity consumerEntity = convertDTOparaEntity(consumerDTO);
//        consumerRepository.saveAndFlush(consumerEntity);
    }

    @Override
    public List<ExibicaoConsumerDTO> findAll() {
        List<ExibicaoConsumerDTO> consumerDTOS = null;
        try {
            consumerDTOS = contaBancariaClient.findAll();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return consumerDTOS;
    }

    @Override
    public ExibicaoConsumerDTO findById(Long id) {
        ExibicaoConsumerDTO exibicaoConsumerDTO = null;
        try {
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<String> request = new HttpEntity<String>(headers);
            ResponseEntity<ExibicaoConsumerDTO> response = restTemplate.exchange(("http://localhost:8080/contas/" + id),
                    HttpMethod.GET, request, ExibicaoConsumerDTO.class);

            exibicaoConsumerDTO = response.getBody();

        } catch (Exception e) {
            System.out.print(e.getMessage());
        }

        return exibicaoConsumerDTO;
    }

    @Override
    public ExibicaoConsumerDTO findByCpf(String cpf) {
        ExibicaoConsumerDTO exibicaoConsumerDTO = null;
        try {
            exibicaoConsumerDTO = contaBancariaClient.findByCpf(cpf);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return exibicaoConsumerDTO;
    }

    @Override
    public String updateTransferencia(TransferenciaDTO transferenciaDTO, ExibicaoConsumerDTO remetente,
                                      ExibicaoConsumerDTO destinatario) {
        remetente.setSaldoDaConta((remetente.getSaldoDaConta()) - transferenciaDTO.getValorDeposito());
        destinatario.setSaldoDaConta((destinatario.getSaldoDaConta()) + transferenciaDTO.getValorDeposito());

        try {
            contaBancariaClient.atualizarSaldo(remetente);
            extratoClient.save(new ExtratoDTO(destinatario, remetente, 1L,
                    (transferenciaDTO.getValorDeposito() * -1), LocalDateTime.now()));

            contaBancariaClient.atualizarSaldo(destinatario);
            extratoClient.save(new ExtratoDTO(remetente, destinatario, 1L,
                    transferenciaDTO.getValorDeposito(), LocalDateTime.now()));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ("A transferencia não pôde ser efetuada, tente novamente!");
        }

        return ("Transferencia efetuada com sucesso!");
    }

    @Override
    public String deposito(TransferenciaDTO transferenciaDTO, ExibicaoConsumerDTO destinatario) {
        destinatario.setSaldoDaConta((destinatario.getSaldoDaConta()) + transferenciaDTO.getValorDeposito());
        try {
            contaBancariaClient.atualizarSaldo(destinatario);
            extratoClient.save(new ExtratoDTO(null, destinatario, 2L,
                    transferenciaDTO.getValorDeposito(), LocalDateTime.now()));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ("O depósito não foi efetuado");
        }
        return null;
    }

    @Override
    public  List<ExibicaoExtratoDTO> exibirExtratosDestinatario(Long idDestinatario) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        List<ExtratoDTO> list = extratoClient.mostrarExtratosDestinatario(idDestinatario);
        List<ExibicaoExtratoDTO> extratos = new ArrayList<>();
        for (ExtratoDTO extrato : list) {
            ExibicaoExtratoDTO exibicao = new ExibicaoExtratoDTO();
            exibicao.setDataDaAcao(extrato.getDataTransferencia().format(formatter));
            exibicao.setRemetente(extrato.getRemetente() != null ? extrato.getRemetente().getTitularDaConta() : null);
            exibicao.setNomeDocCliente(extrato.getDestinatario().getTitularDaConta());
            exibicao.setSaldoTotal("R$ " + NumberFormat.getCurrencyInstance().format(extrato.getDestinatario().getSaldoDaConta()));
            String acao = (extrato.getTipoAcao() == 1 ? "transferência" : "deposito");
            exibicao.setTipoAcao(acao);
            exibicao.setValorTransferencia("R$ " + NumberFormat.getCurrencyInstance().format(extrato.getValorTransferencia()));
            exibicao.setCpfCliente(extrato.getDestinatario().getCpf());

            extratos.add(exibicao);
        }
        return extratos;
    }

    public Boolean inativarUser(Long id) {
       Boolean user = contaBancariaClient.inativarUser(id);
        return user;
    }

}

