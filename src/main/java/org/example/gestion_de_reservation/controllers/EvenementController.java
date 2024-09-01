package org.example.gestion_de_reservation.controllers;

import org.example.gestion_de_reservation.dtos.EvenementDto;
import org.example.gestion_de_reservation.services.EvenementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Evenement")
@CrossOrigin("*")
public class EvenementController {
    @Autowired
    private EvenementService evenementService;


    @PostMapping("/addEvent")
    public EvenementDto addEvents(@RequestBody EvenementDto evenementDto) {
    return evenementService.addEvenement(evenementDto);
    }

    @PutMapping("/updateEvent/{id}")
    public EvenementDto updateEvent (@PathVariable Long id, @RequestBody EvenementDto evenementDto) {
        return evenementService.updateEvenement(id, evenementDto);
    }

    @DeleteMapping("/deleteEvent/{id}")
    public void deleteEvent (@PathVariable Long id) {
        evenementService.deleteEvenement(id);
    }

    @GetMapping("/eventsList")
    public List<EvenementDto> listEvenements() {
        return evenementService.listEvenement();
    }

    @GetMapping("/getEvenementById/{id}")
    public EvenementDto getEvenementById(@PathVariable Long id) {
        return evenementService.getEvenementById(id);
    }
}
