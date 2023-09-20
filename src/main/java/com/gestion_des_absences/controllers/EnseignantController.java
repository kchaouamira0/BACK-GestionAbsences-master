package com.gestion_des_absences.controllers;


import com.gestion_des_absences.dtos.EnseignantDto;
import com.gestion_des_absences.models.Enseignant;
import com.gestion_des_absences.models.Etudiant;
import com.gestion_des_absences.models.Groupe;
import com.gestion_des_absences.models.Matiere;
import com.gestion_des_absences.repos.EnseignantRepo;
import com.gestion_des_absences.repos.GroupeRepo;
import com.gestion_des_absences.services.EnseignantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enseignant")
@CrossOrigin("http://localhost:4200")
public class EnseignantController {

    private EnseignantService enseignantService ;

    public EnseignantController(EnseignantService enseignantService) {
        this.enseignantService = enseignantService;
    }
    @Autowired
    private EnseignantRepo enseignantRepo;
    @Autowired
    private GroupeRepo groupeRepo;
    @GetMapping("/allprofs")
    public List<Enseignant> getAllProfs(){
        return this.enseignantService.getallProfs();
    }

    @GetMapping("/{id}")
    public Enseignant getProfById(@PathVariable  Long id){
        return this.enseignantService.getProfbyId(id);
    }

    @PostMapping("/addprof")
    public Enseignant addProf(@RequestBody Enseignant enseignant){
        return this.enseignantService.addProf(enseignant);
    }

    @PutMapping("/updateprof/{id}")
    public Enseignant updateProf(@RequestBody Enseignant enseignant, @PathVariable Long id){
        return this.enseignantService.updateProf(enseignant,id);
    }

    @DeleteMapping("/deleteprof/{id}")
    public void deleteProf(@PathVariable Long id ){
        this.enseignantService.deleteProf(id);

    }

    @PostMapping("/addprofdto")
    public Enseignant addProfDto(@RequestBody EnseignantDto enseignantDto){
        return this.enseignantService.createEnseignantDto(enseignantDto);
    }




    @GetMapping("/{id}/students")
    public List<Etudiant> getProfStudents(@PathVariable Long id ){
        return this.enseignantService.getListOfStudents(id);
    }

    @PostMapping ("/{enseignantId}/groupes")
    public Enseignant addGroupeToEnseignant(@PathVariable Long enseignantId, @RequestBody Long groupeId) {
        Enseignant enseignant = enseignantRepo.getEnseignantById(enseignantId);
        Groupe groupe = groupeRepo.findGroupeById(groupeId);

        if (enseignant == null || groupe == null) {
            return null;
        }

       List<Matiere> grp_matieres = groupe.getMatieres();

        if (grp_matieres.contains(enseignant.getMatiere())) {
            enseignant.getGroupes().add(groupe);
            enseignantRepo.save(enseignant);
        }



        return enseignant;
    }

    @GetMapping("/{id}/groupes")
    public List<Groupe> getProfGroupes(@PathVariable Long id){
        Enseignant enseignant = enseignantRepo.getEnseignantById(id);
        List<Groupe> profgroupes = enseignant.getGroupes();
        return profgroupes;
    }



    @GetMapping("/{profid}/groupes/{grpid}/students")
    public List<Etudiant> getStudentsByGroup (@PathVariable Long profid,@PathVariable Long grpid ){
        Enseignant enseignant = enseignantRepo.getEnseignantById(profid);
        Groupe groupe = new Groupe();
        List<Groupe> groupes = enseignant.getGroupes();
        for(int i =0 ; i<groupes.size();i++){
            if(groupes.get(i).getId()==grpid){
                groupe = groupes.get(i);
            }
        }
        return groupe.getEtudiants();

    }
    @GetMapping("/{idEns}/groupeposs")
    public List<Groupe>getListGroupeByEnseignant(@PathVariable Long idEns){
        return enseignantService.getListGroupeByEnseignant(idEns);
    }

    @PostMapping("/{idE}/addgrouposs")
    public ResponseEntity<Enseignant>addgroupesToEnseignant(@PathVariable Long idE , @RequestBody List<Long> idGrps){
        return new ResponseEntity<Enseignant>(enseignantService.addGroupesToEnseignant(idE, idGrps),HttpStatus.OK);
    }


}
