/**
 * Copyright 2021, derecho de autor: Dennys Javier Lara Uquillas
 */
package com.empresa.springboot.app.logica.parametro.controllers;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.empresa.springboot.app.persistencia.parametro.dao.ParametroDaoI;
import com.empresa.springboot.app.persistencia.parametro.entity.ParametroEntity;

/**
 * @author Dennys Lara
 *
 */
@Controller
public class ParametroController {

	@Autowired
	@Qualifier("parametroJpaImp")
	private ParametroDaoI parametroDaoI;
	
	/**
	 * obtiene todos los parametros
	 * @param modelo de la vista
	 * @return nombre de la vista (nombre del archivo html)
	 */
	@RequestMapping(value = "/parametro", method = RequestMethod.GET)
	public String listarTodos(Model modelo) {
		modelo.addAttribute("titulo", "Listado de todos los parametros");
		modelo.addAttribute("parametros", parametroDaoI.obtenerTodos());
		return "parametro/listarTodos";
	}
	
	/**
	 * Inserta o Actualiza un registro
	 * @param modelo de la vista
	 * @return nombre de vista (nombre del archivo html)
	 */
	@RequestMapping(value = "/parametro/form", method = RequestMethod.GET)
	public String crear(Map<String, Object> modelo) {
		ParametroEntity parametro = new ParametroEntity();
		modelo.put("titulo", "Registrar nuevo del parámetro");
		modelo.put("parametro", parametro);
		return "parametro/form";
	}
	
	@RequestMapping(value = "/parametro/form/{id}", method = RequestMethod.GET)
	public String editar(@PathVariable(value = "id") Long id, Map<String, Object> modelo) {
		ParametroEntity parametro = parametroDaoI.obtenerPorId(id);
		modelo.put("titulo", "Editar parámetro");
		modelo.put("parametro", parametro);
		return "parametro/form"; 
	}
	
	@RequestMapping(value = "/parametro/form", method = RequestMethod.POST)
	public String guardar(@Valid @ModelAttribute("parametro") ParametroEntity parametro, BindingResult result, Model modelo) {
		if (result.hasErrors()) {
			modelo.addAttribute("titulo", "Registrar nuevo del parámetro");
			return "parametro/form"; 
		}
		parametroDaoI.guardar(parametro);
		return "redirect:/parametro";
	}
}
