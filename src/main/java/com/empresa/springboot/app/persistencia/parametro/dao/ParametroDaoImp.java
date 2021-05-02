/**
 * Copyright 2021, derecho de autor: Dennys Javier Lara Uquillas
 */
package com.empresa.springboot.app.persistencia.parametro.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

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
	public List<ParametroEntity> obtenerTodos() {
		return em.createQuery("from ParametroEntity").getResultList();
	}

	@Override
	public ParametroEntity obtenerPorId(Long id) {
		return em.find(ParametroEntity.class, id);
	}
	
	@Override
	public void ingresar(ParametroEntity parametro) {
		em.persist(parametro);
	}

	@Override
	public void actualizar(ParametroEntity parametro) {
		em.merge(parametro);
	}

	@Override
	public void eliminar(Long id) {
		em.remove(obtenerPorId(id));
	}
}
	