package tn.esprit.MultiServicesForum.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class ParticipationPk implements Serializable{

	
	private int idMember;
	private int idChallenge;
	
	public int getIdMember() {
		return idMember;
	}
	public void setIdMember(int idMember) {
		this.idMember = idMember;
	}
	public int getIdChallenge() {
		return idChallenge;
	}
	public void setIdChallenge(int idChallenge) {
		this.idChallenge = idChallenge;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idChallenge;
		result = prime * result + idMember;
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
		ParticipationPk other = (ParticipationPk) obj;
		if (idChallenge != other.idChallenge)
			return false;
		if (idMember != other.idMember)
			return false;
		return true;
	}
	
	
	
	
	
}
