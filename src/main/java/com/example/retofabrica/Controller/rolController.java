package com.example.retofabrica.Controller;

import com.example.retofabrica.Entity.rolEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.retofabrica.Business.rolBusiness;
import java.util.List;

@RestController
@RequestMapping("roles")
public class rolController {
    @Autowired
    private rolBusiness rolBusiness;

    @GetMapping
    public List<rolEntity> getAllrol() {
        return rolBusiness.getAllrol();
    }

    @GetMapping("/{id_Rol}")
    public ResponseEntity<rolEntity> getRolById(@PathVariable Long id_Rol) {
        return rolBusiness.getRolById(id_Rol)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public rolEntity createRol(@RequestBody rolEntity rol) {
        return rolBusiness.createRol(rol);
    }

    @PutMapping("/{id_Rol}")
    public ResponseEntity<rolEntity> updateRol(@PathVariable Long id_Rol, @RequestBody rolEntity rolDetails) {
        return ResponseEntity.ok(rolBusiness.updateRol(id_Rol, rolDetails));
    }

    @DeleteMapping("/{id_Rol}")
    public ResponseEntity<Void> deleteRol(@PathVariable Long id_Rol) {
        rolBusiness.deleteRol(id_Rol);
        return ResponseEntity.noContent().build();
    }
}
