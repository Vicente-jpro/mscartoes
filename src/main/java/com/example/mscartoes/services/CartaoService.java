package com.example.mscartoes.services;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mscartoes.models.Cartao;
import com.example.mscartoes.repositories.CartaoRepository;

@Service
public class CartaoService {

    @Autowired
    private CartaoRepository cartaoRepository;

    public Cartao salvar(Cartao cartao) {

        return this.cartaoRepository.save(cartao);
    }

    public Cartao geCartao(String bi) {
        return this.cartaoRepository.findAll().get(0);
    }

    public List<Cartao> getCartoesRendaMenorOrIgual(Long renda) {
        BigDecimal valorRenda = BigDecimal.valueOf(renda);
        return this.cartaoRepository.findByRendaLessThanEqual(valorRenda);
    }

    public List<Cartao> getCartoes() {
        return this.cartaoRepository.findAll();
    }
}
