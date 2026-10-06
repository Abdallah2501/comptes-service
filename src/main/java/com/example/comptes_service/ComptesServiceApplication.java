package com.example.comptes_service;

import com.example.comptes_service.entities.Compte;
import com.example.comptes_service.entities.TypeCompte;
import com.example.comptes_service.repositories.CompteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class ComptesServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ComptesServiceApplication.class, args);
    }

    // Données de test insérées au démarrage
    @Bean
    CommandLineRunner start(CompteRepository repo) {
        return args -> {
            repo.save(Compte.builder().solde(5000).dateCreation(LocalDate.now()).type(TypeCompte.COURANT).build());
            repo.save(Compte.builder().solde(9000).dateCreation(LocalDate.now()).type(TypeCompte.EPARGNE).build());
            repo.save(Compte.builder().solde(1200).dateCreation(LocalDate.now()).type(TypeCompte.COURANT).build());
        };
    }
}
