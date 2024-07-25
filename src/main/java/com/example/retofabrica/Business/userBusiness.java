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
    public userEntity createUser(userEntity user){
        return userRepository.save(user);
    }


    //update user
    public userEntity updateUser(Long id, userEntity userDetails) {
        userEntity user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + id));
        user.setName(userDetails.getName());
        user.setLastName(userDetails.getLastName());
        user.setEmail(userDetails.getEmail());
        user.setAddress(userDetails.getAddress());
        user.setPhone(userDetails.getPhone());
        user.setPassword(userDetails.getPassword());
        user.setStatus(userDetails.getStatus());

        return userRepository.save(user);

    }

    // delete
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }


}
