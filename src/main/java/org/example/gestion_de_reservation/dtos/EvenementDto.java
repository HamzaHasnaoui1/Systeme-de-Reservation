package org.example.gestion_de_reservation.dtos;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class EvenementDto {
    private Long id;
    private String nom;
    private String lieu;
    private LocalDate date;
    private int nbPlace;
}
