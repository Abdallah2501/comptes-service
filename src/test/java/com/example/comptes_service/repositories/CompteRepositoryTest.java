package com.example.comptes_service.repositories;

import com.example.comptes_service.entities.Compte;
import com.example.comptes_service.entities.TypeCompte;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
// Si cet import est en rouge (Spring Boot 4) : Alt+Entrée sur @DataJpaTest pour choisir le bon
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
class CompteRepositoryTest {

    @Autowired
    private CompteRepository repo;

    @Test
    void shouldSaveAndFindByType() {
        repo.deleteAll();
        repo.save(Compte.builder().solde(5000).dateCreation(LocalDate.now()).type(TypeCompte.COURANT).build());
        repo.save(Compte.builder().solde(9000).dateCreation(LocalDate.now()).type(TypeCompte.EPARGNE).build());

        assertEquals(2, repo.findAll().size());
        assertEquals(1, repo.findByType(TypeCompte.EPARGNE).size());
    }
}
