package org.example.gestion_de_reservation.mappers;

import org.example.gestion_de_reservation.dtos.ReservationDto;
import org.example.gestion_de_reservation.entities.Reservation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface ReservationMapper {
    @Mappings({
            @Mapping(source = "user.id", target = "userId"),
            @Mapping(source = "evenement.id", target = "evenementId")
    })
    ReservationDto ToReservationDto(Reservation reservation);

    @Mappings({
            @Mapping(source = "userId", target = "user.id"),
            @Mapping(source = "evenementId", target = "evenement.id")
    })
    Reservation ToReservationEntity(ReservationDto reservationDto);
}
