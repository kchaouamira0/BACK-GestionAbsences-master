package com.gestion_des_absences.controllers;


import com.gestion_des_absences.models.Matiere;
import com.gestion_des_absences.services.MatiereService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/matiere")
@CrossOrigin("http://localhost:4200")
public class MatiereController {
    private MatiereService matiereService ;

    public MatiereController(MatiereService matiereService) {
        this.matiereService = matiereService;
    }

    @GetMapping("/allsubjects")
    public List<Matiere> getAllSubjects (){
        return this.matiereService.getAllSubjects();
    }

    @PostMapping("/addsubject")
    public Matiere addSubject(@RequestBody Matiere matiere){
        return this.matiereService.addSubject(matiere);

    }

    @PutMapping("/updatesubject/{id}")
    public Matiere updateSubject(@RequestBody Matiere matiere,@PathVariable Long id){
        return this.matiereService.updateSubject(matiere,id);
    }

    @GetMapping("/subjectbyid/{id}")
    public Matiere getSubjectById (@PathVariable Long id){
        return this.matiereService.getSubjectById(id);
    }

    @DeleteMapping("/deletesubject/{id}")
    public void deleteSubject (@PathVariable  Long id){
        this.matiereService.deleteSubject(id);
    }
    }
