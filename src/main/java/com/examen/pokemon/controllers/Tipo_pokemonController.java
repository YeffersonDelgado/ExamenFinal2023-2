package com.examen.pokemon.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examen.pokemon.entities.Tipo_pokemon;
import com.examen.pokemon.repositories.Tipo_pokemonRepository;


@RestController
@RequestMapping("/pokemons")
@CrossOrigin
public class Tipo_pokemonController {
	
	@Autowired
	Tipo_pokemonRepository tipo_pokemonRepository;
	
	@GetMapping("/{tipo}")
	public List<Tipo_pokemon> listar(){
		return tipo_pokemonRepository.findAll();
	}
	
	
	 @PostMapping("/add")
	    public Tipo_pokemon postPokemon(@RequestBody Tipo_pokemon tipo_pokemon) {
		 tipo_pokemonRepository.save(tipo_pokemon);
	        return tipo_pokemon;
	    }

}
