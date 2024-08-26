package org.example.gestion_de_reservation.mappers;

import org.example.gestion_de_reservation.dtos.EvenementDto;
import org.example.gestion_de_reservation.entities.Evenement;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EvenementMapper {
    @Mapping(source = "nom" , target = "nom")
    EvenementDto ToEvenementDto(Evenement evenement);/*{
        EvenementDto evenementDto = new EvenementDto();
        evenementDto.setId(evenement.getId());
        evenementDto.setNom(evenement.getNom());
        evenementDto.setLieu(evenement.getLieu());
        evenementDto.setDate(evenement.getDate());
        evenementDto.setNbPlace(evenement.getNbPlace());
        return evenementDto;
    }*/
     Evenement ToEvenementEntity(EvenementDto evenementDto);/*{
       Evenement evenement = new Evenement();
       evenement.setId(evenementDto.getId());
       evenement.setNom(evenementDto.getNom());
       evenement.setLieu(evenementDto.getLieu());
       evenement.setDate(evenementDto.getDate());
       evenement.setNbPlace(evenementDto.getNbPlace());
       return evenement;*/


    List<EvenementDto> ToEvenementDtoList(List<Evenement> evenements);

}
