package org.example.gestion_de_reservation.controllers;

import org.example.gestion_de_reservation.Security.entities.User;
import org.example.gestion_de_reservation.dtos.EvenementDto;
import org.example.gestion_de_reservation.dtos.ReservationDto;
import org.example.gestion_de_reservation.entities.Evenement;
import org.example.gestion_de_reservation.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Reservation")
public class ReservationController {
    @Autowired
    private ReservationService reservationService;

    @PostMapping("/addReservation")
    public ReservationDto addReservation(@RequestBody ReservationDto reservationDto) {
        return reservationService.addReservation(reservationDto);
    }

    @PutMapping("/updateReserv/{id}")
    public ReservationDto updateReserv (@PathVariable Long id, @RequestBody ReservationDto reservationDto) {
        return reservationService.updateReservation(id, reservationDto);
    }

    @DeleteMapping("/deleteReservation/{id}")
    public void deleteReservation(@PathVariable Long id) {
        reservationService.annulerReservation(id);
    }

    @GetMapping("/reservationList")
    public List<ReservationDto> getReservationList() {
        return reservationService.getAllReservations();
    }
}
