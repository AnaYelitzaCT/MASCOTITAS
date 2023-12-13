package org.mascotitas.mascotitas.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//POJO PLan Old Java Object
@Entity
@Table(name="clientes")
public class Cliente {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", unique = true, nullable = false)
	private Long id;
	@Column(nullable = false)
	private String nombre;
	private String email;
	@Column(nullable = false)
	private String contraseña;
	private String telefono;
	
	public Cliente(String nombre, String email, String contraseña, String telefono) {
		this.nombre = nombre;
		this.email = email;
		this.contraseña = contraseña;
		this.telefono = telefono;
	}//constructor
		public Cliente() {
		}//constructorProducto
		public String getNombre() {
			return nombre;
		}
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getContraseña() {
			return contraseña;
		}
		public void setContraseña(String contraseña) {
			this.contraseña = contraseña;
		}
		public String getTelefono() {
			return telefono;
		}
		public void setTelefono(String telefono) {
			this.telefono = telefono;
		}
		public Long getId() {
			return id;
		}//getId
		@Override
		public String toString() {
			return "Cliente [id=" + id + ", nombre=" + nombre + ", email=" + email + ", contraseña=" + contraseña
					+ ", telefono=" + telefono + "]";
		}//toString

			
		

}//public class
