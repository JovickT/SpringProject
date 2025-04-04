package com.example.mySpring.services;

import com.example.mySpring.entities.Actor;
import com.example.mySpring.repositories.ActorRepository;
import com.example.mySpring.services.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorServiceImpl implements ActorService {

    @Autowired
    private ActorRepository actorRepository;

    @Override
    public List<Actor> findAll() {
        return actorRepository.findAll();
    }

    @Override
    public Actor findById(Integer id) {
        return actorRepository.findById(id).orElse(null);
    }

    @Override
    public Actor save(Actor actor) {
        return actorRepository.save(actor);
    }

    @Override
    public void delete(Integer id) {
        actorRepository.deleteById(id);
    }
}
