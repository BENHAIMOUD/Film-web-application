package me.ruiz.thierry.film.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

/**
 * @author Ayoub BENHAIMOUD.<ayoubbenhaimoud@gmail.com>
 * @updated on 17/11/2020.
 */
@Entity
@Table(name = "actor")
public class Actor implements Person , Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private long idActor ;

	@NotBlank
	@Column(name = "first_name")
	private String firstName ;

	@NotBlank
	@Column(name = "last_name")
	private String lastName ;

	@Column(name = "image")
	private String image;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "actors")
	private Set<Film> films = new HashSet<>();


	//Constructors
	public Actor() {}

	public Actor(@NotBlank String firstName, @NotBlank String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	//Setters & Getters
	public long getIdActor() {
		return idActor;
	}
	public Set<Film> getFilms() {
		return films;
	}
	@Override
	public String getFirstName() {
		return firstName;
	}
	@Override
	public String getLastName() {
		return lastName;
	}
	@Override
	public String getImage() {
		return image;
	}
	@Override
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	@Override
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	@Override
	public void setImage(String image) {
		this.image = image;
	}
	public void setIdActor(long idActor) {
		this.idActor = idActor;
	}
	public void setFilms(Set<Film> films) {
		this.films = films;
	}
}
