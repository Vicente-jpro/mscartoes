package com.example.mscartoes.controllers;

import java.net.URI;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.mscartoes.dto.ClienteCartaoRequest;
import com.example.mscartoes.models.ClienteCartao;
import com.example.mscartoes.services.ClienteCartaoService;

@RestController
@RequestMapping("/clientes-cartao")
// @CrossOrigin("http://localhost:4200")
public class ClienteCartaoController {

	private final Logger logger = Logger.getLogger(ClienteCartaoController.class.getName());
	@Autowired
	private ClienteCartaoService clienteService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity salvar(@RequestBody ClienteCartaoRequest request) {
		ClienteCartao clienteCartao = request.toModel();
		ClienteCartao clt = this.clienteService.salvar(clienteCartao);

		// Usado para apresentar rotas dinamicas.
		// EX: http://localhost:8080/clientes?bi=12345LA049
		URI headerLocation = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.query("bi={bi}")
				.buildAndExpand(clt.getBi())
				.toUri();
		return ResponseEntity.created(headerLocation).build();
	}

	@GetMapping
	// @ApiOperation("Listar todos clientes.")
	// @ApiResponse(code = 302, message = "Clientes encontrados com sucesso.")
	@ResponseStatus(HttpStatus.OK)
	public List<ClienteCartao> listarClientes() {
		logger.info("***Buscando clientes***");
		return this.clienteService.listarClientes();
	}

	@GetMapping("/{id_cliente}")
	// @ApiOperation("Buscar cliente.")
	// @ApiResponse(code = 200, message = "Cliente encontrado com sucesso.")
	@ResponseStatus(HttpStatus.OK)
	public ClienteCartao getCliente(@PathVariable("id_cliente") Integer IdCliente) {

		return this.clienteService.getCliente(IdCliente);
	}

	@GetMapping(params = "bi")
	@ResponseStatus(HttpStatus.OK)
	public ClienteCartao getCliente(@RequestParam("bi") String bi) {
		logger.info("Listar cliente por BI: " + bi);
		return this.clienteService.findByBi(bi);
	}

	@DeleteMapping("/{id_cliente}")
	// @ApiOperation("Eliminar cliente.")
	// @ApiResponse(code = 200, message = "Cliente encontrado com sucesso.")
	@ResponseStatus(HttpStatus.OK)
	public void eliminar(@PathVariable("id_cliente") Integer IdCliente) {
		this.clienteService.eliminar(IdCliente);
	}

}
