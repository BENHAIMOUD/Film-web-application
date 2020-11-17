package me.ruiz.thierry.film.service;

import me.ruiz.thierry.film.exception.ConflictException;
import me.ruiz.thierry.film.exception.NotFoundException;
import me.ruiz.thierry.film.model.Actor;
import me.ruiz.thierry.film.repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * @author Ayoub BENHAIMOUD.<ayoubbenhaimoud@gmail.com>
 * @created on 18/11/2020.
 */
@Transactional
@Service
public class ActorServiceImpl implements ActorService{

    @Autowired
    private ActorRepository actorRepository;

    /**
     * List of actors
     *
     * @return List<Actor>
     */
    @Override
    public List<Actor> retrieveActors() {
        return (List<Actor>) actorRepository.findAll();
    }

    /**
     *
     * @param id
     * @return Actor
     */
    @Override
    public Actor retrieveActorById(Long id) {
        try {
            return actorRepository.findById(id).get();
        } catch (NoSuchElementException ex) {
            throw new NotFoundException(String.format("Not Actor with the id [%s] was found in our database !", id));
        }
    }
    /**
     * Create a new Actor
     *
     * @param actor
     * @return Actor
     */
    @Override
    public Actor createActor(Actor actor) {
        if (actorRepository.findByLastName(actor.getLastName()) != null) {
            throw new ConflictException("Another Actor with the same name exists !");
        }
        return actorRepository.save(actor);
    }

    /**
     * update the Actor
     *
     * @param actor
     * @param id
     * @return Actor
     */
    @Override
    public Actor  updateActor(Actor actor, long id) {
        try {
            Actor result = actorRepository.findById(id).get();
            result.setFirstName(actor.getFirstName());
            result.setLastName(actor.getLastName());
            result.setImage(actor.getImage());
            return actorRepository.save(result);
        } catch (NoSuchElementException ex) {
            throw new NotFoundException(String.format("Not Actor with the id [%s] was found in our database !", id));
        }
    }

    /**
     * delete the Actor
     *
     * @param id
     */
    @Override
    public String deleteActor(Long id) {
        try {
            actorRepository.deleteById(id);
            return "Actor is deleted Successfully";
        }catch (Exception ex) {
            throw new NotFoundException(String.format("Not Actor with the id [%s] was found in our database !", id));
        }

    }
}
