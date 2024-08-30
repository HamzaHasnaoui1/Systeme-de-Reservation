package org.example.gestion_de_reservation.services;

import org.example.gestion_de_reservation.dtos.PaiementDto;

import java.util.List;

public interface PaiementService {
  PaiementDto addPaiement(PaiementDto paiementDto);

  List<PaiementDto> getAllPaiements();
}
