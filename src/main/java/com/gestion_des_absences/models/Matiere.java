package com.gestion_des_absences.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Matiere {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String libelle ;
    @ManyToMany(mappedBy = "matieres")
    @JsonIgnore
    private List<Groupe> groupe = new ArrayList<>();
    @OneToMany(mappedBy = "matiere")
    @JsonIgnore
    private List<Enseignant> enseignants;
    @OneToMany(mappedBy = "matiere")
    @JsonIgnore
    private List<Absence> absences ;


}

