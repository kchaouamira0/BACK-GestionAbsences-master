package com.gestion_des_absences.services;


import com.gestion_des_absences.models.Enseignant;
import com.gestion_des_absences.models.Matiere;
import com.gestion_des_absences.repos.MatiereRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatiereService {
    private MatiereRepo matiereRepo ;

    public MatiereService(MatiereRepo matiereRepo) {
        this.matiereRepo = matiereRepo;
    }

    public List<Matiere> getAllSubjects(){return this.matiereRepo.findAll();}
    public Matiere addSubject(Matiere matiere){
        return this.matiereRepo.save(matiere);
    }

    public Matiere getSubjectById (Long id){
        return this.matiereRepo.findMatiereById(id);
    }

    public Matiere updateSubject(Matiere matiere,Long id) {
        Matiere matiere1= matiereRepo.findMatiereById(id);
        matiere1.setLibelle(matiere.getLibelle());
        matiereRepo.save(matiere1);
        return matiere1;
    }

    public void deleteSubject(Long id ){
        this.matiereRepo.deleteById(id);
    }
}
