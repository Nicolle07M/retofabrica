package com.example.retofabrica.Business;

import com.example.retofabrica.Entity.userEntity;
import com.example.retofabrica.Exception.ResourceNotFoundException;
import com.example.retofabrica.Repository.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.lang.module.ResolutionException;
import java.util.List;
import java.util.Optional;


@Service
public class userBusiness {

    @Autowired
    private userRepository userRepository;

    //GetAll
    public List<userEntity> getAllUser(){
        return userRepository.findAll();
    }

    //Get user by ID
    public Optional<userEntity> getUserById(Long id){
        return userRepository.findById(id);
    }


    //Create new user
    public userEntity createUser(userEntity user) {
        // Asignar un valor predeterminado a 'status' si es null
        if (user.getStatus() == null) {
            user.setStatus(false); // Asumir que false es el valor predeterminado
        }
        return userRepository.save(user);
    }

    //update user
    public userEntity updateUser(Long id, userEntity userDetails) {
        return userRepository.findById(id)
                .map(existingUser -> {
                    existingUser.setName(userDetails.getName());
                    existingUser.setLastName(userDetails.getLastName());
                    existingUser.setAddress(userDetails.getAddress());
                    existingUser.setPhone(userDetails.getPhone());
                    existingUser.setEmail(userDetails.getEmail());
                    existingUser.setStatus(userDetails.getStatus()); // Actualizar el estado
                    return userRepository.save(existingUser);
                })
                .orElseThrow(() -> new RuntimeException("User not found with id " + id));
    }


    // delete
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }


}
