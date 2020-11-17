package me.ruiz.thierry.film.model;



import java.util.Set;

import javax.persistence.*;

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
    private String title;
    private String image;
//    @ManyToMany(mappedBy = "Actor")
//    Set<Actor> actors;
//
//    @ManyToMany(mappedBy = "Director")
//    Set<Director> directors;

    //Constructors
    public Film() { }

    public Film(String title) {
        this.title = title;
    }
    //Setters & Getters
    public long getIdFilm() {
        return idFilm;
    }
    public String getTitle() {
        return title;
    }
    public String getImage() {
        return image;
    }
    public void setIdFilm(long idFilm) {
        this.idFilm = idFilm;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setImage(String image) {
        this.image = image;
    }
}
