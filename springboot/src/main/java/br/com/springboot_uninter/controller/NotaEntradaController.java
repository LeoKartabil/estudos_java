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

import br.com.springboot_uninter.bo.FornecedorBO;
import br.com.springboot_uninter.bo.NotaEntradaBO;
import br.com.springboot_uninter.model.Fornecedor;
import br.com.springboot_uninter.model.NotaEntrada;
import br.com.springboot_uninter.model.NotaEntradaItem;

@Controller
@RequestMapping("/nota-entrada")
public class NotaEntradaController {
	
	@Autowired
	private NotaEntradaBO bo;
	
	@Autowired
	private FornecedorBO fornecedorBO;
	
	@RequestMapping(value = "/novo", method = RequestMethod.GET)
	public ModelAndView novo(ModelMap model) {
		model.addAttribute("notaEntrada", new NotaEntrada());
		model.addAttribute("fornecedores", fornecedorBO.listaTodos());
		return new ModelAndView("/nota-entrada/formulario", model);
	}
	
	@RequestMapping(value = "", method = RequestMethod.POST)
	public String salva(@Valid @ModelAttribute NotaEntrada notaEntrada, BindingResult result, RedirectAttributes attr) {
		
		if(result.hasErrors()) {
			return "/nota-entrada/formulario";
		}
		
		if(notaEntrada.getId() == null) {
			bo.insere(notaEntrada);
			attr.addFlashAttribute("feedback", "A nota de entrada foi cadastrada com sucesso!");
		} else {
			bo.atualiza(notaEntrada);
			attr.addFlashAttribute("feedback", "Os dados da nota de entrada foram atualizados com sucesso!");
		}
		
		return "redirect:/nota-entrada";
	}
	
	@RequestMapping(value="", method=RequestMethod.GET)
	public ModelAndView lista(ModelMap model) {
		model.addAttribute("notas", bo.listaTodos());
		return new ModelAndView("/nota-entrada/lista", model);
	}
	
	@RequestMapping(value="/{id}/item", method=RequestMethod.GET)
	public ModelAndView produto(@PathVariable("id") Long id, ModelMap model) {
		NotaEntradaItem nei = new NotaEntradaItem();
		NotaEntrada ne = bo.pesquisaPeloId(id);
		nei.setNotaEntrada(ne);
		model.addAttribute("notaEntradaItem", nei);
		model.addAttribute("produtos", bo.listaTodos());
		return new ModelAndView("/nota-entrada-item/formulario", model);
	}
	
	@RequestMapping(value="/remove/{id}", method=RequestMethod.GET)
	public String remove(@PathVariable("id") Long id, RedirectAttributes attr) {
		try {
			NotaEntrada notaEntrada = bo.pesquisaPeloId(id);
			bo.remove(notaEntrada);
			attr.addFlashAttribute("feedback", "A nota de entrada foi removida com sucesso!");
		} catch(Exception e) {
			e.printStackTrace();
		}
		return "redirect:/nota-entrada";
	}
	
	
	
}
