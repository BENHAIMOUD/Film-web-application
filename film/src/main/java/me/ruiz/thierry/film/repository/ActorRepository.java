package me.ruiz.thierry.film.repository;

import me.ruiz.thierry.film.model.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Ayoub BENHAIMOUD.<ayoubbenhaimoud@gmail.com>
 * @created on 18/11/2020.
 */
@Transactional
@Repository
public interface ActorRepository extends JpaRepository<Actor, Long> {
    //find Actor by it name in our database
     Actor findByLastName(String lastName);
}
