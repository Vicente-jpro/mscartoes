package com.example.mscartoes.infra.queues;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.example.mscartoes.models.Cartao;
import com.example.mscartoes.models.ClienteCartao;
import com.example.mscartoes.models.DadosSolicitacaoEmissaoCartao;
import com.example.mscartoes.repositories.CartaoRepository;
import com.example.mscartoes.services.CartaoService;
import com.example.mscartoes.services.ClienteCartaoService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class EmissaoCartaoSubscriber {

    private final CartaoService cartaoService;
    private final ClienteCartaoService clienteCartaoService;

    @RabbitListener(queues = "${mq.queues.emissao-cartoes}")
    public void solicitar(@Payload String payload) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            // Descerialização dos dados
            DadosSolicitacaoEmissaoCartao dados = mapper.readValue(payload, DadosSolicitacaoEmissaoCartao.class);
            Cartao cartao = cartaoService.getCartaoById(dados.getIdCartao());

            ClienteCartao clienteCartao = new ClienteCartao();
            clienteCartao.setCartao(cartao);
            clienteCartao.setBi(dados.getBi());
            clienteCartao.setLimite(dados.getLimiteLiberado());

            clienteCartaoService.salvar(clienteCartao);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
