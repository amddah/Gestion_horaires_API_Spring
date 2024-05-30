package isi.projet.Models;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "enseignant")
public class Enseignant {
	@Id
	private String email;
	private String nom;
	private String prenom;
	@OneToMany(mappedBy = "enseignant",cascade =CascadeType.REMOVE)
    private Set<Intervention> interventions = new HashSet<>();


}
