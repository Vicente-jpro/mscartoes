package com.example.mscartoes.controllers;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.mscartoes.converters.CartaoConverter;
import com.example.mscartoes.dto.CartaoDto;
import com.example.mscartoes.models.Cartao;
import com.example.mscartoes.services.CartaoService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/cartoes")
public class CartaoController {

    @Autowired
    private CartaoService cartaoService;

    @Autowired
    private CartaoConverter cartaoConverter;

    @PostMapping
    public Cartao salvar(@RequestBody CartaoDto cartaoDto) {
        log.info("Salavar cartao");
        Cartao cartao = cartaoConverter.toModel(cartaoDto);
        return this.cartaoService.salvar(cartao);
    }

    @GetMapping
    public List<Cartao> getCartoes() {
        log.info("Listar todos os cartoes.");
        return this.cartaoService.getCartoes();
    }

    @GetMapping("/{id}")
    public Cartao getCartaoById(@RequestParam("id") Long idCartao) {
        log.info("Buscar cartão com id: " + idCartao);
        return this.cartaoService.getCartaoById(idCartao);
    }

}
