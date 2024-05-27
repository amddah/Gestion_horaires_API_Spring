package isi.projet.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import isi.projet.Models.Modules;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Map;

public interface ModuleRepo extends JpaRepository<Modules, String> {

    @Query("SELECT f.NomFiliere ,count(m.filiere.NomFiliere) as count FROM Filiere f LEFT JOIN Modules m ON f.NomFiliere = m.filiere.NomFiliere GROUP BY f.NomFiliere")
    public List<Object> countModulesByFiliere();
}
