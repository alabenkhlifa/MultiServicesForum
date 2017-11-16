package tn.esprit.MultiServicesForum.entities;

import java.io.Serializable;


import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Participation implements Serializable{
	
	@EmbeddedId
	private ParticipationPk ppk;
	@Enumerated(EnumType.STRING)
	private TypePart typePart;
	
	@ManyToOne
	@JoinColumn(name="idMember", referencedColumnName="id",insertable=false,updatable=false)
	private Member member;
	
	@ManyToOne
	@JoinColumn(name="idChallenge", referencedColumnName="idChallenge",insertable=false,updatable=false)
	private Challenge challenge;
	 

	public Participation() {
		super();
	}
	public ParticipationPk getPpk() {
		return ppk;
	}
	public void setPpk(ParticipationPk ppk) {
		this.ppk = ppk;
	}
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	public Challenge getChallenge() {
		return challenge;
	}
	public void setChallenge(Challenge challenge) {
		this.challenge = challenge;
	}
	public TypePart getTypePart() {
		return typePart;
	}
	public void setTypePart(TypePart typePart) {
		this.typePart = typePart;
	}
	
	
}
