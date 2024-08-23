package org.example.gestion_de_reservation.mappers;

import org.example.gestion_de_reservation.dtos.PaiementDto;
import org.example.gestion_de_reservation.entities.Paiement;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface PaiementMapper {

    @Mapping(source = "reservation.id", target = "reservationId")
    PaiementDto ToPaiementDto(Paiement paiement);

   @Mapping(source = "reservationId", target = "reservation.id")
    Paiement ToPaiementEntity(PaiementDto paiementDto);
}
