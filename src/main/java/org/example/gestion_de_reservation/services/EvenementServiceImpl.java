package org.example.gestion_de_reservation.services;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.example.gestion_de_reservation.dtos.EvenementDto;
import org.example.gestion_de_reservation.entities.Evenement;
import org.example.gestion_de_reservation.mappers.EvenementMapper;
import org.example.gestion_de_reservation.repositories.EvenementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class EvenementServiceImpl implements EvenementService{
    @Autowired
    private EvenementRepository evenementRepository;
    @Autowired
    private EvenementMapper evenementMapper;

    @Override
    public EvenementDto addEvenement(EvenementDto evenementDto) {
        Evenement evenement=evenementMapper.ToEvenementEntity(evenementDto);
        Evenement savedEvenement=evenementRepository.save(evenement);
        return evenementMapper.ToEvenementDto(savedEvenement);
    }

    @Override
    public EvenementDto updateEvenement(Long id, EvenementDto evenementDto) {
        Evenement evenement=evenementRepository.findById(id).orElseThrow();
        evenement.setNom(evenementDto.getNom());
        evenement.setDate(evenementDto.getDate());
        evenement.setLieu(evenementDto.getLieu());
        evenement.setNbPlace(evenementDto.getNbPlace());
        Evenement updatedEvenement=evenementRepository.save(evenement);
        return evenementMapper.ToEvenementDto(updatedEvenement);
    }

    @Override
    public void deleteEvenement(Long id) {
        evenementRepository.deleteById(id);
    }

    @Override
    public List<EvenementDto> listEvenement() {
        List<Evenement> evenements=evenementRepository.findAll();
        return evenementMapper.ToEvenementDtoList(evenements);
    }

    @Override
    public EvenementDto getEvenementById(Long id) {
        Evenement evenement=evenementRepository.findById(id).orElseThrow();
        return evenementMapper.ToEvenementDto(evenement);
    }

    @Override
    public List<EvenementDto> searchEvents(String keyword) {
        List<Evenement> evenements=evenementRepository.searchEvenement(keyword);
        return evenements.stream().map(event -> evenementMapper.ToEvenementDto(event)).collect(Collectors.toList());
    }

    @Override
    public List<Evenement> getEvents(int page, int size) {
  Pageable pageable= PageRequest.of(page, size);
        return evenementRepository.findAllByOrderByIdAsc( pageable);
    }
}
