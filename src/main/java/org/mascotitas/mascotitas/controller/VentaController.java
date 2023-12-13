package org.mascotitas.mascotitas.controller;

import java.util.List;


import org.mascotitas.mascotitas.model.Venta;
import org.mascotitas.mascotitas.service.VentaService;
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
@RequestMapping(path="/api/ventas/") // http://localhost:8080/api/ventas/
public class VentaController {
	private final VentaService ventaService;
	@Autowired
	public VentaController(VentaService ventaService) {
		this.ventaService = ventaService;
	}//constructor
	@GetMapping	
	public List<Venta> getAllVentas(){
		return ventaService.getAllVentas();
	}//getAllServicio 
	
	@GetMapping(path="{venId}")    //http://localhost:8080/api/productos/1
	public Venta getVenta(@PathVariable ("venId") int id){            
		return ventaService.getVenta(id);
	}//getAllServicio
	
	@DeleteMapping(path="{venId}")    //http://localhost:8080/api/productos/1
	public Venta deleteVenta(@PathVariable ("venId") int id){            
		return ventaService.deleteVenta (id);
	}//getAllServicio 
	
	@PostMapping   //http://localhost:8080/api/productos/
	public Venta  addVenta (@RequestBody Venta venta ){            
		return ventaService.addVenta(venta );
	}//addServicio 
	

	@PutMapping(path="{venId}")    //http://localhost:8080/api/productos/1?precio=55.80&imagen=bic40.jpg
	public Venta updateVenta (@PathVariable ("venId") int id,
			@RequestParam(required=false) String tipoPago,
			@RequestParam(required=false) Double totalFinal){            
		return ventaService.updateVenta(id,tipoPago, totalFinal);
	}//updateProducto
	
}//Class ProductoController
