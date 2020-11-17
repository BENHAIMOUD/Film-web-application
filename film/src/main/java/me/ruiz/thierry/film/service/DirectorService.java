package me.ruiz.thierry.film.service;


import me.ruiz.thierry.film.model.Director;

import java.util.List;

/**
 * @author Ayoub BENHAIMOUD.<ayoubbenhaimoud@gmail.com>
 * @created on 18/11/2020.
 */
public interface DirectorService {
    //methods
    List<Director> retrieveDirectors();
    Director retrieveDirectorById(Long id);
    Director createDirector(Director director);
    Director updateDirector(Director director,  long id);
    String deleteDirector(Long id);
}
