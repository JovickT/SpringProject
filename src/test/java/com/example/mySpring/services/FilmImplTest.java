package com.example.mySpring.services;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FilmServiceImplTest {

    private static final Logger log = LoggerFactory.getLogger(FilmServiceImplTest.class);

    @Autowired
    FilmService service;

    @BeforeEach
    void setUp() {
        log.info("<<<<<<Check Service Injection>>>>>>");
        assertNotNull(service,"Service Film NOT Injected !!");
        log.info("Service Injection Ok : {}\n", (service != null));
    }

    @Test
    @Transactional
    void read() {
        log.info("<<<<<<<read START>>>>>>>");
        var filmId = 1;  // Exemple d'ID de film à lire
        var film = service.findById(filmId);
        log.trace("{}", film);

        // Vérifie si le film existe
        assertNotNull(film, "Film not found!");

        log.info("=========================");
        log.info("Film : {}", film);
        log.info("<<<<<<read STOP >>>>>>");
    }

    @Test
    void readAll() {
        log.info("<<<<<<readAll START>>>>>>");
        var films = service.findAll();

        // Affiche tous les films
        films.forEach(f -> log.info("{}", f));

        log.info("Nbre de films : {}", films.size());
        log.info("<<<<<<readAll STOP >>>>>>");
    }
}
