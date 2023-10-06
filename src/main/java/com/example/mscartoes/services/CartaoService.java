package com.example.mscartoes.services;

import java.math.BigDecimal;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import com.example.mscartoes.controllers.CartaoController;
import com.example.mscartoes.exceptions.CartaoNotFoundException;
import com.example.mscartoes.models.Cartao;
import com.example.mscartoes.repositories.CartaoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CartaoService {

    private final CartaoRepository cartaoRepository;
    private final Logger logger = Logger.getLogger(CartaoController.class.getName());

    public Cartao salvar(Cartao cartao) {

        return this.cartaoRepository.save(cartao);
    }

    public Cartao getCartao(String bi) {
        return this.cartaoRepository.findAll().get(0);
    }

    public List<Cartao> getCartoesRendaMenorOrIgual(Long renda) {
        BigDecimal valorRenda = BigDecimal.valueOf(renda);
        return this.cartaoRepository.findByRendaLessThanEqual(valorRenda);
    }

    public List<Cartao> getCartoes() {
        return this.cartaoRepository.findAll();
    }

    public Cartao getCartaoById(Long idCartao) {
        logger.info("Buscando cartão com id: " + idCartao);
        return this.cartaoRepository.findById(idCartao.intValue()).orElseThrow(
                () -> new CartaoNotFoundException(
                        "Cartão não encontrado. Id invalido: " + idCartao));
    }
}
