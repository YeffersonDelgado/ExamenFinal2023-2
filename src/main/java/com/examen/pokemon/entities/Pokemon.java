package com.examen.pokemon.entities;

import java.util.Date;
import java.util.List;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Pokemon {
	
	@Id
	@SequenceGenerator(name="pokemon_id_seq",allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "pokemon_id_seq")
	private Integer id;
	
    private String nombre;
    
    private String descripcion;
    
    
	@ManyToOne
	@JoinColumn(name = "tipo_pokemon")
    private TipoPokemon tipoPokemon;
	
	private Date fecha_descubrimiento;
	
	private Integer generacion;
	
	private String uuid;
	
	
	@ManyToMany
	@JoinTable(
	        name = "captura",
	        joinColumns = @JoinColumn(name = "pokemon_id"),
	        inverseJoinColumns = @JoinColumn(name = "entrenador_id")
	    )
	private List<Entrenador> entrenador;
	
	

}
