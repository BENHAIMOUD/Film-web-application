package me.ruiz.thierry.film.service;

import me.ruiz.thierry.film.exception.ConflictException;
import me.ruiz.thierry.film.exception.NotFoundException;
import me.ruiz.thierry.film.model.Actor;
import me.ruiz.thierry.film.model.Film;
import me.ruiz.thierry.film.repository.ActorRepository;
import me.ruiz.thierry.film.repository.FilmRepository;
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
public class FilmServiceImpl implements FilmService{

    @Autowired
    private FilmRepository filmRepository;

    /**
     * List of films
     *
     * @return List<Film>
     */
    @Override
    public List<Film> retrieveFilms() {
        return (List<Film>) filmRepository.findAll();
    }

    /**
     *
     * @param id
     * @return Film
     */
    @Override
    public Film retrieveFilmById(Long id) {
        try {
            return filmRepository.findById(id).get();
        } catch (NoSuchElementException ex) {
            throw new NotFoundException(String.format("Not Film with the id [%s] was found in our database !", id));
        }
    }
    /**
     * Create a new Film
     *
     * @param film
     * @return Film
     */
    @Override
    public Film createFilm(Film film) {
        if (filmRepository.findByTitle(film.getTitle()) != null) {
            throw new ConflictException("Another Actor with the same name exists !");
        }
        return filmRepository.save(film);
    }

    /**
     * update the Film
     *
     * @param film
     * @param id
     * @return Film
     */
    @Override
    public Film  updateFilm(Film film, long id) {
        try {
            Film result = filmRepository.findById(id).get();
            result.setTitle(film.getTitle());
            result.setImage(film.getImage());

            return filmRepository.save(film);
        } catch (NoSuchElementException ex) {
            throw new NotFoundException(String.format("Not Film with the id [%s] was found in our database !", id));
        }
    }

    /**
     * delete the Film
     *
     * @param id
     */
    @Override
    public String deleteFilm(Long id) {
        try {
            filmRepository.deleteById(id);
            return "Film is deleted Successfully";
        }catch (Exception ex) {
            throw new NotFoundException(String.format("Not Film with the id [%s] was found in our database !", id));
        }

    }
}
