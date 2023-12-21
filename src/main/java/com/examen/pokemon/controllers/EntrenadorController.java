package com.examen.pokemon.controllers;


import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examen.pokemon.entities.Entrenador;
import com.examen.pokemon.entities.Pokemon;
import com.examen.pokemon.repositories.EntrenadorRepository;
import com.examen.pokemon.repositories.PokemonRepository;



@RestController
@RequestMapping("/entrenador")
@CrossOrigin
public class EntrenadorController {

	@Autowired
	EntrenadorRepository entrenadorRepository;
	
	@Autowired
	PokemonRepository pokemonRepository;

	
	  @GetMapping("/{uuidEntrenador}/capturar/{uuidPokemon}")
	    public ResponseEntity<List<Pokemon>> capturarPokemon(
	            @PathVariable String uuidEntrenador,
	            @PathVariable String uuidPokemon) {

	        Optional<Entrenador> optionalEntrenador = entrenadorRepository.findByUuid(uuidEntrenador);
	        Optional<Pokemon> optionalPokemon = pokemonRepository.findByUuid(uuidPokemon);

	        if (optionalEntrenador.isPresent() && optionalPokemon.isPresent()) {
	            Entrenador entrenador = optionalEntrenador.get();
	            Pokemon pokemon = optionalPokemon.get();

	            List<Pokemon> pokemonList = entrenador.getPokemon();

	            if (pokemonList.contains(pokemon)) {
	                return ResponseEntity.badRequest().body(pokemonList);
	            }

	            // Agrega el Pokémon al entrenador
	            pokemonList.add(pokemon);
	            entrenador.setPokemon(pokemonList);
	            entrenadorRepository.save(entrenador);

	            return ResponseEntity.ok(pokemonList);
	        } else {
	            return ResponseEntity.badRequest().body(Collections.emptyList());
	        }
	    }
		
		
		
	
	
	
	
	
	@GetMapping("/lista")
	public List<?> lista() {
		return entrenadorRepository.findAll();
	}
	
	@GetMapping("/{uuid}/pokemons")
	public List<Pokemon> listar(String uuid){
		
		Optional<Entrenador> entrenador = entrenadorRepository.findByUuid(uuid);		
		if(entrenador.isPresent()) {
			return entrenador.get().getPokemon();
		}
		return null;
	}
	
	@GetMapping("/{uuid}")
    public Optional<Entrenador> findEntrenadorById(@PathVariable String uuid) {
        Optional<Entrenador> entrenador = entrenadorRepository.findByUuid(uuid);
        if (entrenador.isPresent()) {
            return entrenador;
        }
        return null;
	}
	
	@PostMapping("/save")
    public Entrenador postEntrenador(@RequestBody Entrenador entrenador) {
	 entrenadorRepository.save(entrenador);
        return entrenador;
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
