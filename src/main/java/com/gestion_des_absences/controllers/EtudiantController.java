package com.gestion_des_absences.controllers;


import com.gestion_des_absences.dtos.EtudiantDto;
import com.gestion_des_absences.models.Etudiant;
import com.gestion_des_absences.models.Groupe;
import com.gestion_des_absences.services.EtudiantService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/etudiant")
@CrossOrigin("http://localhost:4200")
public class EtudiantController {

    private EtudiantService etudiantService;

    public EtudiantController(EtudiantService etudiantService) {
        this.etudiantService = etudiantService;
    }


    // Creation d'un etudiant
    @PostMapping("/signup")
    public Etudiant addStudent(@RequestBody Etudiant etudiant) {
        return etudiantService.saveStudent(etudiant);
    }

    // affichage des etudiants
    @GetMapping("/allstudents")
    public List<Etudiant> getStudents() {
        return etudiantService.getAllStudents();
    }

    //affichage etudiant by ID
    @GetMapping("/{id}")
    public Etudiant studentByid (@PathVariable  Long id){
        return etudiantService.getEtudiantById(id);
    }

    // update etudiant
    @PutMapping("/update/{id}")
    public Etudiant updateStudent(@RequestBody Etudiant etudiant, @PathVariable Long id ){
        return etudiantService.updateEtudiant(etudiant,id);
    }

    //suppression etudiant by id
    @DeleteMapping("/delete/{id}")
    public void deleteStudent(@PathVariable Long id){
        etudiantService.supprimerEtudiant(id);

    }

    @GetMapping("/etudiantgrp")
    public List<Etudiant> getStudentByGrp(@RequestParam Long id){
        Groupe groupe=new Groupe();
        groupe.setId(id);

        return this.etudiantService.getEtudiantByGroupe(groupe);
    }


}


