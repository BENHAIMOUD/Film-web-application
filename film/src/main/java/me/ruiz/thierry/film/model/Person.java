package me.ruiz.thierry.film.model;


import javax.persistence.Column;

/**
 * @author Ayoub BENHAIMOUD.<ayoubbenhaimoud@gmail.com>
 * @updated on 17/11/2020.
 */
public interface Person  {
	//methods
	String getFirstName() ;
	String getLastName() ;
	String getImage() ;

	void setFirstName(String firstName);
	void setLastName(String lastName);
	void setImage(String image);
}
