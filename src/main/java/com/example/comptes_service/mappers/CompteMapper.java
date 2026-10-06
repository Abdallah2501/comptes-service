package com.example.comptes_service.mappers;

import com.example.comptes_service.dto.CompteRequestDTO;
import com.example.comptes_service.dto.CompteResponseDTO;
import com.example.comptes_service.entities.Compte;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class CompteMapper {

    public Compte toEntity(CompteRequestDTO dto) {
        Compte compte = new Compte();
        BeanUtils.copyProperties(dto, compte);
        return compte;
    }

    public CompteResponseDTO toDTO(Compte compte) {
        CompteResponseDTO dto = new CompteResponseDTO();
        BeanUtils.copyProperties(compte, dto);
        return dto;
    }
}
