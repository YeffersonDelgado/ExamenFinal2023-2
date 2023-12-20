package com.examen.pokemon.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examen.pokemon.entities.Entrenador;
import com.examen.pokemon.entities.Pokemon;
import com.examen.pokemon.entities.Tipo_pokemon;
import com.examen.pokemon.repositories.EntrenadorRepository;


@RestController
@RequestMapping("/entrenador")
@CrossOrigin
public class EntrendorController {

	@Autowired
	EntrenadorRepository entrenadorRepository;
	
	
	@GetMapping("/{uuid}/pokemons")
	public List<Pokemon> listar(String uuid){
		
		Optional<Entrenador> entrenador = entrenadorRepository.findByUuid(uuid);
		
		if(entrenador.isPresent()) {
			return entrenador.get().getPokemon();
		}
		return null;
	}
	
	
	
	@PostMapping("/login")
	public String login(String email){
		
		  Optional<Entrenador> entrenador = entrenadorRepository.findByEmail(email);
	        if (entrenador.isPresent()) {
	            return entrenador.get().getUuid();
	        }
	        return null;
		
		
	}
	
}
