package com.example.comptes_service.repositories;

import com.example.comptes_service.entities.Compte;
import com.example.comptes_service.entities.TypeCompte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

// Exposé automatiquement par Spring Data REST sous /rest/comptes
@RepositoryRestResource
public interface CompteRepository extends JpaRepository<Compte, Long> {

    // GET /rest/comptes/search/byType?t=EPARGNE
    @RestResource(path = "/byType")
    List<Compte> findByType(@Param("t") TypeCompte type);
}
