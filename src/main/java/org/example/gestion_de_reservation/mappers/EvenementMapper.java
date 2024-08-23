package org.example.gestion_de_reservation.mappers;

import org.example.gestion_de_reservation.dtos.EvenementDto;
import org.example.gestion_de_reservation.entities.Evenement;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EvenementMapper {
    EvenementDto ToEvenementDto(Evenement evenement);
    Evenement ToEvenementEntity(EvenementDto evenementDto);
    List<EvenementDto> ToEvenementDtoList(List<Evenement> evenements);

}
