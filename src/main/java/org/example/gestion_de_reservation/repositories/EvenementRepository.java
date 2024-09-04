package org.example.gestion_de_reservation.repositories;

import org.example.gestion_de_reservation.dtos.EvenementDto;
import org.example.gestion_de_reservation.entities.Evenement;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EvenementRepository extends JpaRepository<Evenement, Long> {
    @Query("select e from Evenement e where e.nom like :kw")
    List<Evenement> searchEvenement(@Param("kw") String keyword);

    List<Evenement> findAllByOrderByIdAsc(Pageable pageable);


}
