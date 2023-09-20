package com.gestion_des_absences.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Etudiant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String nom ;
    private String prenom ;
    private String email ;
    private String adresse ;
    private String phone ;
    private String date_naiss ;
    private String password ;
    private String imageUrl ;
    @ManyToOne
    private Groupe groupe ;
    @OneToMany(cascade=CascadeType.REMOVE,mappedBy = "etudiant",fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Absence> absences;


}
