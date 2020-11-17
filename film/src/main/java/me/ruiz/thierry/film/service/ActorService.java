package me.ruiz.thierry.film.service;

import me.ruiz.thierry.film.model.Actor;

import java.util.List;

/**
 * @author Ayoub BENHAIMOUD.<ayoubbenhaimoud@gmail.com>
 * @created on 18/11/2020.
 */
public interface ActorService {
    //methods
    List<Actor> retrieveActors();
    Actor retrieveActorById(Long id);
    Actor createActor(Actor actor);
    Actor updateActor(Actor actor,  long id);
    String deleteActor(Long id);
}
