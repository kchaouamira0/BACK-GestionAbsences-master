package com.gestion_des_absences.dtos;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EtudiantDto {

    private String nom ;
    private String prenom ;
    private String email ;
    private String adresse ;
    private String phone ;
    private String date_naiss ;
    private String password ;
    private String imageUrl ;
    private Long idg;
}
