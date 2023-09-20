package com.gestion_des_absences.controllers;


import com.gestion_des_absences.models.Absence;
import com.gestion_des_absences.models.Etudiant;
import com.gestion_des_absences.models.Matiere;
import com.gestion_des_absences.services.AbsenceService;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/absences")
@CrossOrigin("http://localhost:4200")

public class AbsenceController {
    private AbsenceService absenceService;

    public AbsenceController(AbsenceService absenceService) {
        this.absenceService = absenceService;
    }

    @GetMapping("/allabsences")
    public List<Absence> getAllAbsences(){
        return this.absenceService.getAllAbsences();
    }

    @GetMapping("/{id}")
    public Absence getAbsenceById(@PathVariable Long id ){
        return this.absenceService.findAbsenceById(id);
    }

    @GetMapping("/absencesetud/{etudiantId}/matiere/{matiereId}")
    public Integer getAbsenceByEtudiantAndMatiere(@PathVariable Long etudiantId, @PathVariable Long matiereId){

        return this.absenceService.findAbsenceByEtudiantAndMatiere(etudiantId,matiereId);
    }

    /*@PostMapping("/addabsence")
    public Absence addAbsence(@RequestBody Absence absence){
        return this.absenceService.addAbsence(absence);
    }*/


    @PostMapping("/addabsence")
    public Absence addAbsence(@RequestParam String date , @RequestParam Long etudiantId,@RequestParam Long matId){
        return this.absenceService.addAbsence(date,etudiantId,matId);
    }

    @GetMapping("/etudiant/{id}")
    public List<Absence> getAbsencesEtudiant(@PathVariable Long id){
        return this.absenceService.getAbsenesEtudiant(id);
    }


}
