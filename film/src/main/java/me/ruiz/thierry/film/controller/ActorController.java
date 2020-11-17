package me.ruiz.thierry.film.controller;


import me.ruiz.thierry.film.model.Actor;
import me.ruiz.thierry.film.service.ActorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author Ayoub BENHAIMOUD.<ayoubbenhaimoud@gmail.com>
 * @created on 18/11/2020.
 */

@RestController
@RequestMapping(value = "/api/actor")
public class ActorController {

    private final ActorService actorService;

    public ActorController(ActorService actorService) {
        this.actorService = actorService;
    }

    /**
     *
     * @return
     */
    @GetMapping(value = {"/", ""})
    public ResponseEntity<List<Actor>> getAllActors() {
        List <Actor> result = actorService.retrieveActors();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Actor getActorById(@PathVariable long id) {
        Actor result;
        result = actorService.retrieveActorById(id);
        return result;
    }

    /**
     *
     * @param actor
     * @return Actor
     */
    @PostMapping(value = {"/",""})
    public ResponseEntity<Actor> createNewActor(@Valid @RequestBody Actor actor) {
        Actor result = actorService.createActor(actor);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    /**
     *
     * @param actor
     * @param id
     * @return Actor
     */
    @PutMapping("/{id}")
    public  Actor updateActor(@RequestBody Actor actor, @PathVariable long id){
        Actor result;
        result = actorService.updateActor(actor, id);
        return result;
    }

    /**
     *
     * @param id
     * @return String
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteActor(@PathVariable Long id) {
        String result = actorService.deleteActor(id);
        return  new ResponseEntity<>(result, HttpStatus.NO_CONTENT);
    }

}
