package com.example.mscartoes.dto;

import java.math.BigDecimal;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClienteCartaoDto {

    private Integer id;
    private String bi;
    private CartaoDto cartao;
    private BigDecimal limite;

}
