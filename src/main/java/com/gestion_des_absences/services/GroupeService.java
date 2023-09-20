package com.gestion_des_absences.services;


import com.gestion_des_absences.models.Groupe;
import com.gestion_des_absences.repos.GroupeRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupeService {
    private GroupeRepo groupeRepo;

    public GroupeService(GroupeRepo groupeRepo) {
        this.groupeRepo = groupeRepo;
    }

    public Groupe getGroupById (Long id ){
        return this.groupeRepo.findGroupeById(id);
    }
    public List<Groupe> getAllGroups(){
        return this.groupeRepo.findAll();
    }

    public Groupe addGroup(Groupe groupe){
        return this.groupeRepo.save(groupe);
    }
}
