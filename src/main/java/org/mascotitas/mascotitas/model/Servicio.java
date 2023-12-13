package org.mascotitas.mascotitas.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="servicios")
public class Servicio {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", unique = true, nullable = false)
	private Long id;
	@Column(nullable = false)
	private String nombre;
	@Column(nullable = false)
	private String descripcion;
	private String image;
	private Double precio;
	

	public Servicio(String nombre, String descripcion, String image, Double precio) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.image = image;
		this.precio = precio;
	}//constructor
	public Servicio() {
	}//servicio
	
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
	}//getId
	@Override
	public String toString() {
		return "Servicio [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", image=" + image
				+ ", precio=" + precio + "]";
	}//toString
	
	
	
}//class servicio
