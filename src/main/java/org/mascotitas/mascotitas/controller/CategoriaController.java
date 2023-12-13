package org.mascotitas.mascotitas.controller;

import java.util.List;

import org.mascotitas.mascotitas.model.Categoria;
import org.mascotitas.mascotitas.service.CategoriaService;
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
@RequestMapping(path="/api/categorias/") // http://localhost:8080/api/categorias/
public class CategoriaController {
	private final CategoriaService categoriaService;
	@Autowired
	public CategoriaController(CategoriaService categoriaService) {
		this.categoriaService = categoriaService;
	}//constructor
	@GetMapping	
	public List<Categoria> getAllCategorias(){
		return categoriaService.getAllCategorias();
	}//getAllCategoria
	
	@GetMapping(path="{catId}")    //http://localhost:8080/api/productos/1
	public Categoria getCategoria(@PathVariable ("catId") long id){            
		return categoriaService.getCategoria(id);
	}//getAllgetCategoria
	
	@DeleteMapping(path="{catId}")    //http://localhost:8080/api/productos/1
	public Categoria deleteCategoria(@PathVariable ("catId") long id){           
		return categoriaService.deleteCategoria(id);
	}//getAllProducto
	
	@PostMapping   //http://localhost:8080/api/productos/
	public Categoria addCategoria(@RequestBody Categoria categoria){            
		return categoriaService.addCategoria(categoria);
	}//addCategoria
	

	@PutMapping(path="{catId}")    //http://localhost:8080/api/productos/1?precio=55.80&imagen=bic40.jpg
	public Categoria updateCategoria(@PathVariable ("catId") long id,
			@RequestParam(required=false) String categoria){            
		return categoriaService.updateCategoria(id, categoria);
	}//updateCategoria
	
}//Class clienteController


