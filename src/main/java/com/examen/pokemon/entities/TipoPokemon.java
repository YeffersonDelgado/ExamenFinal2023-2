package com.examen.pokemon.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "tipo_pokemon")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class TipoPokemon {

	@Id
	@SequenceGenerator(name="tipo_pokemon_id_seq",allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "tipo_pokemon_id_seq")
	private Integer id;
	
	private String descripcion;
	
	private String uuid;
}
