package com.team3.spartan_vet.controller;

import com.team3.spartan_vet.entity.Vet;
import com.team3.spartan_vet.service.VetService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vets")
public class VetController {

    private final VetService vetService;

    public VetController(VetService vetService) {
        this.vetService = vetService;
    }

    @GetMapping
    public List<Vet> getAllVets() {
        return vetService.getAllVets();
    }

    @GetMapping("/{id}")
    public Vet getVetById(@PathVariable Long id) {
        return vetService.getVetById(id);
    }

    @PostMapping
    public Vet createVet(@RequestBody Vet vet) {
        return vetService.createVet(vet);
    }

    @PutMapping("/{id}")
    public Vet updateVet(@PathVariable Long id, @RequestBody Vet vet) {
        return vetService.updateVet(id, vet);
    }

    @DeleteMapping("/{id}")
    public void deleteVet(@PathVariable Long id) {
        vetService.deleteVet(id);
    }
}