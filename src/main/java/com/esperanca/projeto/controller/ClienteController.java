package com.esperanca.projeto.controller;


import com.esperanca.projeto.model.Cliente;
import com.esperanca.projeto.repository.filter.ClienteFilter;
import com.esperanca.projeto.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import java.util.List;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

	private static final String CADASTRO_CLIENTE_VIEW = "CadastroCliente";
	@Autowired
	private ClienteService clienteService;

	@RequestMapping("/novo")
	public ModelAndView novo() {
		ModelAndView mv = new ModelAndView(CADASTRO_CLIENTE_VIEW);
		mv.addObject(new Cliente());
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String salvar(@Validated Cliente cliente, Errors errors, RedirectAttributes attributes) {
		if (errors.hasErrors()) {
			return CADASTRO_CLIENTE_VIEW;
		}
		
		try {
			clienteService.salvar(cliente);
			attributes.addFlashAttribute("mensagem", "Cliente salvo com sucesso!");
			return "redirect:/clientes/novo";
		} catch (IllegalArgumentException e) {
			errors.rejectValue("dataVencimento", null, e.getMessage());
			return CADASTRO_CLIENTE_VIEW;
		}
	}
	
	@RequestMapping
	public ModelAndView pesquisar(@ModelAttribute("filtro") ClienteFilter filtro) {
		List<Cliente> todosClientes = clienteService.filtrar(filtro);
		
		ModelAndView mv = new ModelAndView("PesquisaClientes");
		mv.addObject("clientes", todosClientes);
		return mv;
	}
	
	@RequestMapping("{codigo}")
	public ModelAndView edicao(@PathVariable("codigo") Cliente cliente) {
		ModelAndView mv = new ModelAndView(CADASTRO_CLIENTE_VIEW);
		mv.addObject(cliente);
		return mv;
	}
	
	@RequestMapping(value="{codigo}", method = RequestMethod.DELETE)
	public String excluir(@PathVariable Cliente cliente, RedirectAttributes attributes) {
		clienteService.excluir(cliente);
		
		attributes.addFlashAttribute("mensagem", "Cliente excluído com sucesso!");
		return "redirect:/clientes";
	}

}