package org.mascotitas.mascotitas.repository;

import java.util.Optional;

import org.mascotitas.mascotitas.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository  
public interface CategoriaRepository extends JpaRepository<Categoria, Long>  {
	Optional<Categoria> findByCategoria(String categoria);
}// interface ProductoRepository

