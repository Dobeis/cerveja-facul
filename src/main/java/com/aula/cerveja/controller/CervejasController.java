package com.aula.cerveja.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.aula.cerveja.model.Cerveja;

@Controller
@RequestMapping(value = "/cervejas")
public class CervejasController {

	@RequestMapping("/novo")
	public String novo(Cerveja cerveja) {
		return "cerveja/CadastroCerveja";
	}
	
	@RequestMapping("/cadastro")
	public String cadastro() {
		return "cerveja/cadastro-produto";
	}

	@RequestMapping(value = "/novo", method = RequestMethod.POST)
	public String cadastrar(@Valid Cerveja cerveja, BindingResult result, Model model, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			System.out.println(">>> sku: " + cerveja.getSku());
			System.out.println(">>> nome: " + cerveja.getNome());
			System.out.println(">>> descricao: " + cerveja.getDescricao());
			return novo(cerveja);
		}

		attributes.addFlashAttribute("mensagem", "Cerveja salva com sucesso!");
		System.out.println(">>> sku: " + cerveja.getSku());
		return "redirect:/cervejas/novo";
	}

}
