package com.examen.pokemon.entities;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
public class Entrenador {

	@Id
	@SequenceGenerator(name="entrenador_id_seq",allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "entrenador_id_seq")
	private Integer id;
	
	private String nombre;
	
	private String apellido;
	
	private String email;
	
	private Date fecha_nacimiento;
	
	private Date fecha_vinculacion;
	
	@ManyToOne
	@JoinColumn(name = "pueblo_id")
	private Pueblo pueblo;

	private String uuid;
	
	@ManyToMany
	private List<Pokemon> pokemon;
	
	
	
	
	
	
}
