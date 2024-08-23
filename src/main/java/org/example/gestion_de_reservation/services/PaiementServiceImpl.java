package org.example.gestion_de_reservation.services;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.example.gestion_de_reservation.Exception.ReservationNotFoundException;
import org.example.gestion_de_reservation.dtos.PaiementDto;
import org.example.gestion_de_reservation.entities.Paiement;
import org.example.gestion_de_reservation.entities.Reservation;
import org.example.gestion_de_reservation.mappers.PaiementMapper;
import org.example.gestion_de_reservation.repositories.PaiementRepository;
import org.example.gestion_de_reservation.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class PaiementServiceImpl implements PaiementService{
    @Autowired
    private PaiementRepository paiementRepository;
    @Autowired
    private PaiementMapper paiementMapper;
    @Autowired
    private ReservationRepository reservationRepository;

    @Override
    public PaiementDto addPaiement(PaiementDto paiementDto) {
        Paiement paiement = paiementMapper.ToPaiementEntity(paiementDto);

        Reservation reservation = reservationRepository.findById(paiementDto.getReservationId())
                .orElseThrow(() -> new ReservationNotFoundException("Réservation non trouvée"));

        paiement.setReservation(reservation);

        Paiement savedPaiement = paiementRepository.save(paiement);

        return paiementMapper.ToPaiementDto(savedPaiement);
    }

}
