package com.esperanca.projeto.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.esperanca.projeto.model.Cliente;
import com.esperanca.projeto.repository.ClienteRepository;

@Controller
public class QuestionarioController {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
	private ClienteRepository clienteRepository;	
	
	@GetMapping("/questionario")
	public String Questionario(Model model) {
		List<Cliente> cliente = clienteRepository.findAll();
		model.addAllAttributes(cliente);
		return "questionario";
		
	}
	
	
}
