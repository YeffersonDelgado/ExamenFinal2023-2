package com.examen.pokemon.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examen.pokemon.entities.Pokemon;
import com.examen.pokemon.entities.TipoPokemon;

import com.examen.pokemon.repositories.PokemonRepository;
import com.examen.pokemon.repositories.Tipo_pokemonRepository;


@RestController
@RequestMapping("/pokemons")
@CrossOrigin
public class PokemonController {
	
	@Autowired
	PokemonRepository pokemonRepository;
	
	@Autowired
	Tipo_pokemonRepository tipo_pokemonRepository;

	
	@GetMapping("/lista")
	public List<?> lista() {
		return pokemonRepository.findAll();

	}
	
	
	@GetMapping("/{uuid}")
	public List<Pokemon> listTipoPokemon(@PathVariable String uuid) {
		Optional<TipoPokemon> tipoPokemon = tipo_pokemonRepository.findByUuid(uuid);
		if (tipoPokemon.isPresent()) {
			return pokemonRepository.findByTipoPokemon(tipoPokemon.get());
		}
		return null;
	}

	 @PostMapping("/create")
	    public Pokemon postPokemon(@RequestBody Pokemon pokemon) {
		 pokemonRepository.save(pokemon);
	        return pokemon;
	    }
	 
	 
	 
	
	
	
	
}
