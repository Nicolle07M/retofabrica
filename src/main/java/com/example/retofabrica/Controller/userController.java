package com.example.retofabrica.Controller;// UserController.java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.retofabrica.Repository.userRepository;
import com.example.retofabrica.Repository.rolRepository; // Asegúrate de que tienes este repositorio
import com.example.retofabrica.Business.userBusiness;
import com.example.retofabrica.Entity.userEntity;
import com.example.retofabrica.Entity.rolEntity;

import java.util.List;

@RestController
@RequestMapping("users")
public class userController {

    @Autowired
    private userBusiness userBusiness;

    @Autowired
    private userRepository userRepository;

    @Autowired
    private rolRepository rolRepository; // Asegúrate de que tienes este repositorio

    @GetMapping
    public List<userEntity> getAllUser(){
        return userBusiness.getAllUser();
    }

    @GetMapping("/employees")
    public List<userEntity> getEmployeesByRole(@RequestParam Long roleId) {
        rolEntity rol = rolRepository.findById(roleId).orElse(null);
        if (rol != null) {
            return userRepository.findByRol(rol);
        }
        return List.of(); // Retorna una lista vacía si el rol no se encuentra
    }

    @GetMapping("/{id}")
    public ResponseEntity<userEntity> getUserById(@PathVariable Long id){
        return userBusiness.getUserById(id)
                .map(ResponseEntity:: ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public userEntity createUser(@RequestBody userEntity user){
        return userBusiness.createUser(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity<userEntity> updateUser(@PathVariable Long id, @RequestBody userEntity userDetails){
        return ResponseEntity.ok(userBusiness.updateUser(id, userDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){
        userBusiness.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
