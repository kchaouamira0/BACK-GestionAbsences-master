package com.gestion_des_absences.repos;


import com.gestion_des_absences.models.Matiere;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatiereRepo extends JpaRepository<Matiere,Long> {

    Matiere findMatiereById(Long id);
}
