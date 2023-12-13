package org.mascotitas.mascotitas.service;

import java.util.List;
import java.util.Optional;
import org.mascotitas.mascotitas.model.ChangePassword;
import org.mascotitas.mascotitas.model.Cliente;
import org.mascotitas.mascotitas.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
@Service
public class ClienteService {
	private final ClienteRepository clienteRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired 
	public ClienteService(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}//constructor
	public List<Cliente> getAllClientes() {
		return clienteRepository.findAll();
	}//getAllClientes
	
	public Cliente getCliente(long id) {
		return clienteRepository.findById(id).orElseThrow(
				()-> new IllegalArgumentException("El Producto con el id [" +id
						+ "] no existe")
				);
			}//getcliente
	
	public Cliente deleteCliente(long id) {
		Cliente clien=null;
		if (clienteRepository.existsById(id)) {
			clien = clienteRepository.findById(id).get();
			clienteRepository.deleteById(id);
		}//if existById
		return clien;
	}//delete cliente
	
	@PostMapping
	public Cliente addCliente(Cliente cliente) {
		Cliente client = null;
		if (clienteRepository.findByEmail(cliente.getEmail()).isEmpty()) {
			//Cifrar la contaseña
			cliente.setContraseña(passwordEncoder.encode(cliente.getContraseña()));
			client= clienteRepository.save(cliente);
		}else {
			System.out.println("El usuario con el email [" + cliente.getEmail()
			+ "] ya se encuentra registrado");
		}//if isEmpty
		return client;
				}//add cliente
	
	public Cliente updateCliente(long id, String nombre, String email, ChangePassword changePassword, String telefono) {
		
		Cliente clien=null;
		if (clienteRepository.existsById(id)) {
			clien = clienteRepository.findById(id).get();
						if(nombre!= null)clien.setNombre(nombre);
						if(email!= null)clien.setEmail(email);
						if(passwordEncoder.matches(changePassword.getPassword(),clien.getContraseña())) clien.setContraseña(passwordEncoder.encode(changePassword.getNewPassword()))   ;
						if(telefono!= null)clien.setTelefono(telefono);
						clienteRepository.save(clien);
				}//existById
			return clien;
		}//updateCliente
	
	public boolean validateUsuario(Cliente cliente) {
		Optional<Cliente>  userByEmail = clienteRepository.findByEmail(cliente.getEmail());
		if (userByEmail.isPresent()) {
			Cliente client = userByEmail.get();
			System.out.println("email:  "+userByEmail.get());
			System.out.println("pass1:  "+cliente.getContraseña());
			System.out.println("pass2:  "+client.getContraseña());
			if(passwordEncoder.matches(cliente.getContraseña(),client.getContraseña())) {
				return true;
			}//if password equals
		}//if isPresent
		
		return false;
	}//validateUser

}//Class 
	
	
	
	

