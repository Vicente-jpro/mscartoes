package com.example.mscartoes.controllers;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.mscartoes.dto.CartaoRequest;
import com.example.mscartoes.models.Cartao;
import com.example.mscartoes.services.CartaoService;

@RestController
@RequestMapping("/cartoes")
public class CartaoController {
    private final Logger logger = Logger.getLogger(CartaoController.class.getName());
    @Autowired
    private CartaoService cartaoService;

    @PostMapping
    public Cartao salvar(@RequestBody CartaoRequest cartaoRequest) {
        logger.info("Salavar cartao");
        Cartao cartao = cartaoRequest.toModel();

        return this.cartaoService.salvar(cartao);
    }

    @GetMapping("/{bi}")
    public Cartao geCartao(@PathVariable("bi") String bi) {
        logger.info("Buscar cartão pelo BI");
        return this.cartaoService.geCartao(bi);
    }

    @GetMapping
    public List<Cartao> getCartoes() {
        logger.info("Listar todos os cartoes.");
        return this.cartaoService.getCartoes();
    }

    @GetMapping(params = "renda")
    public List<Cartao> getCartoesRendaMenorOrIgual(@RequestParam("renda") Long renda) {
        logger.info("bustar cartão com renda: ");
        return this.cartaoService.getCartoesRendaMenorOrIgual(renda);
    }
}
