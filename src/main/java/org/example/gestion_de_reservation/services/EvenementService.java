package org.example.gestion_de_reservation.services;

import org.example.gestion_de_reservation.dtos.EvenementDto;

import java.util.List;

public interface EvenementService {
    EvenementDto addEvenement(EvenementDto evenementDto);

    EvenementDto updateEvenement(Long id, EvenementDto evenementDto);

    void deleteEvenement(Long id);

    List<EvenementDto> listEvenement();
}
