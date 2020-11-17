package me.ruiz.thierry.film.repository;

import me.ruiz.thierry.film.model.Actor;
import me.ruiz.thierry.film.model.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Ayoub BENHAIMOUD.<ayoubbenhaimoud@gmail.com>
 * @created on 18/11/2020.
 */
@Transactional
@Repository
public interface FilmRepository extends JpaRepository<Film, Long> {
    //find Film by it name in our database
     Film findByTitle(String title);
}
