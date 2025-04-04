package com.example.mySpring.services;

import com.example.mySpring.entities.Film;
import com.example.mySpring.repositories.FilmRepository;
import com.example.mySpring.services.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmServiceImpl implements FilmService {

    @Autowired
    private FilmRepository filmRepository;

    @Override
    public List<Film> findAll() {
        return filmRepository.findAll();
    }

    @Override
    public Film findById(Integer id) {
        return filmRepository.findById(id).orElse(null);
    }

    @Override
    public Film save(Film film) {
        return filmRepository.save(film);
    }

    @Override
    public void delete(Integer id) {
        filmRepository.deleteById(id);
    }
}
