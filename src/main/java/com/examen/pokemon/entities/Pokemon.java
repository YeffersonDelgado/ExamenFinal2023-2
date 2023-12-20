package com.examen.pokemon.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Pokemon {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
    private String nombre;
    
    private String descripcion;
    
    
	@ManyToOne
	@JoinColumn(name = "tipo_id")
    private Tipo_pokemon tipo_pokemon;
	
	private String fecha_descubrimiento;
	
	private Integer generacion;
	
	private String uuid;
	
	
	@ManyToMany(mappedBy = "pokemons")
	private Entrenador entrenador;
	
	

}
