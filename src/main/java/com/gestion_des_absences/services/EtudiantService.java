package com.gestion_des_absences.services;


import com.gestion_des_absences.dtos.EtudiantDto;
import com.gestion_des_absences.models.Enseignant;
import com.gestion_des_absences.models.Etudiant;
import com.gestion_des_absences.models.Groupe;
import com.gestion_des_absences.repos.EtudiantRepo;
import com.gestion_des_absences.repos.GroupeRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EtudiantService {
    private EtudiantRepo etudiantRepo;
    private GroupeRepo groupeRepo;

    public EtudiantService(EtudiantRepo etudiantRepo, GroupeRepo groupeRepo) {
        this.etudiantRepo = etudiantRepo;
        this.groupeRepo = groupeRepo;
    }
   public Etudiant saveStudent(Etudiant etudiant){
        return this.etudiantRepo.save(etudiant);
    }

    /*public Etudiant saveStudentDto(EtudiantDto etudiantDto) {
        Groupe groupe = groupeRepo.findGroupeById(etudiantDto.getIdg());
        Etudiant etudiant1 = new Etudiant();

        etudiant1.setNom(etudiantDto.getNom());
        etudiant1.setPrenom(etudiantDto.getPrenom());
        etudiant1.setEmail(etudiantDto.getEmail());
        etudiant1.setPassword(etudiantDto.getPassword());
        etudiant1.setImageUrl(etudiantDto.getImageUrl());
        etudiant1.setAdresse(etudiantDto.getAdresse());
        etudiant1.setDate_naiss(etudiantDto.getDate_naiss());
        etudiant1.setGroupe(groupe);
        this.etudiantRepo.save(etudiant1);
        return etudiant1;
    }*/

    public List<Etudiant> getAllStudents() {
        return etudiantRepo.findAll();
    }

    public Etudiant getEtudiantById(Long id) {
        Etudiant etudiant = etudiantRepo.findEtudiantById(id);
        return etudiant;
    }

    public Etudiant updateEtudiant(Etudiant user, Long id) {

        Etudiant etudiant = etudiantRepo.findEtudiantById(id);
        etudiant.setPrenom(user.getPrenom());
        etudiant.setNom(user.getNom());
        etudiant.setEmail(user.getEmail());
        etudiant.setPhone(user.getPhone());
        etudiant.setAdresse(user.getAdresse());
        etudiant.setGroupe(user.getGroupe());
        etudiant.setImageUrl(user.getImageUrl());
        etudiantRepo.save(etudiant);
        return etudiant;


    }

    public void supprimerEtudiant(Long id ){
        etudiantRepo.deleteById(id);
    }

    public List<Etudiant> getEtudiantByGroupe (Groupe groupe){
        return this.etudiantRepo.findEtudiantByGroupe(groupe);
    }
}
