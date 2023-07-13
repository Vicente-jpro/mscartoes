package com.example.mscartoes.converters;

import org.springframework.stereotype.Component;

import com.example.mscartoes.dto.CartaoDto;
import com.example.mscartoes.dto.ClienteCartaoDto;
import com.example.mscartoes.models.Cartao;

@Component
public class CartaoConverter {

    public Cartao toModel(CartaoDto cartaoDto) {
        Cartao cartao = new Cartao();
        cartao.setId(cartaoDto.getId());
        cartao.setBandeiraCartao(cartaoDto.getBandeiraCartao());
        cartao.setNome(cartaoDto.getNome());
        cartao.setRenda(cartaoDto.getRenda());
        cartao.setLimiteBasico(cartaoDto.getLimiteBasico());
        return cartao;
    }

    public Cartao toModel(ClienteCartaoDto clienteCartaoDto) {
        Cartao cartao = new Cartao();
        cartao.setId(clienteCartaoDto.getCartao().getId());
        cartao.setBandeiraCartao(clienteCartaoDto.getCartao().getBandeiraCartao());
        cartao.setNome(clienteCartaoDto.getCartao().getNome());
        cartao.setRenda(clienteCartaoDto.getCartao().getRenda());
        cartao.setLimiteBasico(clienteCartaoDto.getCartao().getLimiteBasico());
        return cartao;
    }

    public CartaoDto toDto(Cartao cartao) {
        return CartaoDto.builder()
                .id(cartao.getId())
                .nome(cartao.getNome())
                .bandeiraCartao(cartao.getBandeiraCartao())
                .limiteBasico(cartao.getLimiteBasico())
                .renda(cartao.getRenda())
                .build();
    }
}
