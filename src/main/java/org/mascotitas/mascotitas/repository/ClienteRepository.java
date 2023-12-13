package org.mascotitas.mascotitas.repository;

import java.util.Optional;


import org.mascotitas.mascotitas.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	Optional<Cliente> findByEmail(String email);
	
}