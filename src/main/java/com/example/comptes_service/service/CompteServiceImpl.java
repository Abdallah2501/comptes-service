package com.example.comptes_service.service;

import com.example.comptes_service.dto.CompteRequestDTO;
import com.example.comptes_service.dto.CompteResponseDTO;
import com.example.comptes_service.entities.Compte;
import com.example.comptes_service.mappers.CompteMapper;
import com.example.comptes_service.repositories.CompteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CompteServiceImpl implements CompteService {

    private final CompteRepository repo;
    private final CompteMapper mapper;

    @Override
    public CompteResponseDTO addCompte(CompteRequestDTO dto) {
        Compte compte = mapper.toEntity(dto);
        compte.setDateCreation(LocalDate.now());
        return mapper.toDTO(repo.save(compte));
    }

    @Override
    public CompteResponseDTO updateCompte(Long id, CompteRequestDTO dto) {
        Compte compte = find(id);
        compte.setSolde(dto.getSolde());
        compte.setType(dto.getType());
        return mapper.toDTO(repo.save(compte));
    }

    @Override
    @Transactional(readOnly = true)
    public CompteResponseDTO getCompte(Long id) {
        return mapper.toDTO(find(id));
    }

    @Override
    @Transactional(readOnly = true)
    public List<CompteResponseDTO> listComptes() {
        return repo.findAll().stream().map(mapper::toDTO).toList();
    }

    @Override
    public void deleteCompte(Long id) {
        repo.deleteById(id);
    }

    private Compte find(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Compte " + id + " introuvable"));
    }
}
