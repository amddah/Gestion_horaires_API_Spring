package isi.projet.Models;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "module")
public class Modules {
	@Id
	private String intitule;
	private Long vHCours;
	private Long vHtd;
	private Long vHtp;
	private Long evaluation;
	@OneToMany(mappedBy = "module")
    private Set<Intervention> interventions = new HashSet<>();
    @ManyToOne
    private Filiere filiere;


}
