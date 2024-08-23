package org.example.gestion_de_reservation.Security.services;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.gestion_de_reservation.Exception.UserCreationException;
import org.example.gestion_de_reservation.Security.dtos.UserDto;
import org.example.gestion_de_reservation.Security.entities.User;
import org.example.gestion_de_reservation.Security.mappers.UserMapper;
import org.example.gestion_de_reservation.Security.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
@Transactional
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserMapper userMapper;


    @Override
    public UserDto saveNewUser(String nom, String mail, String password) throws UserCreationException {
        String hashedPWD = passwordEncoder.encode(password);// hasher le mdp

        User user = new User();
        user.setId(Long.valueOf(UUID.randomUUID().toString())); //pour generer un id
        //UUID => genere des chaines de caractere aleatoire qui depend de la date systeme
        user.setNom(nom);
        user.setMail(mail);
        user.setPassword(hashedPWD);
        try {
            User savedUser = userRepository.save(user);
            return userMapper.ToUserDto(savedUser);
        }
        catch (Exception e) {
            throw new UserCreationException("Erreur lors de la création de l'utilisateur : " + e.getMessage());

        }
    }
}
