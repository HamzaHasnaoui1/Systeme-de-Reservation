package org.example.gestion_de_reservation.mappers;

import org.example.gestion_de_reservation.Security.entities.User;
import org.example.gestion_de_reservation.dtos.ReservationDto;
import org.example.gestion_de_reservation.entities.Evenement;
import org.example.gestion_de_reservation.entities.Reservation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
public interface ReservationMapper {
    /* @Mappings({
             @Mapping(source = "user.id", target = "userId"),
             @Mapping(source = "evenement.id", target = "evenementId")
     })*/
    default ReservationDto ToReservationDto(Reservation reservation) {
        ReservationDto reservationDto = new ReservationDto();
        reservationDto.setId(reservation.getId());
        reservationDto.setUserId(reservation.getUser().getId());
        reservationDto.setEvenementId(reservation.getEvenement().getId());
        reservationDto.setNbPlaceReserves(reservation.getNbPlaceReserves());
        return reservationDto;
    }

    /*  @Mappings({
              @Mapping(source = "userId", target = "user.id"),
              @Mapping(source = "evenementId", target = "evenement.id")
      })*/
    default Reservation ToReservationEntity(ReservationDto reservationDto, User user, Evenement evenement) {
        Reservation reservation = new Reservation();
        reservation.setId(reservationDto.getId());
        reservation.setUser(user);
        reservation.setEvenement(evenement);
        reservation.setNbPlaceReserves(reservationDto.getNbPlaceReserves());
        return reservation;
    }

    //List<ReservationDto> ToReservationDtoList(List<Reservation> reservations);

    default  List<ReservationDto> ToReservationDtoList(List<Reservation> reservations) {
        List<ReservationDto> dtoList = new ArrayList<>();
        for (Reservation reservation : reservations) {
            ReservationDto dto = new ReservationDto();
            dto.setId(reservation.getId());
           // dto.setUserId(reservation.getUser().getId());
            //dto.setEvenementId(reservation.getEvenement().getId());
            if (reservation.getUser() != null) {
                dto.setUserId(reservation.getUser().getId());
            }

            if (reservation.getEvenement() != null) {
                dto.setEvenementId(reservation.getEvenement().getId());
            }
            dto.setNbPlaceReserves(reservation.getNbPlaceReserves());
            dtoList.add(dto);
        }
        return dtoList;
    }
}