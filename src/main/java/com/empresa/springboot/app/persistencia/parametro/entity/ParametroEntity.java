/**
 * Copyright 2021, derecho de autor: Dennys Javier Lara Uquillas
 */
package com.empresa.springboot.app.persistencia.parametro.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * @author Dennys Lara
 * Mapeo de la tabla de base de datos parametros
 */
@Entity
@Table(name = "parametros")
public class ParametroEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "identificador")
	private Long id;
	
	@NotEmpty
	@Size(min = 3, max = 30)
	private String nombre;
	
	@Column(name = "valor_cadena")
	private String valorCadena;
	
	private String descripcion;
	
	@NotEmpty
	@Size(min = 1, max = 2)
	private String estado;
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getValorCadena() {
		return valorCadena;
	}

	public void setValorCadena(String valorCadena) {
		this.valorCadena = valorCadena;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
