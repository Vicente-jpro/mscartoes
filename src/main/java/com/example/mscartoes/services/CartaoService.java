package com.example.mscartoes.services;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.mscartoes.exceptions.CartaoNotFoundException;
import com.example.mscartoes.models.Cartao;
import com.example.mscartoes.repositories.CartaoRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class CartaoService {

    private final CartaoRepository cartaoRepository;
    public Cartao salvar(Cartao cartao) {

        return this.cartaoRepository.save(cartao);
    }

    public List<Cartao> getCartoesRendaMenorOrIgual(Long renda) {
        BigDecimal valorRenda = BigDecimal.valueOf(renda);
        return this.cartaoRepository.findByRendaLessThanEqual(valorRenda);
    }

    public List<Cartao> getCartoes() {
        return this.cartaoRepository.findAll();
    }

    public Cartao getCartaoById(Long idCartao) {
        log.info("Buscando cartão com id: " + idCartao);
        return this.cartaoRepository.findById(idCartao.intValue()).orElseThrow(
                () -> new CartaoNotFoundException(
                        "Cartão não encontrado. Id invalido: " + idCartao));
    }
}
