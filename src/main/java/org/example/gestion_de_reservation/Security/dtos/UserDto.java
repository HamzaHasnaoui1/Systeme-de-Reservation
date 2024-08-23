package org.example.gestion_de_reservation.Security.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

 @NoArgsConstructor @AllArgsConstructor @Data
public class UserDto {
    private Long id;
    private String nom;
    private String mail;

}
