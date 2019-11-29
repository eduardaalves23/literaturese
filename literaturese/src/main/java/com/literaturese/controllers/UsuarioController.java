package com.literaturese.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.literaturese.models.Usuario;
import com.literaturese.repository.UsuarioRepository;

@Controller
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository ur;
	
	@RequestMapping(value="/cadastrarUsuario", method=RequestMethod.GET)
	public String form() {
		return "usuario/formUsuario";
	}
	
	@RequestMapping(value="/cadastrarUsuario", method=RequestMethod.POST)
	public String form (@Valid Usuario usuario, BindingResult result, RedirectAttributes attributes){
		ur.save(usuario);
		return "redirect:/cadastrarAluno";
	}
	
	@RequestMapping("/usuarios")
	public ModelAndView listaUsuarios() {
		ModelAndView mv = new ModelAndView("LISTA-FAZER");
		Iterable<Usuario> usuarios = ur.findAll();
		mv.addObject("usuarios", usuarios);
		return mv;
	}
	
	@RequestMapping("/deletarUsuario")
	public String deletarUsuario(long codigo) {
		Usuario usuario = ur.findByCodigo(codigo);
		ur.delete(usuario);
		return "redirect:/usuarios";
	}

}
