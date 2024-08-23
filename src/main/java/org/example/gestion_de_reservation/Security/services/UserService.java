package org.example.gestion_de_reservation.Security.services;

import org.example.gestion_de_reservation.Exception.UserCreationException;
import org.example.gestion_de_reservation.Security.dtos.UserDto;

public interface UserService {
    UserDto saveNewUser(String nom, String mail, String password) throws UserCreationException;
}
