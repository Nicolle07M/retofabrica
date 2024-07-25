package com.example.retofabrica.Business;

import com.example.retofabrica.Entity.rolEntity;
import com.example.retofabrica.Exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.retofabrica.Repository.rolRepository;

import java.util.List;
import java.util.Optional;

@Service
public class rolBusiness {

    @Autowired
    private rolRepository rolRepository;

    //get all rol
    public List<rolEntity> getAllrol(){
        return rolRepository.findAll();
    }


    //rol by id
    public Optional<rolEntity> getRolById(Long id){
        return rolRepository.findById(id);
    }

    //create
    public rolEntity createRol(rolEntity rol){
        return rolRepository.save(rol);
    }

    //update
    public rolEntity updateRol(Long id, rolEntity rolDetails) {
        return rolRepository.findById(id)
                .map(existingRol -> {
                    existingRol.setRolType(rolDetails.getRolType());
                    return rolRepository.save(existingRol);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Rol not found with id " + id));
    }

    //delete
    public void deleteRol(Long id){
        rolRepository.deleteById(id);
    }
}