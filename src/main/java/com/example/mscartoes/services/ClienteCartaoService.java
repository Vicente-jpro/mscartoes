package com.example.mscartoes.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mscartoes.exceptions.ClienteCartaoNotFoundException;
import com.example.mscartoes.models.ClienteCartao;
import com.example.mscartoes.repositories.ClienteCartaoRepository;

@Service
public class ClienteCartaoService {

	@Autowired
	private ClienteCartaoRepository clienteRepository;

	public ClienteCartao salvar(ClienteCartao cliente) {
		return this.clienteRepository.save(cliente);
	}

	public ClienteCartao getCliente(Integer idCliente) {
		return this.clienteRepository
				.findById(idCliente)
				.orElseThrow(
						() -> new ClienteCartaoNotFoundException("Cliente não encontrado. Id invalido :" + idCliente));
	}

	public ClienteCartao findByBi(String bi) {
		return this.clienteRepository.findByBi(bi);
	}

	public void eliminar(Integer idCliente) {
		ClienteCartao cliente = this.getCliente(idCliente);
		this.clienteRepository.delete(cliente);
	}

	public List<ClienteCartao> listarClientes() {
		return this.clienteRepository.findAll();
	}
}
