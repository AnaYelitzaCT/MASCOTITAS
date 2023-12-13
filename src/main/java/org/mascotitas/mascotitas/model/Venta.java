package org.mascotitas.mascotitas.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//POJO PLan Old Java Object
@Entity
@Table(name="venta")
public class Venta {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idventa", unique = true, nullable = false)
	private int id;

	private String tipoPago;
	
	@Column(nullable = false)
	private Double totalFinal;

	public Venta(String tipoPago, Double totalFinal) {
		this.tipoPago = tipoPago;
		this.totalFinal = totalFinal;
	}//constructor
	public Venta() {
		
	}//constructor
	public String getTipoPago() {
		return tipoPago;
	}
	public void setTipoPago(String tipoPago) {
		this.tipoPago = tipoPago;
	}
	public Double getTotalFinal() {
		return totalFinal;
	}
	public void setTotalFinal(Double totalFinal) {
		this.totalFinal = totalFinal;
	}
	public int getId() {
		return id;
	}//getId
	@Override
	public String toString() {
		return "Venta [id=" + id + ", tipoPago=" + tipoPago + ", totalFinal=" + totalFinal + "]";
	}//toString
	
}//class




