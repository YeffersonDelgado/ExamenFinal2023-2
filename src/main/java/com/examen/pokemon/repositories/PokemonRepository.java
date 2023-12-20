package com.examen.pokemon.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examen.pokemon.entities.Pokemon;


public interface PokemonRepository  extends JpaRepository<Pokemon, Integer>{

}
