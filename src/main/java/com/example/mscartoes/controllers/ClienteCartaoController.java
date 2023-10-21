package com.example.mscartoes.controllers;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.mscartoes.converters.CartaoConverter;
import com.example.mscartoes.converters.ClienteCartaoConverter;
import com.example.mscartoes.dto.ClienteCartaoDto;
import com.example.mscartoes.models.Cartao;
import com.example.mscartoes.models.ClienteCartao;
import com.example.mscartoes.services.CartaoService;
import com.example.mscartoes.services.ClienteCartaoService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/cartoes/clientes")
public class ClienteCartaoController {

	@Autowired
	private ClienteCartaoService clienteService;

	@Autowired
	private ClienteCartaoConverter clienteCartaoConverter;

	@Autowired
	private CartaoConverter cartaoConverter;

	@Autowired
	private CartaoService cartaoService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ClienteCartaoDto salvar(@RequestBody ClienteCartaoDto clienteCartaoDto) {
		log.info("Buscar Cliente com os seus cartões.");

		Cartao cartao = cartaoConverter.toModel(clienteCartaoDto);
		cartao = this.cartaoService.salvar(cartao);

		ClienteCartao clienteCartao = clienteCartaoConverter.toModel(clienteCartaoDto);
		clienteCartao.setCartao(cartao);

		clienteCartao = this.clienteService.salvar(clienteCartao);
		return this.clienteCartaoConverter.toDto(clienteCartao);
	}

	@GetMapping
	// @ApiOperation("Listar todos clientes.")
	// @ApiResponse(code = 302, message = "Clientes encontrados com sucesso.")
	@ResponseStatus(HttpStatus.OK)
	public List<ClienteCartao> listarClientes() {
		log.info("Buscar clientes");
		return this.clienteService.listarClientes();
	}

	@GetMapping("/{id_cliente}")
	// @ApiOperation("Buscar cliente.")
	// @ApiResponse(code = 200, message = "Cliente encontrado com sucesso.")
	@ResponseStatus(HttpStatus.OK)
	public ClienteCartao getCliente(@PathVariable("id_cliente") Integer IdCliente) {
		log.info("Buscar cartoes do cliente pelo ID: {}", IdCliente);
		return this.clienteService.getCliente(IdCliente);
	}

	@GetMapping(params = "bi")
	@ResponseStatus(HttpStatus.OK)
	public List<ClienteCartaoDto> getCartaoClienteByBi(@RequestParam("bi") String bi) {
		log.info("Buscar cartoes do cliente pelo BI: " + bi);
		List<ClienteCartao> clienteCartao = this.clienteService.getClienteCartoesByBi(bi);
		List<ClienteCartaoDto> clienteCartaoDto = this.clienteCartaoConverter.toDto(clienteCartao);

		return clienteCartaoDto;
	}

	@DeleteMapping("/{id_cliente}")
	// @ApiOperation("Eliminar cliente.")
	// @ApiResponse(code = 200, message = "Cliente encontrado com sucesso.")
	@ResponseStatus(HttpStatus.OK)
	public void eliminar(@PathVariable("id_cliente") Integer IdCliente) {
		log.info("Eliminar clientes cartoes do cliente pelo BI: {}", IdCliente);
		this.clienteService.eliminar(IdCliente);
	}

	@GetMapping(params = "renda")
	public List<Cartao> getCartoesRendaMenorOrIgual(@RequestParam("renda") Long renda) {
		log.info("bustar cartão com renda: ");
		return this.cartaoService.getCartoesRendaMenorOrIgual(renda);
	}

}
