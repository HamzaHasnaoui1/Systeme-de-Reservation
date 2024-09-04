package org.example.gestion_de_reservation.services;

import org.example.gestion_de_reservation.dtos.EvenementDto;
import org.example.gestion_de_reservation.entities.Evenement;
import org.springframework.data.domain.Page;

import java.util.List;

public interface EvenementService {
    EvenementDto addEvenement(EvenementDto evenementDto);

    EvenementDto updateEvenement(Long id, EvenementDto evenementDto);

    void deleteEvenement(Long id);

    List<EvenementDto> listEvenement();

    EvenementDto getEvenementById(Long id);

    List<EvenementDto> searchEvents(String keyword);

    List<Evenement> getEvents(int page, int size);
}
