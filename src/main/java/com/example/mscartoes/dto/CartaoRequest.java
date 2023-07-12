package com.example.mscartoes.dto;

import java.math.BigDecimal;

import com.example.mscartoes.enums.BandeiraCartao;
import com.example.mscartoes.models.Cartao;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CartaoRequest {

    private Long id;
    private String nome;
    private BandeiraCartao bandeiraCartao;
    private BigDecimal renda;
    private BigDecimal limiteBasico;

    public Cartao toModel() {
        Cartao cartao = new Cartao();
        cartao.setId(id);
        cartao.setBandeiraCartao(bandeiraCartao);
        cartao.setNome(nome);
        cartao.setRenda(renda);
        cartao.setLimiteBasico(limiteBasico);
        return cartao;
    }
}
