package com.examen.pokemon.repositories;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examen.pokemon.entities.TipoPokemon;



public interface Tipo_pokemonRepository  extends JpaRepository<TipoPokemon, Integer>{


	Optional<TipoPokemon> findByUuid(String uuid);
	
}
