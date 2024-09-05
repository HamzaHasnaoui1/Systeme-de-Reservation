package org.example.gestion_de_reservation.services;

import org.example.gestion_de_reservation.Security.entities.User;
import org.example.gestion_de_reservation.dtos.ReservationDto;
import org.example.gestion_de_reservation.entities.Evenement;
import org.example.gestion_de_reservation.entities.Reservation;

import java.util.List;

public interface ReservationService {


    ReservationDto addReservation(ReservationDto reservationDTO);


    ReservationDto updateReservation(Long id, ReservationDto reservationDto);

    void annulerReservation(Long id);

    List<ReservationDto> getAllReservations();

    ReservationDto getReservationById(Long id);

    List<Reservation> getReservations(int page, int size);
}
