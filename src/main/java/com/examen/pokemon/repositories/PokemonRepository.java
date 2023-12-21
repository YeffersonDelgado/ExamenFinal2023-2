package com.examen.pokemon.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examen.pokemon.entities.Pokemon;
import com.examen.pokemon.entities.TipoPokemon;



public interface PokemonRepository  extends JpaRepository<Pokemon, Integer>{


	
    List<Pokemon> findByTipoPokemon(TipoPokemon tipoPokemon);
    
    Optional<Pokemon> findByUuid(String uuid);
	
}
