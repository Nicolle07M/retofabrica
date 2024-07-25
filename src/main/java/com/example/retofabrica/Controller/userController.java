package com.example.retofabrica.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.retofabrica.Repository.userRepository;
import com.example.retofabrica.Business.userBusiness;
import com.example.retofabrica.Entity.userEntity;

import java.util.List;


@RestController
@RequestMapping("users")
public class userController {

    @Autowired
    private userBusiness userBusiness;

    @GetMapping
    public List<userEntity> getAllUser(){
        return userBusiness.getAllUser();
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
    public ResponseEntity<userEntity>updateUser(@PathVariable Long id , @RequestBody userEntity userDetails){
        return ResponseEntity.ok(userBusiness.updateUser(id, userDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void>deleteUser(@PathVariable Long id){
        userBusiness.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
