package org.mascotitas.mascotitas.service;

import java.util.List;
import java.util.Optional;

import org.mascotitas.mascotitas.model.Producto;
import org.mascotitas.mascotitas.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

@Service
public class ProductoService {  
	private final ProductoRepository productoRepository;
	
	@Autowired
	public ProductoService(ProductoRepository productoRepository) {
	this.productoRepository = productoRepository;
}//constructor

	public List<Producto> getAllProductos() {  
	return productoRepository.findAll();    
	}//getAllProductos
	
	public Producto getProducto(long id) {
		return productoRepository.findById(id).orElseThrow(
		()-> new IllegalArgumentException("El Producto con el id [" +id
				+ "] no existe")
		);
	}//getProducto
	
	public Producto deleteProducto(long id) {
		Producto prod=null;
		if (productoRepository.existsById(id)) {
			prod = productoRepository.findById(id).get();
			productoRepository.deleteById(id);
		}//if existById
		return prod;
	}//delete producto
	
	@PostMapping
	public Producto addProducto(Producto producto) {
		//TODO: validación 
		Optional<Producto> tmpProd = productoRepository.findByNombre(producto.getNombre());
		
		if (tmpProd.isEmpty()) { //no se encuentra el producto con ese nombre
		return productoRepository.save(producto);
		} else {
			System.out.println("Ya existe el producto con el nombre [" +
							producto.getNombre() + "]");
			return null;
		}// else
		}//add producto
	
	public Producto updateProducto(long id,String categoria, String nombre, String descripcion, String image, Double precio) {
		
		Producto prod=null;
			if (productoRepository.existsById(id)) {
			prod = productoRepository.findById(id).get();
						if(categoria!= null)prod.setCategoria(categoria);
						if(nombre!= null)prod.setNombre(nombre);
						if(descripcion!= null)prod.setDescripcion(descripcion);
						if(image!= null)prod.setImage(image);
						if(precio!= null)prod.setPrecio(precio);
						productoRepository.save(prod);
				}//existById
			return prod;
		}//updateProducto

}//Class ProductoService