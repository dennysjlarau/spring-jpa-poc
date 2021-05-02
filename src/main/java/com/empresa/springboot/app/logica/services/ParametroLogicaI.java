/**
 * Copyright 2021, derecho de autor: Dennys Javier Lara Uquillas
 */
package com.empresa.springboot.app.logica.services;

import java.util.List;

import com.empresa.springboot.app.persistencia.parametro.entity.ParametroEntity;

/**
 * @author dennys lara
 *
 */
public interface ParametroLogicaI {

public List<ParametroEntity> obtenerTodos();
	
	public ParametroEntity obtenerPorId(Long id);
	
	public void ingresar(ParametroEntity parametro);
	
	public void actualizar(ParametroEntity parametro);
	
	public void eliminar(Long id);
}
