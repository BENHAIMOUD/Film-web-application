package me.ruiz.thierry.film.service;

import me.ruiz.thierry.film.model.Film;

import java.util.List;

/**
 * @author Ayoub BENHAIMOUD.<ayoubbenhaimoud@gmail.com>
 * @created on 18/11/2020.
 */
public interface FilmService {
    //methods
    List<Film> retrieveFilms();
    Film retrieveFilmById(Long id);
    Film createFilm(Film film);
    Film updateFilm(Film film,  long id);
    String deleteFilm(Long id);
}
