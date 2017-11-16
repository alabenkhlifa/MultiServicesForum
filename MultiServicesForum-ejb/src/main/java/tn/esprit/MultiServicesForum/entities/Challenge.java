package tn.esprit.MultiServicesForum.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name="Challenge")
public class Challenge implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idChallenge;
	private String titre;
	private String description;
	private Integer nbreplaces;
	private Date datedebut;
	private Date datefin;
	@Basic(fetch=FetchType.LAZY)
	@Lob
	private byte[] picture;
	
	@Enumerated(EnumType.STRING)
	private TypeChallenge typeChallenge;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="CategoryId")
	private Categories category;
		
	@OneToMany(mappedBy="challenge")
	private List<Participation> lstParts;
	
	@OneToOne
	private PostChallenge postWinner;
	
	@OneToMany(mappedBy="challenge")
	private List<PostChallenge> lstPosts;
	
		
	public Challenge(int idChallenge, String titre, String description, Date datedebut, Date datefin, int nbreplaces) {
		this.idChallenge = idChallenge;
		this.titre = titre;
		this.description = description;
		this.datedebut = datedebut;
		this.datefin = datefin;
		this.nbreplaces=nbreplaces;
	}
	public Challenge() {
		super();
	}
	
	public Challenge(String titre, String description, Date datedebut, Date datefin,
			Integer challengeIDTobeUpdated) {
		this.titre = titre;
		this.description = description;
		this.datedebut = datedebut;
		this.datefin = datefin;
		this.idChallenge=challengeIDTobeUpdated;
	}
	public Challenge(TypeChallenge typeChallenge,byte[] picture,Categories category ,String titre, String description,Integer nbrplace, Date datedebut, Date datefin) {
		this.typeChallenge=typeChallenge;
		this.picture=picture;
		this.category=category;
		this.titre = titre;
		this.description = description;
		this.nbreplaces=nbrplace;
		this.datedebut = datedebut;
		this.datefin = datefin;
		}
	
	
	public Challenge(Categories category,String titre, String description, Date datedebut, Date datefin,
			Integer challengeIDTobeUpdated, Integer nbrplace) {
		this.category=category;
		this.titre = titre;
		this.description = description;
		this.datedebut = datedebut;
		this.datefin = datefin;
		this.idChallenge=challengeIDTobeUpdated;
		this.nbreplaces=nbrplace;
	}
	
	
	public int getIdChallenge() {
		return idChallenge;
	}
	public void setIdChallenge(int idChallenge) {
		this.idChallenge = idChallenge;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getDatedebut() {
		return datedebut;
	}
	public void setDatedebut(Date datedebut) {
		this.datedebut = datedebut;
	}
	public Date getDatefin() {
		return datefin;
	}
	public void setDatefin(Date datefin) {
		this.datefin = datefin;
	}
	public Categories getCategory() {
		return category;
	}
	public void setCategory(Categories category) {
		this.category = category;
	}
	public int getNbreplaces() {
		return nbreplaces;
	}
	public void setNbreplaces(int nbreplaces) {
		this.nbreplaces = nbreplaces;
	}
	public List<Participation> getLstParts() {
		return lstParts;
	}
	public void setLstParts(List<Participation> lstParts) {
		this.lstParts = lstParts;
	}
	public PostChallenge getPostWinner() {
		return postWinner;
	}
	public void setPostWinner(PostChallenge postWinner) {
		this.postWinner = postWinner;
	}
	public List<PostChallenge> getLstPosts() {
		return lstPosts;
	}
	public void setLstPosts(List<PostChallenge> lstPosts) {
		this.lstPosts = lstPosts;
	}
	public void setNbreplaces(Integer nbreplaces) {
		this.nbreplaces = nbreplaces;
	}
	public byte[] getPicture() {
		return picture;
	}
	public void setPicture(byte[] picture) {
		this.picture = picture;
	}
	public TypeChallenge getTypeChallenge() {
		return typeChallenge;
	}
	public void setTypeChallenge(TypeChallenge typeChallenge) {
		this.typeChallenge = typeChallenge;
	}


	

	

	
	


	
}
