package com.example.mscartoes.models;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.example.mscartoes.enums.BandeiraCartao;

import lombok.Data;

@Data
@Entity
@Table(name = "cartoes")
public class Cartao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Enumerated(EnumType.STRING)
    private BandeiraCartao bandeiraCartao;

    @Column(name = "renda")
    private BigDecimal renda;

    @Column(name = "limite_basico")
    private BigDecimal limiteBasico;

    @OneToMany(mappedBy = "cartao")
    private List<ClienteCartao> clienteCartao;
}
