package me.ruiz.thierry.film.service;

import me.ruiz.thierry.film.exception.ConflictException;
import me.ruiz.thierry.film.exception.NotFoundException;
import me.ruiz.thierry.film.model.Director;
import me.ruiz.thierry.film.repository.DirectorRepository;
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
public class DirectorServiceImpl implements DirectorService{

    @Autowired
    private DirectorRepository directorRepository;

    /**
     * List of directors
     *
     * @return List<Director>
     */
    @Override
    public List<Director> retrieveDirectors() {
        return (List<Director>) directorRepository.findAll();
    }

    /**
     *
     * @param id
     * @return Director
     */
    @Override
    public Director retrieveDirectorById(Long id) {
        try {
            return directorRepository.findById(id).get();
        } catch (NoSuchElementException ex) {
            throw new NotFoundException(String.format("Not Director with the id [%s] was found in our database !", id));
        }
    }
    /**
     * Create a new Director
     *
     * @param director
     * @return Director
     */
    @Override
    public Director createDirector(Director director) {
        if (directorRepository.findByLastName(director.getLastName()) != null) {
            throw new ConflictException("Another Director with the same name exists !");
        }
        return directorRepository.save(director);
    }

    /**
     * update the Director
     *
     * @param director
     * @param id
     * @return Director
     */
    @Override
    public Director  updateDirector(Director director, long id) {
        try {
            Director result = directorRepository.findById(id).get();
            result.setFirstName(director.getFirstName());
            result.setLastName(director.getLastName());
            result.setImage(director.getImage());
            return directorRepository.save(result);
        } catch (NoSuchElementException ex) {
            throw new NotFoundException(String.format("Not Director with the id [%s] was found in our database !", id));
        }
    }

    /**
     * delete the Actor
     *
     * @param id
     */
    @Override
    public String deleteDirector(Long id) {
        try {
            directorRepository.deleteById(id);
            return "Actor is deleted Successfully";
        }catch (Exception ex) {
            throw new NotFoundException(String.format("Not Director with the id [%s] was found in our database !", id));
        }

    }
}
