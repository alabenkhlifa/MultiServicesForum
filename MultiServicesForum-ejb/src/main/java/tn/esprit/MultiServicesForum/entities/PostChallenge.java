package tn.esprit.MultiServicesForum.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;




	@Entity
	public class PostChallenge implements Serializable {
		
	
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private int idPost;
		private String description;
		@Basic(fetch=FetchType.LAZY)
		@Lob
		private byte[] picture;
		private Date datePub;
		@ManyToOne
		@JoinColumn(name="idChallenge")
		private Challenge challenge;
		
		@OneToOne(mappedBy="postWinner")
		private Challenge challengeWinned;
		
	
	
		public PostChallenge() {
			super();
		}
		public PostChallenge( String description, Date datePub) {
			
			this.description=description;
			this.datePub = datePub;
		}
		
		public PostChallenge(byte[] picture, String description, Date datePub) {
			this.picture=picture;
			this.description=description;
			this.datePub = datePub;
		}
		public PostChallenge(byte[] picture, String description, Date datePub, Integer idPostToBeUpdated) {
			this.picture=picture;
			this.description=description;
			this.datePub = datePub;
			this.idPost=idPostToBeUpdated;
		}
		public int getIdPost() {
			return idPost;
		}
		public void setIdPost(int idPost) {
			this.idPost = idPost;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public Date getDatePub() {
			return datePub;
		}
		public void setDatePub(Date datePub) {
			this.datePub = datePub;
		}
		public Challenge getChallenge() {
			return challenge;
		}
		public void setChallenge(Challenge challenge) {
			this.challenge = challenge;
		}
		public Challenge getChallengeWinned() {
			return challengeWinned;
		}
		public void setChallengeWinned(Challenge challengeWinned) {
			this.challengeWinned = challengeWinned;
		}
		public byte[] getPicture() {
			return picture;
		}
		public void setPicture(byte[] picture) {
			this.picture = picture;
		}
	

		
}
