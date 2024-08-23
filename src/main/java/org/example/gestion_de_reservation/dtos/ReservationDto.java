package org.example.gestion_de_reservation.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.gestion_de_reservation.entities.Evenement;
import org.example.gestion_de_reservation.Security.entities.User;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ReservationDto {
    private Long id;
    private Long userId;
    private Long evenementId;
    private int nbPlaceReserves;
}
