package com.example.mscartoes.controllers;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mscartoes.converters.CartaoConverter;
import com.example.mscartoes.dto.CartaoDto;
import com.example.mscartoes.models.Cartao;
import com.example.mscartoes.services.CartaoService;

@RestController
@RequestMapping("/cartoes")
public class CartaoController {
    private final Logger logger = Logger.getLogger(CartaoController.class.getName());

    @Autowired
    private CartaoService cartaoService;

    @Autowired
    private CartaoConverter cartaoConverter;

    @PostMapping
    public Cartao salvar(@RequestBody CartaoDto cartaoDto) {
        logger.info("Salavar cartao");
        Cartao cartao = cartaoConverter.toModel(cartaoDto);
        return this.cartaoService.salvar(cartao);
    }

    @GetMapping("/{bi}")
    public Cartao geCartao(@PathVariable("bi") String bi) {
        logger.info("Buscar cartão pelo BI");
        return this.cartaoService.getCartao(bi);
    }

    @GetMapping
    public List<Cartao> getCartoes() {
        logger.info("Listar todos os cartoes.");
        return this.cartaoService.getCartoes();
    }

}
