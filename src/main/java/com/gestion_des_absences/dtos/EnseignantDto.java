package com.gestion_des_absences.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EnseignantDto {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String imageUrl;
    private Long idmatiere ;
}
