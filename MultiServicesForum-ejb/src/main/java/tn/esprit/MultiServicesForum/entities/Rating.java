package tn.esprit.MultiServicesForum.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Rating implements Serializable {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idRating;
	private int rating;

	
	
	public Rating(int rating) {
		super();
		this.rating = rating;
	}

	public Rating() {
		super();
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public int getIdRating() {
		return idRating;
	}

	public void setIdRating(int idRating) {
		this.idRating = idRating;
	}
	
	
	
}
