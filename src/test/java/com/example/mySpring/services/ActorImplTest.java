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
class ActorServiceImplTest {

    private static final Logger log = LoggerFactory.getLogger(ActorServiceImplTest.class);

    @Autowired
    ActorService service;

    @BeforeEach
    void setUp() {
        log.info("<<<<<< Check Service Injection >>>>>>");
        assertNotNull(service, "ActorService not injected!");
    }

    @Test
    @Transactional
    void findById() {
        log.info("<<<<<< findById START >>>>>>");
        var actorId = 1;
        var actor = service.findById(actorId);
        assertNotNull(actor, "Actor not found!");
        log.info("{}", actor);
        log.info("<<<<<< findById STOP >>>>>>");
    }

    @Test
    void findAll() {
        log.info("<<<<<< findAll START >>>>>>");
        var actors = service.findAll();
        assertFalse(actors.isEmpty(), "No actors found!");
        actors.forEach(a -> log.info("{}", a));
        log.info("Total actors: {}", actors.size());
        log.info("<<<<<< findAll STOP >>>>>>");
    }
}
