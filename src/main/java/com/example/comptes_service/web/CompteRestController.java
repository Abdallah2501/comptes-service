package com.example.comptes_service.web;

import com.example.comptes_service.dto.CompteRequestDTO;
import com.example.comptes_service.dto.CompteResponseDTO;
import com.example.comptes_service.service.CompteService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comptes")
@RequiredArgsConstructor
public class CompteRestController {

    private final CompteService service;

    @Operation(summary = "Liste de tous les comptes")
    @GetMapping
    public List<CompteResponseDTO> all() {
        return service.listComptes();
    }

    @Operation(summary = "Un compte par son id")
    @GetMapping("/{id}")
    public CompteResponseDTO byId(@PathVariable Long id) {
        return service.getCompte(id);
    }

    @Operation(summary = "Créer un compte")
    @PostMapping
    public CompteResponseDTO save(@RequestBody CompteRequestDTO dto) {
        return service.addCompte(dto);
    }

    @Operation(summary = "Modifier un compte")
    @PutMapping("/{id}")
    public CompteResponseDTO update(@PathVariable Long id, @RequestBody CompteRequestDTO dto) {
        return service.updateCompte(id, dto);
    }

    @Operation(summary = "Supprimer un compte")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteCompte(id);
    }
}
