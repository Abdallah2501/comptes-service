package com.example.comptes_service.dto;

import com.example.comptes_service.entities.TypeCompte;
import lombok.Data;

@Data
public class CompteRequestDTO {
    private double solde;
    private TypeCompte type;
}
