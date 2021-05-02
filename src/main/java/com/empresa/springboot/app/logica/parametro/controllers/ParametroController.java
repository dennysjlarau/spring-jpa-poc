/**
 * Copyright 2021, derecho de autor: Dennys Javier Lara Uquillas
 */
package com.empresa.springboot.app.logica.parametro.controllers;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.empresa.springboot.app.logica.services.ParametroLogicaI;
import com.empresa.springboot.app.persistencia.parametro.entity.ParametroEntity;

// REM para realizar un debug solo agregar los breakpoint
/**
 * @author Dennys Lara
 *
 */
@Controller // controlador de la vista o presentacion web
@SessionAttributes("parametro") // mantener el objeto en sesion control del id cuando esta nulo o tiene algun valor de la base de datos
public class ParametroController {

    @Autowired // inyectar una implementacion
    // @Qualifier("parametroJpaImp") seleccionar una implementacion cuando exista una interfaz y varias implementaciones por ejemplo imp
    // para h2, otra para mysql, etc
    private ParametroLogicaI parametroLogica;

    /**
     * obtiene todos los parametros
     * 
     * @param modelo de la vista
     * @return nombre de la vista (nombre del archivo html)
     */
    @RequestMapping(value = "/parametro", method = RequestMethod.GET)
    public String listarTodos(Model modelo) {
	modelo.addAttribute("titulo", "Listado de todos los parametros");
	modelo.addAttribute("parametros", parametroLogica.obtenerTodos());
	return "parametro/listarTodos"; // retorna la vista o el nombre del archivo que representa la presentacion web
    }

    /**
     * Inserta o Actualiza un registro
     * 
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
	ParametroEntity parametro = null;
	if (id > 0) {
	    parametro = parametroLogica.obtenerPorId(id);
	} else {
	    return "parametro/listarTodos";
	}
	modelo.put("titulo", "Editar parámetro");
	modelo.put("parametro", parametro);
	return "parametro/form";
    }

    @RequestMapping(value = "/parametro/form", method = RequestMethod.POST)
    public String guardar(@Valid @ModelAttribute("parametro") ParametroEntity parametro, BindingResult result, Model modelo, SessionStatus status) {
	if (result.hasErrors()) {
	    modelo.addAttribute("titulo", "Registrar nuevo del parámetro");
	    return "parametro/form";
	}

	if (parametro.getId() == null || parametro.getId() == 0) {
	    parametroLogica.ingresar(parametro);
	} else {
	    parametroLogica.actualizar(parametro);
	}

	status.setComplete(); // terminar la sesion como mejor practica
	return "redirect:/parametro";
    }

    @RequestMapping(value = "/parametro/eliminar/{id}", method = RequestMethod.GET)
    public String eliminar(@PathVariable(value = "id") Long id) {
	if (id > 0) {
	    parametroLogica.eliminar(id);
	}
	return "redirect:/parametro";
    }
}
