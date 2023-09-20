package com.gestion_des_absences.repos;


import com.gestion_des_absences.models.Enseignant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnseignantRepo extends JpaRepository<Enseignant,Long> {
    Enseignant getEnseignantById(Long id);

    Enseignant findEnseignantByEmail(String email);
}
