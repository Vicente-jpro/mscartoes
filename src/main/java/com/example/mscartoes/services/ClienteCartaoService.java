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
	private ClienteCartaoRepository clienteCartaoRepository;

	public ClienteCartao salvar(ClienteCartao cliente) {
		return this.clienteCartaoRepository.save(cliente);
	}

	public ClienteCartao getCliente(Integer idCliente) {
		return this.clienteCartaoRepository
				.findById(idCliente)
				.orElseThrow(
						() -> new ClienteCartaoNotFoundException("Cliente não encontrado. Id invalido :" + idCliente));
	}

	public List<ClienteCartao> getClienteCartoesByBi(String bi) {
		return this.clienteCartaoRepository.findAllByBi(bi);
	}

	public void eliminar(Integer idCliente) {
		ClienteCartao cliente = this.getCliente(idCliente);
		this.clienteCartaoRepository.delete(cliente);
	}

	public List<ClienteCartao> listarClientes() {
		return this.clienteCartaoRepository.findAll();
	}
}
