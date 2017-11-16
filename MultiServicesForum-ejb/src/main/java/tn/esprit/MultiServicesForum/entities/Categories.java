package tn.esprit.MultiServicesForum.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Categories implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="CategoryId")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="Name")
	private String name; 
	
	@Column(name="DispPosition")
	private int dispPostion ;
	
	@Column(name="ReadAuthorisedRoles")
	private String readauthorisedroles;
	@OneToMany(mappedBy="category")
	private List<Challenge> challenges;
	
	@Column(name="Image")
	private String image;

	public Categories() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDispPostion() {
		return dispPostion;
	}

	public void setDispPostion(int dispPostion) {
		this.dispPostion = dispPostion;
	}

	public String getReadauthorisedroles() {
		return readauthorisedroles;
	}

	public void setReadauthorisedroles(String readauthorisedroles) {
		this.readauthorisedroles = readauthorisedroles;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + dispPostion;
		result = prime * result + id;
		result = prime * result + ((image == null) ? 0 : image.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((readauthorisedroles == null) ? 0 : readauthorisedroles.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Categories other = (Categories) obj;
		if (dispPostion != other.dispPostion)
			return false;
		if (id != other.id)
			return false;
		if (image == null) {
			if (other.image != null)
				return false;
		} else if (!image.equals(other.image))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (readauthorisedroles == null) {
			if (other.readauthorisedroles != null)
				return false;
		} else if (!readauthorisedroles.equals(other.readauthorisedroles))
			return false;
		return true;
	}
	
	

}
