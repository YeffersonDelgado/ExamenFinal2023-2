package com.examen.pokemon.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Captura {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	
	
	@ManyToOne
	@JoinColumn(name = "id_pokemon")
	private Pokemon pokemon;
	
	
	
	@ManyToOne
	@JoinColumn(name = "id_entrenador")
	private Entrenador entrenador;
	
	
	
	
}
