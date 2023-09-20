package com.gestion_des_absences.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.annotation.Nullable;
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
public class Groupe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long  id ;
    @Enumerated( EnumType.STRING)
    private ListGrp nom_grp ;
    @OneToMany(mappedBy = "groupe")
    @JsonIgnore
    private List<Etudiant> etudiants  ;
    @ManyToMany(mappedBy = "groupes")
    @JsonIgnore
    private List<Enseignant>enseignants ;
    @ManyToMany

    private List<Matiere> matieres = new ArrayList<>();


}
