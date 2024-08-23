package org.example.gestion_de_reservation.Security.mappers;

import org.example.gestion_de_reservation.Security.dtos.UserDto;
import org.example.gestion_de_reservation.Security.entities.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto ToUserDto(User user);
    User ToUserEntity(UserDto userDto);
}
