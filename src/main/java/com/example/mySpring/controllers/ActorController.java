package com.example.mySpring.controllers;

import com.example.mySpring.entities.Actor;
import com.example.mySpring.entities.Film;
import com.example.mySpring.services.ActorService;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/actors")
public class ActorController {

    private static final Logger log = LoggerFactory.getLogger(ActorController.class);

    @Autowired
    private ActorService actorService;

    // Endpoint pour récupérer tous les acteurs
    @GetMapping("/all")
        @Transactional
    public List<Actor> getAllActors() {
        log.info("Fetching all actors");
        return actorService.findAll();
    }

    // Endpoint pour récupérer un acteur par ID
    @GetMapping("/{id}")
        @Transactional
    public Actor getActorById(@PathVariable Integer id) {
        log.info("Fetching actor with id: {}", id);
        return actorService.findById(id);
    }

    // Endpoint pour récupérer les films d'un acteur
    @GetMapping("/{id}/films")
    public List<Film> getFilmsByActor(@PathVariable Integer id) {
        log.info("Fetching films for actor with id: {}", id);
        Actor actor = actorService.findById(id);
        return actor != null ? actor.getFilms() : null; // Liste des films de l'acteur
    }
}
