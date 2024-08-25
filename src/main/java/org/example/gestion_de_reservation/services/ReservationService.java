package org.example.gestion_de_reservation.services;

import org.example.gestion_de_reservation.dtos.ReservationDto;
import org.example.gestion_de_reservation.entities.Reservation;

import java.util.List;

public interface ReservationService {


    ReservationDto addReservation(ReservationDto reservationDTO);


    void annulerReservation(Long id);

    List<ReservationDto> getAllReservations();
}
