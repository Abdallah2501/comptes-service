package com.example.comptes_service.service;

import com.example.comptes_service.dto.CompteRequestDTO;
import com.example.comptes_service.dto.CompteResponseDTO;

import java.util.List;

public interface CompteService {
    CompteResponseDTO addCompte(CompteRequestDTO dto);
    CompteResponseDTO updateCompte(Long id, CompteRequestDTO dto);
    CompteResponseDTO getCompte(Long id);
    List<CompteResponseDTO> listComptes();
    void deleteCompte(Long id);
}
