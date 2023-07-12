package com.example.mscartoes.models;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "cliente_cartao")
public class ClienteCartao {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;

	@Column(name = "bi")
	private String bi;

	@ManyToOne
	@JoinColumn(name = "cartao_id")
	private Cartao cartao;

	@Column(name = "limite")
	private BigDecimal limite;

}
