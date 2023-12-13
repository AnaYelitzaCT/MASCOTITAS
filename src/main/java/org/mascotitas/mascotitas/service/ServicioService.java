package org.mascotitas.mascotitas.service;

import java.util.List;
import java.util.Optional;


import org.mascotitas.mascotitas.model.Servicio;
import org.mascotitas.mascotitas.repository.ServicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
@Service
public class ServicioService {
	private final ServicioRepository servicioRepository;
	@Autowired    

		public ServicioService(ServicioRepository servicioRepository) {
			this.servicioRepository = servicioRepository;
	}//servicioService
	public List<Servicio> getAllServicios() {
		return servicioRepository.findAll();  
	}//getAllServicios
	
	public Servicio getServicio(long id) {
		return servicioRepository.findById(id).orElseThrow(
				()-> new IllegalArgumentException("El Producto con el id [" +id
						+ "] no existe")
				);
			}//getServicio
	
	public Servicio deleteServicio(long id) {
		Servicio serv=null;
		if (servicioRepository.existsById(id)) {
			serv = servicioRepository.findById(id).get();
			servicioRepository.deleteById(id);
		}//if existById
		return serv;
	}//delete servicio
	
	@PostMapping
	public Servicio addServicio(Servicio servicio) {
		//TODO: validación 
				Optional<Servicio> tmpProd = servicioRepository.findByNombre(servicio.getNombre());
				
				if (tmpProd.isEmpty()) { //no se encuentra el producto con ese nombre
				return servicioRepository.save(servicio);
				} else {
					System.out.println("Ya existe el producto con el nombre [" +
									servicio.getNombre() + "]");
					return null;
				}// else
				}//add servicio
	
	public Servicio updateServicio(long id,String nombre, String descripcion, String image, Double precio) {
		
		Servicio serv=null;
		if (servicioRepository.existsById(id)) {
			serv = servicioRepository.findById(id).get();
						if(nombre!= null)serv.setNombre(nombre);
						if(descripcion!= null)serv.setDescripcion(descripcion);
						if(image!= null)serv.setImage(image);
						if(precio!= null)serv.setPrecio(precio);
						servicioRepository.save(serv);
						
				}//if
			return serv;
} //constructor
}//servicioService



