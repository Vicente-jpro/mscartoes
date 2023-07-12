package com.example.mscartoes.dto;

import java.math.BigDecimal;

import com.example.mscartoes.models.Cartao;
import com.example.mscartoes.models.ClienteCartao;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClienteCartaoRequest {

    private Integer id;
    private String bi;
    private CartaoRequest cartao;
    private BigDecimal limite;

    private BigDecimal renda;
    private BigDecimal limiteBasico;

    public ClienteCartao toModel() {
        ClienteCartao clienteCartao = new ClienteCartao();
        clienteCartao.setId(id);
        clienteCartao.setBi(bi);
        clienteCartao.setLimite(limite);

        Cartao cartao = new Cartao();
        cartao.setId(cartao.getId());
        cartao.setBandeiraCartao(cartao.getBandeiraCartao());
        cartao.setRenda(renda);
        cartao.setLimiteBasico(limiteBasico);

        clienteCartao.setCartao(cartao);

        return clienteCartao;
    }
}
