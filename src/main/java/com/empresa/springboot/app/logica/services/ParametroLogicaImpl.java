/**
 * Copyright 2021, derecho de autor: Dennys Javier Lara Uquillas
 */
package com.empresa.springboot.app.logica.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.empresa.springboot.app.persistencia.parametro.dao.ParametroDaoI;
import com.empresa.springboot.app.persistencia.parametro.entity.ParametroEntity;

/**
 * @author dennys
 *
 */
@Service
public class ParametroLogicaImpl implements ParametroLogicaI {

    @Autowired
    ParametroDaoI parametroDao;

    @Override
    @Transactional(readOnly = true)
    public List<ParametroEntity> obtenerTodos() {
	return (List<ParametroEntity>) parametroDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public ParametroEntity obtenerPorId(Long id) {
	return parametroDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void guardar(ParametroEntity parametro) {
	parametroDao.save(parametro);

    }

    @Override
    @Transactional
    public void eliminar(Long id) {
	parametroDao.deleteById(id);
    }

}
