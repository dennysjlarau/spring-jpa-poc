/**
 * Copyright 2021, derecho de autor: Dennys Javier Lara Uquillas
 */
package com.empresa.springboot.app.persistencia.parametro.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.empresa.springboot.app.persistencia.parametro.entity.ParametroEntity;

/**
 * @author Dennys Lara
 *
 */
@Repository ("parametroJpaImp")
public class ParametroDaoImp implements ParametroDaoI {

	@PersistenceContext
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public List<ParametroEntity> obtenerTodos() {
		return em.createQuery("from ParametroEntity").getResultList();
	}

	@Override
	@Transactional
	public void guardar(ParametroEntity parametro) {
		em.persist(parametro);
	}

}
