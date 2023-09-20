package com.gestion_des_absences.controllers;


import com.gestion_des_absences.models.Enseignant;
import com.gestion_des_absences.models.Etudiant;
import com.gestion_des_absences.models.LoginRequest;
import com.gestion_des_absences.repos.EnseignantRepo;
import com.gestion_des_absences.repos.EtudiantRepo;
import com.gestion_des_absences.services.EnseignantService;
import com.gestion_des_absences.services.EtudiantService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {
    private EtudiantService etudiantService;
    private EtudiantRepo etudiantRepo;
    private EnseignantService enseignantService;
    private EnseignantRepo enseignantRepo;

    public LoginController(EtudiantService etudiantService, EtudiantRepo etudiantRepo, EnseignantService enseignantService, EnseignantRepo enseignantRepo) {
        this.etudiantService = etudiantService;
        this.etudiantRepo = etudiantRepo;
        this.enseignantService = enseignantService;
        this.enseignantRepo = enseignantRepo;
    }

    @PostMapping("/etudiant")
    public ResponseEntity<Etudiant> loginEtudiant(@RequestBody LoginRequest request) {

        Etudiant etudiant = this.etudiantRepo.findEtudiantByEmail(request.getEmail());
        if (etudiant == null || !etudiant.getPassword().equals(request.getPassword())) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(etudiant);
    }

    @PostMapping("/enseignant")
    public ResponseEntity<Enseignant> loginEnseignant(@RequestBody LoginRequest request) {

        Enseignant enseignant = this.enseignantRepo.findEnseignantByEmail(request.getEmail());
        if (enseignant == null || !enseignant.getPassword().equals(request.getPassword())) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(enseignant);
    }

}

