package com.example.mySpring.controllers;

import com.example.mySpring.entities.Film;
import com.example.mySpring.services.FilmService;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/films")
public class FilmController {

    private static final Logger log = LoggerFactory.getLogger(FilmController.class);

    @Autowired
    private FilmService filmService;

    // Endpoint pour récupérer tous les films
    @GetMapping("/all")
        @Transactional
    public List<Film> getAllFilms() {
        log.info("Fetching all films");
        return filmService.findAll();
    }

    // Endpoint pour récupérer un film par ID
    @GetMapping("/{id}")
        @Transactional
    public Film getFilmById(@PathVariable Integer id) {
        log.info("Fetching film with id: {}", id);
        return filmService.findById(id);
    }
}
