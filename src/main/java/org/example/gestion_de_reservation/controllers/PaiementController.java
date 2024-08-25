package org.example.gestion_de_reservation.controllers;

import org.example.gestion_de_reservation.dtos.PaiementDto;
import org.example.gestion_de_reservation.services.PaiementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Paiement")
public class PaiementController {
    @Autowired
    private PaiementService paiementService;

    @PostMapping("/addPaiement")
    public PaiementDto addPaiement(@RequestBody PaiementDto paiementDto) {
        return paiementService.addPaiement(paiementDto);
    }

}
