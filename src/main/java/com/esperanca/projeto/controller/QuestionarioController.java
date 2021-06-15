package com.esperanca.projeto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.esperanca.projeto.model.Questionario;
import com.esperanca.projeto.repository.filter.QuestionarioFilter;
import com.esperanca.projeto.service.QuestionarioService;


@Controller
@RequestMapping("/questionarios")
public class QuestionarioController {

    private static final String CADASTRO_QUESTIONARIO_VIEW = "CadastroQuestionarios";
    @Autowired
    private QuestionarioService questionarioService;

    @RequestMapping("/novo")
    public ModelAndView novo() {
        ModelAndView mv = new ModelAndView(CADASTRO_QUESTIONARIO_VIEW);
        mv.addObject(new Questionario());
        return mv;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String salvar(@Validated Questionario questionario, Errors errors, RedirectAttributes attributes) {
        if (errors.hasErrors()) {
            return CADASTRO_QUESTIONARIO_VIEW;
        }
        System.out.println(questionario);
        questionarioService.salvar(questionario);
        attributes.addFlashAttribute("mensagem", "Questionario salvo com sucesso!");
        return "redirect:/questionarios/novo";
    }

    @RequestMapping
    public ModelAndView pesquisar(@ModelAttribute("filtro") QuestionarioFilter filtro) {
        List<Questionario> todosQuestionarios = questionarioService.filtrar(filtro);

        ModelAndView mv = new ModelAndView("PesquisaQuestionarios");
        mv.addObject("questionarios", todosQuestionarios);
        return mv;
    }

    @RequestMapping("{codigo}")
    public ModelAndView edicao(@PathVariable("codigo") Questionario questionario) {
        ModelAndView mv = new ModelAndView(CADASTRO_QUESTIONARIO_VIEW);
        mv.addObject(questionario);
        return mv;
    }

    @RequestMapping(value = "{codigo}", method = RequestMethod.DELETE)
    public String excluir(@PathVariable Questionario questionario, RedirectAttributes attributes) {
        questionarioService.excluir(questionario);

        attributes.addFlashAttribute("mensagem", "Questionário excluído com sucesso!");
        return "redirect:/questionarios";
    }




}