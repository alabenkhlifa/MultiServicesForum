package tn.esprit.MultiServicesForum.presentation.mbeans;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import org.primefaces.model.UploadedFile;

import tn.esprit.MultiServicesForum.entities.Categories;
import tn.esprit.MultiServicesForum.entities.Category;
import tn.esprit.MultiServicesForum.entities.Challenge;
import tn.esprit.MultiServicesForum.entities.Rating;
import tn.esprit.MultiServicesForum.entities.TypeChallenge;
import tn.esprit.MultiServicesForum.services.CategoriesServiceLocal;
import tn.esprit.MultiServicesForum.services.ChallengesServices;
import tn.esprit.MultiServicesForum.services.ChallengesServicesLocal;




@ManagedBean
@ViewScoped
public class ChallengeBean {

	private List<Challenge> challenges;
	private UploadedFile uploadedFile;
	private List<Categories> categories;
	private Challenge challenge = new Challenge();
	private Integer rating1;
		
		@EJB
		ChallengesServicesLocal chs;
	
		@EJB
		CategoriesServiceLocal cSL;
		
		public Challenge getChallenge() {
			return challenge;
		}

		public void setChallenge(Challenge challenge) {
			this.challenge = challenge;
		}
		
		public void addChallenge(){
//		    byte[] contents = uploadedFile.getContents();
//		    challenge.setPicture(contents);
////			if ( getDatefin().after(getDatedebut()) && (getDatedebut().after(new Date()))){
//			chs.ajouterChallenge(challenge);
//			}
		}
		 
			
		
//		 public StreamedContent getImage(int challengeId) throws IOException {
//		        FacesContext context = FacesContext.getCurrentInstance();
//
//		        if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
//		            // So, we're rendering the view. Return a stub StreamedContent so that it will generate right URL.
//		            return new DefaultStreamedContent();
//		        }
//		        else {
//		            // So, browser is requesting the image. Return a real StreamedContent with the image bytes.
//		            String id = context.getExternalContext().getRequestParameterMap().get("id");
//		           
//		            return new DefaultStreamedContent(new ByteArrayInputStream(getPicture()));
//		        }
//		    }
//		
//		public StreamedContent getProductImage() throws IOException, SQLException {
//			 
//			FacesContext context = FacesContext.getCurrentInstance();
//	 
//			if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
//				return new DefaultStreamedContent();
//			}
//	 
//			else {
//	 
//				String id = context.getExternalContext().getRequestParameterMap()
//						.get("pid");
//	 
//				byte[] image = new ProductImageDAO().getProductImage(id);
//	 
//				return new DefaultStreamedContent(new ByteArrayInputStream(image));
//	 
//			}
//		}
	
		@PostConstruct
		public void init(){
			challenges=chs.getAllChallenges();
			categories=cSL.getAllCategories();
		}
		
		public List<Challenge> getChallenges(){
			return challenges;
		}
	
		public void supprimer(Integer challengeId){
			chs.removeChallenge(challengeId);
			ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
			try {
				ec.redirect(((HttpServletRequest) ec.getRequest()).getRequestURI());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		public void modifier(Challenge challenge){
//			this.setTitre(challenge.getTitre());
//			this.setDescription(challenge.getDescription());
//			this.setDatedebut(challenge.getDatedebut());
//			this.setDatefin(challenge.getDatefin());
//			this.setChallengeIDTobeUpdated(challenge.getIdChallenge());
		}
		
		public void updateChallenge(){
			chs.updateChallenge(challenge);
		}	
		
		public void participateInChallenge(Integer challengeId){
			chs.participate(challengeId, 1);
		}
//		public void rate(){
//			chs.Rating(new Rating(rating1));
//		}
		
		   

//		public int getIdChallenge() {
//			return idChallenge;
//		}
//
//		public void setIdChallenge(int idChallenge) {
//			this.idChallenge = idChallenge;
//		}
//
//		public String getTitre() {
//			return titre;
//		}
//
//		public void setTitre(String titre) {
//			this.titre = titre;
//		}
//
//		public String getDescription() {
//			return description;
//		}
//
//		public void setDescription(String description) {
//			this.description = description;
//		}
//
//		public Date getDatedebut() {
//			return datedebut;
//		}
//
//		public void setDatedebut(Date datedebut) {
//			this.datedebut = datedebut;
//		}
//
//		public Date getDatefin() {
//			return datefin;
//		}
//
//		public void setDatefin(Date datefin) {
//			this.datefin = datefin;
//		}
//
//		public Integer getChallengeIDTobeUpdated() {
//			return challengeIDTobeUpdated;
//		}
//
//		public void setChallengeIDTobeUpdated(Integer challengeIDTobeUpdated) {
//			this.challengeIDTobeUpdated = challengeIDTobeUpdated;
//		}

//		public void setIdChallenge(Integer idChallenge) {
//			this.idChallenge = idChallenge;
//		}

		public void setChallenges(List<Challenge> challenges) {
			this.challenges = challenges;
		}

//		public Category getCategory() {
//			return category;
//		}
//
//		public void setCategory(Category category) {
//			this.category = category;
//		}
//
//		public Integer getNbreplaces() {
//			return nbreplaces;
//		}
//
//		public void setNbreplaces(Integer nbreplaces) {
//			this.nbreplaces = nbreplaces;
//		}
//
//		public byte[] getPicture() {
//			return picture;
//		}
//
//		public void setPicture(byte[] picture) {
//			this.picture = picture;
//		}

		public UploadedFile getUploadedFile() {
			return uploadedFile;
		}

		public void setUploadedFile(UploadedFile uploadedFile) {
			this.uploadedFile = uploadedFile;
		}

//		public TypeChallenge getTypeChallenge() {
//			return typeChallenge;
//		}
//
//		public void setTypeChallenge(TypeChallenge typeChallenge) {
//			this.typeChallenge = typeChallenge;
//		}

		public Integer getRating1() {
			return rating1;
		}

		public void setRating1(Integer rating1) {
			this.rating1 = rating1;
		}

		public List<Categories> getCategories() {
			return categories;
		}

		public void setCategories(List<Categories> categories) {
			this.categories = categories;
		}





}
