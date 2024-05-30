package isi.projet.Dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnseignanantIntervention {
    private String nom;
    private String prenom;
    private String email;
    private String module;
    private long VHCoursInter;
    private long VHtdInter;
    private long VHtpInter;
    private long EvaluationInter;

    // Assurez-vous que ce constructeur existe

}
