package org.example.gestion_de_reservation.dtos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.gestion_de_reservation.entities.Reservation;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PaiementDto {
    private Long id;
    private Long reservationId;
    private double montant;
    private String description;
}
