package com.gestion_des_absences.repos;


import com.gestion_des_absences.models.Etudiant;
import com.gestion_des_absences.models.Groupe;
import com.gestion_des_absences.models.ListGrp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EtudiantRepo extends JpaRepository<Etudiant,Long> {

    Etudiant findEtudiantById(Long id);
    Etudiant findEtudiantByGroupe(ListGrp groupe);

    List<Etudiant> findEtudiantByGroupe(Groupe groupe);


    Etudiant findEtudiantByEmail(String email);
}
