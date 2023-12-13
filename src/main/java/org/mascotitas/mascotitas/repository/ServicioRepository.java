package org.mascotitas.mascotitas.repository;

import java.util.Optional;
import org.mascotitas.mascotitas.model.Servicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository 
public interface ServicioRepository extends JpaRepository<Servicio, Long> {
	Optional<Servicio> findByNombre(String nombre);
}// interface ServicioRepository
