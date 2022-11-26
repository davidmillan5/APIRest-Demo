package com.pruebas.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pruebas.dao.PersonaDAO;
import com.pruebas.model.Persona;

@RestController
@RequestMapping("personas")
public class PersonaRest {
	
	@Autowired
	private PersonaDAO personaDAO;
	
	//Metodos HTTP - Solicitud al Servidor
	
	
	//GET, POST, PUT, DELETE -> Puede venir como un estado 200 - estado 500 - estado 404
	
	@PostMapping("/guardar")//localhost:8080/personas/guardar URI
	public void guardar(@RequestBody Persona persona) {
		personaDAO.save(persona);
		//Metodo es una peticion de microservicio
	}
	
	@GetMapping("/listar")
	public List<Persona> listar(){
		return personaDAO.findAll();
	}
	
	@DeleteMapping("/eliminar/{id}")
	public void eliminar(@PathVariable("id") Integer id) {
		personaDAO.deleteById(id);
	}
	
	@PutMapping("/actualizar")
	public void actualizar(@RequestBody Persona persona) {
		personaDAO.save(persona);
	}

}
