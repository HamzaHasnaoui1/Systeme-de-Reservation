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
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

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


        User user = userRepository.findById(reservationDto.getUserId())
                .orElseThrow(() -> new UserNotFoundException("Utilisateur non trouvé"));

        Evenement evenement = evenementRepository.findById(reservationDto.getEvenementId())
                .orElseThrow(() -> new EvenementNotFoundException("Événement non trouvé"));

        Reservation reservation = reservationMapper.ToReservationEntity(reservationDto);

        Reservation savedReservation = reservationRepository.save(reservation);

       return reservationMapper.ToReservationDto(savedReservation);
    }

    @Override
    public ReservationDto updateReservation(Long id ,ReservationDto reservationDto ) {
        Reservation reservation = reservationRepository.findById(id).orElseThrow();
        reservation.setNbPlaceReserves(reservationDto.getNbPlaceReserves());
        Reservation updatedReservation = reservationRepository.save(reservation);
        return reservationMapper.ToReservationDto(updatedReservation);
    }

    @Override
    public void annulerReservation(Long id) {
        Reservation reservation = reservationRepository.findById(id).orElseThrow();
        reservation.getEvenement().setNbPlace(reservation.getEvenement().getNbPlace() + reservation.getNbPlaceReserves());
        reservationRepository.delete(reservation);
    }

    @Override
    public List<ReservationDto> getAllReservations() {
        List<Reservation> reservations = reservationRepository.findAll();
        return reservationMapper.ToReservationDtoList(reservations);
    }

    @Override
    public ReservationDto getReservationById(Long id) {
        Reservation reservation=reservationRepository.findById(id).orElseThrow();
        return reservationMapper.ToReservationDto(reservation);
    }

    @Override
    public List<Reservation> getReservations(int page, int size) {
        Pageable pageable= PageRequest.of(page, size);
        return reservationRepository.findAllByOrderByIdAsc( pageable);
    }
}
