package com.example.comptes_service.entities;

import org.springframework.data.rest.core.config.Projection;

// GET /rest/comptes?projection=mobile
@Projection(name = "mobile", types = Compte.class)
public interface CompteProjection1 {
    Long getId();
    double getSolde();
}
