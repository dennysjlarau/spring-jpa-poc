/**
 * Copyright 2021, derecho de autor: Dennys Javier Lara Uquillas
 */
package com.empresa.springboot.app.logica.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.springboot.app.persistencia.parametro.dao.ParametroDaoI;
import com.empresa.springboot.app.persistencia.parametro.entity.ParametroEntity;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author dennys
 *
 */
@Service
public class ParametroLogica implements ParametroLogicaI {

	@Autowired
	ParametroDaoI parametroDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<ParametroEntity> obtenerTodos() {
		return parametroDao.obtenerTodos();
	}

	@Override
	@Transactional(readOnly = true)
	public ParametroEntity obtenerPorId(Long id) {
		return parametroDao.obtenerPorId(id);
	}

	@Override
	@Transactional
	public void ingresar(ParametroEntity parametro) {
		parametroDao.ingresar(parametro);
		
	}

	@Override
	@Transactional
	public void actualizar(ParametroEntity parametro) {
		parametroDao.actualizar(parametro);
	}

	@Override
	@Transactional
	public void eliminar(Long id) {
		parametroDao.eliminar(id);
	}
	
}
