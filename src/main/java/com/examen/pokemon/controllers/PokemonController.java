package com.examen.pokemon.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examen.pokemon.entities.Pokemon;
import com.examen.pokemon.repositories.PokemonRepository;


@RestController
@RequestMapping("/pokemons")
@CrossOrigin
public class PokemonController {
	
	@Autowired
	PokemonRepository pokemonRepository;

	 @PostMapping
	    public Pokemon postStudent(@RequestBody Pokemon pokemon) {
		 pokemonRepository.save(pokemon);
	        return pokemon;
	    }
	
	
}
