package com.example.mscartoes.services;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mscartoes.exceptions.CartaoNotFoundException;
import com.example.mscartoes.models.Cartao;
import com.example.mscartoes.repositories.CartaoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CartaoService {

    private final CartaoRepository cartaoRepository;

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
        return this.cartaoRepository.findById(idCartao.intValue()).orElseThrow(
                () -> new CartaoNotFoundException(
                        "Cartão não encontrado. Id invalido: " + idCartao));
    }
}
