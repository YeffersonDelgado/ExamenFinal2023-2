package com.examen.pokemon.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Entrenador {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String nombre;
	
	private String apellido;
	
	private String email;
	
	private String fecha_nacimiento;
	
	private String fecha_vinculacion;
	
	@ManyToOne
	@JoinColumn(name = "id_pueblo")
	private Pueblo pueblo;

	private String uuid;
	
	@ManyToMany
	@JoinTable(
		        name = "entrenador_pokemon",
		        joinColumns = @JoinColumn(name = "entrenador_id"),
		        inverseJoinColumns = @JoinColumn(name = "pokemon_id")
		    )
	private List<Pokemon> pokemon;
	
	
	
	
	
	
}
