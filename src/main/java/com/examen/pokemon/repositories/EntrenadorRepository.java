package com.examen.pokemon.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examen.pokemon.entities.Entrenador;


public interface EntrenadorRepository  extends JpaRepository<Entrenador, Integer>{

	 Optional<Entrenador> findByEmail(String email);
	
}
