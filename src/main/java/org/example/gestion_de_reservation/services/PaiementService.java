package org.example.gestion_de_reservation.services;

import org.example.gestion_de_reservation.dtos.PaiementDto;

public interface PaiementService {
  PaiementDto addPaiement(PaiementDto paiementDto);
}
