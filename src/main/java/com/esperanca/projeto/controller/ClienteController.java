package com.esperanca.projeto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.esperanca.projeto.dto.RequisicaoNovoFormulario;
import com.esperanca.projeto.model.Cliente;
import com.esperanca.projeto.repository.ClienteRepository;

@Controller
@RequestMapping("cliente")
public class ClienteController {

	@Autowired
	private ClienteRepository clienteRepository;

	@GetMapping("formulario")
	public String formulario() {
		return "formulario";
	}

	@PostMapping("novo")
	public String novo(RequisicaoNovoFormulario requisicao) {
		Cliente cliente = requisicao.toPedido();
		clienteRepository.save(cliente);

		return "cliente/formulario";
	}

}