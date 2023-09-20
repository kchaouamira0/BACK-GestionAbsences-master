package com.gestion_des_absences.controllers;


import com.gestion_des_absences.models.Groupe;
import com.gestion_des_absences.models.Matiere;
import com.gestion_des_absences.repos.GroupeRepo;
import com.gestion_des_absences.repos.MatiereRepo;
import com.gestion_des_absences.services.GroupeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/groupes")
@CrossOrigin("http://localhost:4200")

public class GroupeController {
    private GroupeService groupeService;
    @Autowired
    private GroupeRepo groupeRepo ;
    @Autowired
    private MatiereRepo matiereRepo;


    public GroupeController(GroupeService groupeService) {
        this.groupeService = groupeService;
    }

    @GetMapping("/{id}")
    public Groupe getGroupeById(@PathVariable Long  id ){
        return this.groupeService.getGroupById(id);
    }

    @GetMapping("/allgroups")
    public List<Groupe> getAllGroups(){
        return this.groupeService.getAllGroups();
    }

    @PostMapping("/addgroup")
    public Groupe addGroup(@RequestBody  Groupe groupe){
        return this.groupeService.addGroup(groupe);
    }

    @PostMapping("/{groupeId}/matieres")
    public Groupe addMatiereToGroupe(@PathVariable Long groupeId, @RequestBody Long idmat) {
        Matiere matiere= matiereRepo.findMatiereById(idmat);
        Groupe groupe = groupeRepo.findGroupeById(groupeId);

        groupe.getMatieres().add(matiere);

        groupeRepo.save(groupe);
        return groupe;


    }

    @GetMapping("/{id}/listmatieres")
    public List<Matiere> listOfSubjectsOfGroup(@PathVariable Long id){
        Groupe groupe = this.groupeRepo.findGroupeById(id);
        return groupe.getMatieres();
    }



}

