package com.example.comptes_service.entities;

import org.springframework.data.rest.core.config.Projection;

// GET /rest/comptes?projection=web
@Projection(name = "web", types = Compte.class)
public interface CompteProjection2 {
    Long getId();
    double getSolde();
    TypeCompte getType();
}
