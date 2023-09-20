package com.gestion_des_absences.repos;


import com.gestion_des_absences.models.Absence;
import com.gestion_des_absences.models.Etudiant;
import com.gestion_des_absences.models.Matiere;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AbsenceRepo extends JpaRepository<Absence,Long> {
    Absence findAbsenceById(Long id);

    Absence findAbsenceByEtudiant(Etudiant etudiant);
    List<Absence> findByEtudiant(Etudiant etudiant);

    Absence findAbsenceByMatiere(Matiere matiere);

    List<Absence> findAbsenceByEtudiantAndMatiere(Etudiant etudiant, Matiere matiere);
}
