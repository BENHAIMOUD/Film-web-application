package me.ruiz.thierry.film.controller;


import me.ruiz.thierry.film.model.Actor;
import me.ruiz.thierry.film.model.Director;
import me.ruiz.thierry.film.service.ActorService;
import me.ruiz.thierry.film.service.DirectorService;
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
@RequestMapping(value = "/api/director")
public class DirectorController {

    private final DirectorService directorService;

    public DirectorController(DirectorService directorService) {
        this.directorService = directorService;
    }

    /**
     * retrieve all Directors
     * @return List<Director>
     */
    @GetMapping(value = {"/", ""})
    public ResponseEntity<List<Director>> getAllDirectors() {
        List <Director> result = directorService.retrieveDirectors();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     *
     * @param id
     * @return Director
     */
    @GetMapping("/{id}")
    public Director getDirectorById(@PathVariable long id) {
        Director result;
        result = directorService.retrieveDirectorById(id);
        return result;
    }

    /**
     *
     * @param director
     * @return Director
     */
    @PostMapping(value = {"/",""})
    public ResponseEntity<Director> createNewDirector(@Valid @RequestBody Director director) {
        Director result = directorService.createDirector(director);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    /**
     *
     * @param director
     * @param id
     * @return Director
     */
    @PutMapping("/{id}")
    public  Director updateDirector(@RequestBody Director director, @PathVariable long id){
        Director result;
        result = directorService.updateDirector(director, id);
        return result;
    }

    /**
     *
     * @param id
     * @return String
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDirector(@PathVariable Long id) {
        String result = directorService.deleteDirector(id);
        return  new ResponseEntity<>(result, HttpStatus.NO_CONTENT);
    }

}
