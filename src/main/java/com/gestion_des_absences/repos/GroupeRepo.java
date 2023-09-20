package com.gestion_des_absences.repos;


import com.gestion_des_absences.models.Groupe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupeRepo extends JpaRepository<Groupe,Long> {
    Groupe findGroupeById(Long id_grp);

    @Query("select distinct g from Groupe g join g.matieres m join m.enseignants e where e.id = :enseignantId")
    List<Groupe> findGroupesByEnseignant(@Param("enseignantId") Long enseignantId);
}
