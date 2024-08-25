package org.example.gestion_de_reservation.mappers;

import org.example.gestion_de_reservation.dtos.PaiementDto;
import org.example.gestion_de_reservation.entities.Paiement;
import org.example.gestion_de_reservation.entities.Reservation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface PaiementMapper {

    default PaiementDto ToPaiementDto(Paiement paiement){
        PaiementDto paiementDto = new PaiementDto();
        paiementDto.setId(paiement.getId());
        paiementDto.setDescription(paiement.getDescription());
        paiementDto.setMontant(paiement.getMontant());
        paiementDto.setReservationId(paiement.getReservation().getId());
        return paiementDto;

    }

//    @Mapping(source = "reservationId", target = "reservation")
default Paiement ToPaiementEntity(PaiementDto paiementDto) {
       Paiement paiement = new Paiement();
       paiement.setId(paiementDto.getId());
       paiement.setDescription(paiementDto.getDescription());
       paiement.setMontant(paiementDto.getMontant());
//       paiement.setReservationId(paiementDto.getReservation().getId());
       return paiement;
   }

}
