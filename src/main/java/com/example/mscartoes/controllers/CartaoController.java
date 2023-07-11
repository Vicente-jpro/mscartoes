package com.example.mscartoes.controllers;

import java.util.List;

import javax.ws.rs.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mscartoes.models.Cartao;
import com.example.mscartoes.services.CartaoService;

@RestController
@RequestMapping("/cartoes")
public class CartaoController {

    @Autowired
    private CartaoService cartaoService;

    @PostMapping
    public Cartao salvar(@RequestBody Cartao cartao) {
        return this.cartaoService.salvar(cartao);
    }

    @GetMapping("/{bi}")
    public Cartao geCartao(@PathVariable("bi") String bi) {
        return this.cartaoService.geCartao(bi);
    }

    @GetMapping
    public List<Cartao> getCartoes() {
        return this.cartaoService.getCartoes();
    }

    @GetMapping("/{renda}")
    public List<Cartao> getCartoesRendaMenorOrIgual(@PathVariable("renda") Long renda) {

        return this.cartaoService.getCartoesRendaMenorOrIgual(renda);
    }
}
