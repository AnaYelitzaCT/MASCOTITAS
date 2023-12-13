package org.mascotitas.mascotitas.service;

import java.util.List;
import java.util.Optional;

import org.mascotitas.mascotitas.model.Categoria;
import org.mascotitas.mascotitas.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class CategoriaService {
	private final CategoriaRepository categoriaRepository;
	
	@Autowired
	public CategoriaService(CategoriaRepository categoriaRepository) {
		this.categoriaRepository = categoriaRepository;
	}//constructor
	
		public List<Categoria> getAllCategorias() {
			return categoriaRepository.findAll();    
		}//getAllProductos
		
		public Categoria getCategoria(long id) {
			return categoriaRepository.findById(id).orElseThrow(
					()-> new IllegalArgumentException("El Producto con el id [" +id
							+ "] no existe")
					);
				}//getCategoria
		
		public Categoria deleteCategoria(long id) {
			Categoria cat=null;
			if (categoriaRepository.existsById(id)) {
				cat = categoriaRepository.findById(id).get();
				categoriaRepository.deleteById(id);
			}//if existById
			return cat;
		}//deleteCategoria
		
		public Categoria addCategoria(Categoria categoria) {
			//TODO: validación 
			Optional<Categoria> tmpProd = categoriaRepository.findByCategoria(categoria.getCategoria());
			
			if (tmpProd.isEmpty()) { 
			return categoriaRepository.save(categoria);
			} else {
				System.out.println("Ya existe el producto con el nombre [" +
								categoria.getCategoria() + "]");
				return null;
			}// else
			}//addCategoria
		
		public Categoria updateCategoria(long id, String categoria) {
			Categoria cat=null;
			if (categoriaRepository.existsById(id)) {
				cat = categoriaRepository.findById(id).get();
							if(categoria!= null)cat.setCategoria(categoria);
							categoriaRepository.save(cat);
					}//existById
				return cat;
			}//updateCategoria

	}//Class ProductoService