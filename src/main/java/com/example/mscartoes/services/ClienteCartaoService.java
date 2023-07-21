package com.example.mscartoes.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mscartoes.exceptions.ClienteCartaoNotFoundException;
import com.example.mscartoes.models.ClienteCartao;
import com.example.mscartoes.repositories.ClienteCartaoRepository;

@Service
public class ClienteCartaoService {

	@Autowired
	private ClienteCartaoRepository clienteCartaoRepository;
	private final Logger logger = Logger.getLogger(ClienteCartao.class.getName());

	public ClienteCartao salvar(ClienteCartao cliente) {
		logger.info("Salvando cliente com o seu cartão.");
		return this.clienteCartaoRepository.save(cliente);
	}

	public ClienteCartao getCliente(Integer idCliente) {
		logger.info("Buscando clientes com o seu cartão.");
		return this.clienteCartaoRepository
				.findById(idCliente)
				.orElseThrow(
						() -> new ClienteCartaoNotFoundException("Cliente não encontrado. Id invalido :" + idCliente));
	}

	public List<ClienteCartao> getClienteCartoesByBi(String bi) {
		logger.info("Listando cliente com os seus cartões pelo BI:" + bi);
		return this.clienteCartaoRepository.findAllByBi(bi);
	}

	public void eliminar(Integer idCliente) {
		logger.info("Eliminando cliente com o seu cartão.");
		ClienteCartao cliente = this.getCliente(idCliente);
		this.clienteCartaoRepository.delete(cliente);
	}

	public List<ClienteCartao> listarClientes() {
		logger.info("Buscando cliente com o seu cartão.");
		return this.clienteCartaoRepository.findAll();
	}
}
