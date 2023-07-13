package com.example.mscartoes.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.mscartoes.dto.ClienteCartaoDto;
import com.example.mscartoes.models.Cartao;
import com.example.mscartoes.models.ClienteCartao;

@Component
public class ClienteCartaoConverter {

    @Autowired
    private CartaoConverter cartaoConverter;

    public ClienteCartao toModel(ClienteCartaoDto clienteCartaoDto) {
        ClienteCartao clienteCartao = new ClienteCartao();
        clienteCartao.setId(clienteCartaoDto.getId());
        clienteCartao.setBi(clienteCartaoDto.getBi());
        clienteCartao.setLimite(clienteCartaoDto.getLimite());

        Cartao cartao = cartaoConverter.toModel(clienteCartaoDto.getCartao());
        clienteCartao.setCartao(cartao);

        return clienteCartao;
    }

    public ClienteCartaoDto toDto(ClienteCartao clienteCartao) {

        return ClienteCartaoDto
                .builder()
                .id(clienteCartao.getId())
                .bi(clienteCartao.getBi())
                .limite(clienteCartao.getLimite())
                .cartao(cartaoConverter.toDto(clienteCartao.getCartao()))
                .build();

    }

}
