package com.example.comptes_service.web;

import com.example.comptes_service.dto.CompteRequestDTO;
import com.example.comptes_service.dto.CompteResponseDTO;
import com.example.comptes_service.service.CompteService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class CompteGraphQLController {

    private final CompteService service;

    @QueryMapping
    public List<CompteResponseDTO> compteList() {
        return service.listComptes();
    }

    @QueryMapping
    public CompteResponseDTO compteById(@Argument Long id) {
        return service.getCompte(id);
    }

    @MutationMapping
    public CompteResponseDTO saveCompte(@Argument CompteRequestDTO compte) {
        return service.addCompte(compte);
    }

    @MutationMapping
    public boolean deleteCompte(@Argument Long id) {
        service.deleteCompte(id);
        return true;
    }
}
