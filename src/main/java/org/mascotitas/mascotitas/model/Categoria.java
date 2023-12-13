package org.mascotitas.mascotitas.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//POJO PLan Old Java Object
@Entity
@Table(name="categoria")
public class Categoria {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idcategoria", unique = true, nullable = false)
	private Long id;
	@Column(nullable = false)
	private String categoria;
	


	public Categoria(String categoria) {
		this.categoria = categoria;
;
	}//constructor
	public Categoria() {
	}//const
	
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public Long getId() {
		return id;
	}//getid
	@Override
	public String toString() {
		return "Categoria [id=" + id + ", categoria=" + categoria + "]";
	}//toString
	
	
	
	
}//class
