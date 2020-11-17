package me.ruiz.thierry.film.controller;

import me.ruiz.thierry.film.model.Film;
import me.ruiz.thierry.film.service.FilmService;
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
@RequestMapping(value = "/api/film")
public class FilmController {

    private final FilmService filmService;

    public FilmController(FilmService filmService) {
        this.filmService = filmService;
    }

    /**
     *
     * @return List<Film>
     */
    @GetMapping(value = {"/", ""})
    public ResponseEntity<List<Film>> getAllFilms() {
        List <Film> result = filmService.retrieveFilms();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     *
     * @param id
     * @return Film
     */
    @GetMapping("/{id}")
    public Film getFilmById(@PathVariable long id) {
        Film result;
        result = filmService.retrieveFilmById(id);
        return result;
    }

    /**
     *
     * @param film
     * @return Film
     */
    @PostMapping(value = {"/",""})
    public ResponseEntity<Film> createNewActor(@Valid @RequestBody Film film) {
        Film result = filmService.createFilm(film);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    /**
     *
     * @param film
     * @param id
     * @return Film
     */
    @PutMapping("/{id}")
    public  Film updateFilm(@RequestBody Film film, @PathVariable long id){
        Film result;
        result = filmService.updateFilm(film, id);
        return result;
    }

    /**
     *
     * @param id
     * @return String
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteFilm(@PathVariable Long id) {
        String result = filmService.deleteFilm(id);
        return  new ResponseEntity<>(result, HttpStatus.NO_CONTENT);
    }

}
