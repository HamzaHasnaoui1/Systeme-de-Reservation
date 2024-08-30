package org.example.gestion_de_reservation.controllers;

import org.example.gestion_de_reservation.dtos.PaiementDto;
import org.example.gestion_de_reservation.services.PaiementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Paiement")
@CrossOrigin("*")
public class PaiementController {
    @Autowired
    private PaiementService paiementService;

    @GetMapping("/listPaiement")
    public List<PaiementDto> listPaiement() {
    return paiementService.getAllPaiements();
    }

    @PostMapping("/addPaiement")
    public PaiementDto addPaiement(@RequestBody PaiementDto paiementDto) {
        return paiementService.addPaiement(paiementDto);
    }

}
