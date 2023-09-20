package com.gestion_des_absences.services;


import com.gestion_des_absences.models.Absence;
import com.gestion_des_absences.models.Etudiant;
import com.gestion_des_absences.models.Matiere;
import com.gestion_des_absences.repos.AbsenceRepo;
import com.gestion_des_absences.repos.EnseignantRepo;
import com.gestion_des_absences.repos.EtudiantRepo;
import com.gestion_des_absences.repos.MatiereRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AbsenceService {
    private AbsenceRepo absenceRepo;
    @Autowired
    private EtudiantRepo etudiantRepo;
    @Autowired
    private MatiereRepo matiereRepo;

    public AbsenceService(AbsenceRepo absenceRepo) {
        this.absenceRepo = absenceRepo;
    }

    public List<Absence> getAllAbsences (){
        return this.absenceRepo.findAll();
    }

    public Absence findAbsenceById(Long id ){
        return this.absenceRepo.findAbsenceById(id);
    }

    public Integer findAbsenceByEtudiantAndMatiere(Long etudiantId,Long matId) {
        Etudiant etudiant = etudiantRepo.findEtudiantById(etudiantId);
        Matiere matiere = matiereRepo.findMatiereById(matId);
        return this.absenceRepo.findAbsenceByEtudiantAndMatiere(etudiant,matiere).size();

    }

    @Transactional
    public Absence addAbsence (String  date_abs ,Long etudiantId ,Long matId){
        Etudiant etudiant = etudiantRepo.findEtudiantById(etudiantId);
        Matiere matiere = matiereRepo.findMatiereById(matId);
        Absence absence = new Absence();
        absence.setDate_abs(date_abs);
        absence.setEtudiant(etudiant);
        absence.setMatiere(matiere);


        return this.absenceRepo.save(absence);
    }


    public List<Absence> getAbsenesEtudiant(Long etudiantId){
        Etudiant etudiant =this.etudiantRepo.findEtudiantById(etudiantId);
        return this.absenceRepo.findByEtudiant(etudiant);

    }





}
