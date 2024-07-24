package com.example.retofabrica.Business;

import com.example.retofabrica.Entity.userEntity;
import com.example.retofabrica.Repository.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        Optional<userEntity> user = userRepository.findById(id);
        if (user.isPresent()) {
            userEntity existingUser = user.get();
            existingUser.setName(userDetails.getName());
            existingUser.setLastName(userDetails.getLastName());
            existingUser.setEmail(userDetails.getEmail());
            existingUser.setPassword(userDetails.getPassword());
            existingUser.setStatus(userDetails.getStatus());
            return userRepository.save(existingUser);
        } else {
            throw new RuntimeException("User not found with id " + id);
        }
    }

    // delete
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }


}
