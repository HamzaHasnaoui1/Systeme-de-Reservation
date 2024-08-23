package org.example.gestion_de_reservation.services;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.example.gestion_de_reservation.Exception.EvenementNotFoundException;
import org.example.gestion_de_reservation.Exception.UserNotFoundException;
import org.example.gestion_de_reservation.Security.entities.User;
import org.example.gestion_de_reservation.Security.repositories.UserRepository;
import org.example.gestion_de_reservation.dtos.ReservationDto;
import org.example.gestion_de_reservation.entities.Evenement;
import org.example.gestion_de_reservation.entities.Reservation;
import org.example.gestion_de_reservation.mappers.ReservationMapper;
import org.example.gestion_de_reservation.repositories.EvenementRepository;
import org.example.gestion_de_reservation.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class ReservationServiceImpl implements ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;
    @Autowired
    private ReservationMapper reservationMapper;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private EvenementRepository evenementRepository;


    @Override
    public ReservationDto addReservation(ReservationDto reservationDto) {

        Reservation reservation = reservationMapper.ToReservationEntity(reservationDto);

        User user = userRepository.findById(reservationDto.getUserId())
                .orElseThrow(() -> new UserNotFoundException("Utilisateur non trouvé"));

        Evenement evenement = evenementRepository.findById(reservationDto.getEvenementId())
                .orElseThrow(() -> new EvenementNotFoundException("Événement non trouvé"));


        Reservation savedReservation = reservationRepository.save(reservation);

       return reservationMapper.ToReservationDto(savedReservation);
    }


    @Override
    public void annulerReservation(Long id) {
        Reservation reservation = reservationRepository.findById(id).orElseThrow();
        reservation.getEvenement().setNbPlace(reservation.getEvenement().getNbPlace() + reservation.getNbPlaceReserves());
        reservationRepository.delete(reservation);
    }
}
