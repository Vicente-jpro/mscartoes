package com.example.mscartoes.dto;

import java.math.BigDecimal;

import com.example.mscartoes.enums.BandeiraCartao;
import com.example.mscartoes.models.Cartao;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CartaoDto {

    private Long id;
    private String nome;
    private BandeiraCartao bandeiraCartao;
    private BigDecimal renda;
    private BigDecimal limiteBasico;

}
