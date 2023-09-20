package com.gestion_des_absences.models;


import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Absence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String date_abs ;
    @ManyToOne
    private Etudiant etudiant ;
    @ManyToOne
    private Matiere matiere ;

}
