package org.mascotitas.mascotitas.service;

import java.util.List;
import java.util.Optional;


import org.mascotitas.mascotitas.model.Venta;
import org.mascotitas.mascotitas.repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VentaService {
	private final VentaRepository ventaRepository;
	@Autowired
	public VentaService(VentaRepository ventaRepository) {
		this.ventaRepository = ventaRepository;
	}//constructor
	
	public List<Venta> getAllVentas() {
		return ventaRepository.findAll(); 
	}//getAllVentas
	
	public Venta getVenta(int id) {
		return ventaRepository.findById(id).orElseThrow(
				()-> new IllegalArgumentException("El Producto con el id [" +id
						+ "] no existe")
				);
			}//getVenta
			
	
	public Venta deleteVenta(int id) {
		Venta ven=null;
		if (ventaRepository.existsById(id)) {
			ven = ventaRepository.findById(id).get();
			ventaRepository.deleteById(id);
		}//if existById
		return ven;
	}//deleteVenta
	
	public Venta addVenta(Venta venta) {
		//TODO: validación 
				Optional<Venta> tmpProd = ventaRepository.findById(venta.getId());
				
				if (tmpProd.isEmpty()) { //no se encuentra el producto con ese nombre
				return ventaRepository.save(venta);
				} else {
					System.out.println("Ya existe el producto con el nombre [" +
									venta.getId() + "]");
					return null;
				}// else
				}//addVenta
	
	public Venta updateVenta(int id, String tipoPago, Double totalFinal) {
		Venta ven=null;
		if (ventaRepository.existsById(id)) {
			ven = ventaRepository.findById(id).get();
					if(tipoPago!= null)ven.setTipoPago(tipoPago);
					if(totalFinal!= null)ven.setTotalFinal(totalFinal);
					ventaRepository.save(ven);
			}//if
		
		return ven;
	}//update
}//class
