package org.mascotitas.mascotitas.repository;

import java.util.Optional;

import org.mascotitas.mascotitas.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository   
public interface ProductoRepository extends JpaRepository<Producto, Long> {
			Optional<Producto> findByNombre(String nombre);
	}// interface ProductoRepository
