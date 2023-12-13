package org.mascotitas.mascotitas.controller;

import java.util.List;

import org.mascotitas.mascotitas.model.ChangePassword;
import org.mascotitas.mascotitas.model.Cliente;
import org.mascotitas.mascotitas.service.ClienteService;
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
@RequestMapping(path="/api/clientes/") // http://localhost:8080/api/clientes/
public class ClienteController {
	private final ClienteService clienteService;
	@Autowired
	public ClienteController(ClienteService clienteService) {
		this.clienteService = clienteService;
	}//constructor
	@GetMapping	
	public List<Cliente> getAllClientes(){
		return clienteService.getAllClientes();
	}//getAllcliente
	
	@GetMapping(path="{clienId}")    
	public Cliente getCliente(@PathVariable ("cliendId") long id){            
		return clienteService.getCliente(id);
	}//getAllcliente
	
	@DeleteMapping(path="{clienId}")    
	public Cliente deleteCliente(@PathVariable ("clienId") long id){            
		return clienteService.deleteCliente(id);
	}//getAllProducto
	
	@PostMapping   //http://localhost:8080/api/productos/
	public Cliente addCliente(@RequestBody Cliente cliente){            
		return clienteService.addCliente(cliente);
	}//addCliente
	

	@PutMapping(path="{clienId}")    //http://localhost:8080/api/productos/1?precio=55.80&imagen=bic40.jpg
	public Cliente updateCliente(@PathVariable ("clienId") long id,
			@RequestParam(required=false) String nombre,
			@RequestParam(required=false) String email,
			@RequestParam(required=false) ChangePassword contraseña,
			@RequestParam(required=false) String telefono){            //esta instrucción modifica el valor que se le ponga arriba en el URL
		return clienteService.updateCliente(id, nombre, email, contraseña, telefono);
	}//updatecliente
	
}//Class clienteController


