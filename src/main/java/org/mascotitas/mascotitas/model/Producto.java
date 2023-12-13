package org.mascotitas.mascotitas.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
//POJO PLan Old Java Object
@Entity
@Table(name="productos")
public class Producto {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", unique = true, nullable = false)
	private Long id;
	@Column(nullable = false)
	private String categoria;
	private String nombre;
	@Column(nullable = false)
	private String descripcion;
	private String image;
	private Double precio;
	
	public Producto(String categoria, String nombre, String descripcion, String image, Double precio) {
		this.categoria = categoria;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.image = image;
		this.precio = precio;
		
	}//constructor

	public Producto() {
		
	}//constructorProducto

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Long getId() {
		return id;
	}//GetId

	@Override
	public String toString() {
		return "Producto [id=" + id + ", categoria=" + categoria + ", nombre=" + nombre + ", descripcion=" + descripcion
				+ ", image=" + image + ", precio=" + precio + "]";
	}
	

	
	
	
}//class
