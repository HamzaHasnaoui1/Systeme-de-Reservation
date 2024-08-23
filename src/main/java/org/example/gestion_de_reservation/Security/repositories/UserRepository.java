package org.example.gestion_de_reservation.Security.repositories;

import org.example.gestion_de_reservation.Security.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository  extends JpaRepository<User, Long> {
}
