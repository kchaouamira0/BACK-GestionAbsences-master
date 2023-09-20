package com.gestion_des_absences.services;


import com.gestion_des_absences.dtos.EnseignantDto;
import com.gestion_des_absences.models.Enseignant;
import com.gestion_des_absences.models.Etudiant;
import com.gestion_des_absences.models.Groupe;
import com.gestion_des_absences.models.Matiere;
import com.gestion_des_absences.repos.EnseignantRepo;
import com.gestion_des_absences.repos.EtudiantRepo;
import com.gestion_des_absences.repos.GroupeRepo;
import com.gestion_des_absences.repos.MatiereRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class EnseignantService {

    private EnseignantRepo enseignantRepo;
    private MatiereRepo matiereRepo;


    public EnseignantService(EnseignantRepo enseignantRepo, MatiereRepo matiereRepo) {
        this.enseignantRepo = enseignantRepo;
        this.matiereRepo = matiereRepo;
    }

    public List<Enseignant> getallProfs() {
        return this.enseignantRepo.findAll();
    }

    public Enseignant addProf(Enseignant enseignant) {
        return this.enseignantRepo.save(enseignant);
    }

    public Enseignant getProfbyId(Long id) {
        return this.enseignantRepo.getEnseignantById(id);
    }

    public Enseignant updateProf(Enseignant enseignant, Long id) {
        Enseignant existenseignant = enseignantRepo.getEnseignantById(id);
        existenseignant.setFirstName(enseignant.getFirstName());
        existenseignant.setLastName(enseignant.getLastName());
        existenseignant.setEmail(enseignant.getEmail());
        existenseignant.setImageUrl(enseignant.getImageUrl());
        existenseignant.setPassword(enseignant.getPassword());
        existenseignant.setMatiere(enseignant.getMatiere());
        enseignantRepo.save(existenseignant);
        return existenseignant;
    }

    public void deleteProf(Long id) {
        this.enseignantRepo.deleteById(id);
    }

    public Enseignant createEnseignantDto(EnseignantDto enseignantdto) {
        Matiere matiere = matiereRepo.findMatiereById(enseignantdto.getIdmatiere());
        Enseignant enseignant = new Enseignant();
        enseignant.setFirstName(enseignantdto.getFirstName());
        enseignant.setLastName(enseignantdto.getLastName());
        enseignant.setEmail(enseignantdto.getEmail());
        enseignant.setPassword(enseignantdto.getPassword());
        enseignant.setImageUrl(enseignantdto.getImageUrl());
        enseignant.setMatiere(matiere);
        enseignantRepo.save(enseignant);
        return enseignant;
    }

    @Autowired
    private GroupeRepo groupeRepo;
    @Autowired
    private EtudiantRepo etudiantRepo;
    // Other methods in the service

    public Groupe getGroupeById(Long groupeId) {
        Optional<Groupe> optionalGroupe = groupeRepo.findById(groupeId);
        if (optionalGroupe.isPresent()) {
            return optionalGroupe.get();
        } else {
            throw new NoSuchElementException("No groupe found with ID " + groupeId);
        }
    }

    public List<Etudiant> getListOfStudents(Long id){
        Enseignant enseignant = enseignantRepo.getEnseignantById(id);
        List<Etudiant> profstudents = new ArrayList<>();
        List<Groupe> profgrps = enseignant.getGroupes();
        List<Etudiant> etudiants = etudiantRepo.findAll();
        for (int i = 0 ; i<etudiants.size() ;i++){
            for (int j=0 ; j<profgrps.size();j++){
                if (etudiants.get(i).getGroupe()==profgrps.get(j)){
                    profstudents.add(etudiants.get(i));
                }

            }
        }
        return profstudents;

    }
    public List<Groupe> getListGroupeByEnseignant(Long idEns) {
        // TODO Auto-generated method stub
        return groupeRepo.findGroupesByEnseignant(idEns);
    }

    public Enseignant addGroupesToEnseignant(Long idE, List<Long> idGrps) {
        Enseignant enseignant=enseignantRepo.findById(idE).orElse(null);
        List<Groupe> groupes=groupeRepo.findAllById(idGrps);
        enseignant.getGroupes().addAll(groupes);
        enseignantRepo.save(enseignant);

        return enseignant;
    }
}

