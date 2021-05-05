/**
 * Copyright 2021, derecho de autor: Dennys Javier Lara Uquillas
 */
package com.empresa.springboot.app.persistencia.parametro.dao;

import org.springframework.data.repository.CrudRepository;

import com.empresa.springboot.app.persistencia.parametro.entity.ParametroEntity;

/**
 * @author Dennys Lara Interfaz para el acceso de datos a la tabla parametros
 */
public interface ParametroDaoI extends CrudRepository<ParametroEntity, Long> {

}
