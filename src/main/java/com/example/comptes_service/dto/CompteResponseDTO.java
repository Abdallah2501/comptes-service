package com.example.comptes_service.dto;

import com.example.comptes_service.entities.TypeCompte;
import lombok.Data;

import java.time.LocalDate;

@Data
public class CompteResponseDTO {
    private Long id;
    private double solde;
    private LocalDate dateCreation;
    private TypeCompte type;
}
