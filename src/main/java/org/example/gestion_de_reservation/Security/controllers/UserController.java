package org.example.gestion_de_reservation.Security.controllers;

import lombok.AllArgsConstructor;
import org.example.gestion_de_reservation.Exception.UserCreationException;
import org.example.gestion_de_reservation.Security.dtos.UserDto;
import org.example.gestion_de_reservation.Security.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public ResponseEntity<String> createUser(@RequestParam String nom,
                                             @RequestParam String mail,
                                             @RequestParam String password) {
        try {
            UserDto newUser = userService.saveNewUser(nom,mail,password);
            return ResponseEntity.ok("Utilisateur créé avec succès : le nom :" + newUser.getNom());
        } catch ( UserCreationException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
