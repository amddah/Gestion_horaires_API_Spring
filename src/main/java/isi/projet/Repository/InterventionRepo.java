package isi.projet.Repository;

import isi.projet.Dto.EnseignanantIntervention;
import org.springframework.data.jpa.repository.JpaRepository;

import isi.projet.Models.Intervention;
import isi.projet.Models.InterventionId;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface InterventionRepo extends JpaRepository<Intervention, InterventionId>{

    @Query("SELECT e.email as emailEnseignant, e.nom as nomEnseignant, e.prenom as prenomEnseignant, i.module.intitule as intituleModule, SUM(i.VHCoursInter + i.VHtdInter + i.VHtpInter) " +
            "FROM Intervention i JOIN i.enseignant e GROUP BY e.nom, e.prenom, i.module.intitule")
    List<Object[]> findInterventionsGroupedByEnseignantAndModule();

    @Query(value = "SELECT e.email,e.nom,e.prenom, " +
            "GROUP_CONCAT(DISTINCT i.module_intitule ORDER BY i.module_intitule SEPARATOR ', ') AS modules, " +
            "SUM(i.evaluation_inter + i.vhtp_inter + i.vhcours_inter) AS heures " +
            "FROM enseignant e " +
            "JOIN intervention i ON e.email = i.enseignant_email " +
            "GROUP BY e.email",
            nativeQuery = true)
    public List<Object> getEnseingantModulesHeures();

    @Query("SELECT new isi.projet.Dto.EnseignanantIntervention(e.nom, e.prenom, e.email, i.module.intitule, i.VHCoursInter, i.VHtdInter, i.VHtpInter, i.EvaluationInter) " +
            "FROM Intervention i JOIN i.enseignant e " +
            "WHERE e.email = :email")
    List<EnseignanantIntervention> getInterventionByEnseignant(@Param("email") String email);




}
