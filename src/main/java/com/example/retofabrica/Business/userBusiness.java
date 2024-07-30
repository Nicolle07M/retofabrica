package com.example.retofabrica.Business;

import com.example.retofabrica.Entity.userEntity;
import com.example.retofabrica.Entity.rolEntity;
import com.example.retofabrica.Exception.ResourceNotFoundException;
import com.example.retofabrica.Repository.userRepository;
import com.example.retofabrica.Repository.rolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class userBusiness {

    @Autowired
    private userRepository userRepository;

    @Autowired
    private rolRepository rolRepository; // Inyectar el repositorio de rol

    // GetAll
    public List<userEntity> getAllUser() {
        return userRepository.findAll();
    }

    // Get user by ID
    public Optional<userEntity> getUserById(Long id) {
        return userRepository.findById(id);
    }

    // Create new user
    public userEntity createUser(userEntity user) {
        // Asignar un valor predeterminado a 'status' si es null
        if (user.getStatus() == null) {
            user.setStatus(false); // Asumir que false es el valor predeterminado
        }
        return userRepository.save(user);
    }

    // Update user
    public userEntity updateUser(Long id, userEntity userDetails) {
        userEntity existingUser = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        existingUser.setName(userDetails.getName());
        existingUser.setLastName(userDetails.getLastName());
        existingUser.setAddress(userDetails.getAddress());
        existingUser.setPhone(userDetails.getPhone());
        existingUser.setEmail(userDetails.getEmail());
        existingUser.setStatus(userDetails.getStatus());

        // Asume que rolDetails es un objeto con idRol
        rolEntity role = rolRepository.findById(userDetails.getRol().getIdRol())
                .orElseThrow(() -> new ResourceNotFoundException("Role not found"));
        existingUser.setRol(role);

        return userRepository.save(existingUser);
    }


    // Delete user
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
