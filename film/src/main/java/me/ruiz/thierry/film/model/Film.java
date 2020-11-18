package me.ruiz.thierry.film.model;




import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

/**
 * @author Ayoub BENHAIMOUD.<ayoubbenhaimoud@gmail.com>
 * @updated on 17/11/2020.
 */
@Entity
@Table(name = "film")
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long idFilm ;

    @NotBlank
    @Column(name = "title")
    private String title;

    @Column(name = "image")
    private String imageFilm;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "film_actor", joinColumns = {@JoinColumn(name = "film_id")},
            inverseJoinColumns = {@JoinColumn(name = "actor_id")})
    private Set<Actor> actors = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "director_actor", joinColumns = {@JoinColumn(name = "film_id")},
            inverseJoinColumns = {@JoinColumn(name = "director_id")})
    private Set<Director> directors = new HashSet<>();

    //Constructors
    public Film() { }

    public Film(@NotBlank String title, Set<Director> directors, Set<Actor> actors) {
        this.title = title;
        this.actors = actors;
        this.directors = directors;
    }
    //Setters & Getters
    public long getIdFilm() {
        return idFilm;
    }

    public Set<Actor> getActors() {
        return actors;
    }
    public Set<Director> getDirectors() {
        return directors;
    }

    public String getTitle() {
        return title;
    }
    public String getImageFilm() {
        return imageFilm;
    }
    public void setIdFilm(long idFilm) {
        this.idFilm = idFilm;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setImageFilm(String imageFilm) {
        this.imageFilm = imageFilm;
    }

    public void setActors(Set<Actor> actors) {
        this.actors = actors;
    }

    public void setDirectors(Set<Director> directors) {
        this.directors = directors;
    }
}
