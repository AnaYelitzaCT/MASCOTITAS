package org.mascotitas.mascotitas.controller;

import java.util.List;

import org.mascotitas.mascotitas.model.Servicio;
import org.mascotitas.mascotitas.service.ServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//CRUD  -  Create  -Read  -Update  -Delete
//HTTP  -  POST    -GET   - PUT    -DELETE
@RestController
@RequestMapping(path="/api/servicios/") // http://localhost:8080/api/servicios/
public class ServicioController {
	
	private final ServicioService servicioService;
	@Autowired
	public ServicioController(ServicioService servicioService) {
		this.servicioService = servicioService;
	}//constructor
	@GetMapping	
	public List<Servicio> getAllServicios(){
		return servicioService.getAllServicios();
	}//getAllServicio 
	
	@GetMapping(path="{servId}")    //http://localhost:8080/api/productos/1
	public Servicio getServicio(@PathVariable ("servId") long id){          
		return servicioService.getServicio(id);
	}//getAllServicio
	
	@DeleteMapping(path="{servId}")    //http://localhost:8080/api/productos/1
	public Servicio deleteProducto(@PathVariable ("servId") long id){            
		return servicioService.deleteServicio (id);
	}//getAllServicio 
	
	@PostMapping   //http://localhost:8080/api/productos/
	public Servicio  addServicio (@RequestBody Servicio servicio ){            
		return servicioService.addServicio(servicio );
	}//addServicio 
	

	@PutMapping(path="{servId}")    //http://localhost:8080/api/productos/1?precio=55.80&imagen=bic40.jpg
	public Servicio  updateServicio (@PathVariable ("servId") long id,
			@RequestParam(required=false) String nombre,
			@RequestParam(required=false) String descripcion,
			@RequestParam(required=false) String image,
			@RequestParam(required=false) Double precio){            
		return servicioService.updateServicio(id,nombre, descripcion, image, precio);
	}//updateProducto
	
}//Class ProductoController


