package tn.esprit.MultiServicesForum.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Member implements Serializable {

		
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		
		private int id;
		private String nom;
		private String prenom;
		private String email ;
		private String password;
		@OneToMany(mappedBy="member")
		private List<Participation> lstPart;
		
		
		public Member() {
			super();
		}
	
		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public List<Participation> getLstPart() {
			return lstPart;
		}

		public void setLstPart(List<Participation> lstPart) {
			this.lstPart = lstPart;
		}

		public String getNom() {
			return nom;
		}
		public void setNom(String nom) {
			this.nom = nom;
		}
		public String getPrenom() {
			return prenom;
		}
		public void setPrenom(String prenom) {
			this.prenom = prenom;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public List<Participation> getLstParts() {
			return lstPart;
		}
		public void setLstParts(List<Participation> lstParts) {
			this.lstPart = lstParts;
		}
		
		
		
		
		
}
