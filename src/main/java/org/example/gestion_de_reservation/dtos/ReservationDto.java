package org.example.gestion_de_reservation.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ReservationDto {
    private Long id;
    private Long userId;
    private Long evenementId;
    private int nbPlaceReserves;

}
