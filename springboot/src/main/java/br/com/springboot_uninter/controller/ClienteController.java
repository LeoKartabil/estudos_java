package br.com.springboot_uninter.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.springboot_uninter.bo.ClienteBO;
import br.com.springboot_uninter.model.Cliente;

@Controller
@RequestMapping("/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteBO bo;
	
	@RequestMapping(value="/novo", method=RequestMethod.GET)
	public ModelAndView novo(ModelMap model) {
		model.addAttribute("cliente", new Cliente());
		return new ModelAndView("/cliente/formulario");
	}
	
	@RequestMapping(value="", method=RequestMethod.POST)
	public String salva(@Valid @ModelAttribute Cliente cliente, BindingResult result, RedirectAttributes attr) {
		
		if (result.hasErrors()) {
			return "cliente/formulario";
		}
		if (cliente.getId() == null) {
			bo.insere(cliente);
			attr.addFlashAttribute("feedback", "Cliente cadastrado com sucesso!");
		} else {
			bo.atualiza(cliente);
			attr.addFlashAttribute("feedback", "Cliente atualizado com sucesso!");
		}
		return "redirect:/clientes"; 
	}
	
	@RequestMapping(value="", method=RequestMethod.GET)
	public ModelAndView lista(ModelMap model) {
		model.addAttribute("clientes", bo.listaTodos());
		return new ModelAndView("/cliente/lista");
	}
	
	@RequestMapping(value="/edita/{id}", method=RequestMethod.GET)
	public ModelAndView edita(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("cliente", bo.pesquisaPeloId(id));
		return new ModelAndView("/cliente/formulario");
	}
	
	@RequestMapping(value="/inativa/{id}", method=RequestMethod.GET)
	public String inativa(@PathVariable("id") Long id, RedirectAttributes attr) {
		System.out.print(id);
		try {
			Cliente cliente = bo.pesquisaPeloId(id);
			bo.inativa(cliente);
			attr.addFlashAttribute("feedback", "Cliente foi inativado com sucesso!");
		} catch(Exception e) {
			e.printStackTrace();
		}
		return "redirect:/clientes";
	}
	
	@RequestMapping(value="/ativa/{id}", method=RequestMethod.GET)
	public String ativa(@PathVariable("id") Long id, RedirectAttributes attr) {
		System.out.print(id);
		try {
			Cliente cliente = bo.pesquisaPeloId(id);
			bo.ativa(cliente);
			attr.addFlashAttribute("feedback", "Cliente foi ativado com sucesso!");
		} catch(Exception e) {
			e.printStackTrace();
		}
		return "redirect:/clientes";
	}

}
