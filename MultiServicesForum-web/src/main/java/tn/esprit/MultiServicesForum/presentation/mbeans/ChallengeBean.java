package tn.esprit.MultiServicesForum.presentation.mbeans;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.model.UploadedFile;

import tn.esprit.MultiServicesForum.entities.Category;
import tn.esprit.MultiServicesForum.entities.Challenges;
import tn.esprit.MultiServicesForum.entities.Rating;
import tn.esprit.MultiServicesForum.entities.TypeChallenge;
import tn.esprit.MultiServicesForum.services.ChallengesServices;




@ManagedBean
@SessionScoped
public class ChallengeBean {

	private Integer idChallenge;
	
	private String titre;
	private String description;
	private Date datedebut;
	private Date datefin;
	private Category category;
	private List<Challenges> challenges;
	private Integer challengeIDTobeUpdated;
	private Integer nbreplaces;
	private byte[] picture;
	private UploadedFile uploadedFile;
	private TypeChallenge typeChallenge;
	  
    private Integer rating1;


		
		@EJB
		ChallengesServices chs;
	
		
		public void addChallenge()throws ParseException{
			SimpleDateFormat simpleFormat = new SimpleDateFormat("dd-MM-yyyy");
			
			String fileName = uploadedFile.getFileName();
		    String contentType = uploadedFile.getContentType();
		    System.out.println("fileName : "+fileName+" contentType : "+ contentType);
		    byte[] contents = uploadedFile.getContents(); 
			this.setPicture(contents);
			if ( getDatefin().after(getDatedebut()) && (getDatedebut().after(new Date()))){
			chs.ajouterChallenge(new Challenges(typeChallenge,picture,category,titre,description,nbreplaces,datedebut, datefin));
			}}
		 
			
		
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
		}
		
		public List<Challenges> getChallenges(){
			return challenges;
		}
	
		public void supprimer(Integer challengeId){
			chs.removeChallenge(challengeId);
		}
		
		public void modifier(Challenges challenge){
			this.setTitre(challenge.getTitre());
			this.setDescription(challenge.getDescription());
			this.setDatedebut(challenge.getDatedebut());
			this.setDatefin(challenge.getDatefin());
			this.setChallengeIDTobeUpdated(challenge.getIdChallenge());
		}
		
		public void updateChallenge(){
			chs.updateChallenge(new Challenges(category,titre,description,datedebut,datefin,challengeIDTobeUpdated,nbreplaces));
		}	
		
		public void participateInChallenge(Integer challengeId){
			chs.participate(challengeId, 1);
		}
		public void rate(){
			chs.Rating(new Rating(rating1));
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

		public Integer getChallengeIDTobeUpdated() {
			return challengeIDTobeUpdated;
		}

		public void setChallengeIDTobeUpdated(Integer challengeIDTobeUpdated) {
			this.challengeIDTobeUpdated = challengeIDTobeUpdated;
		}

		public ChallengesServices getChs() {
			return chs;
		}

		public void setChs(ChallengesServices chs) {
			this.chs = chs;
		}

		public void setIdChallenge(Integer idChallenge) {
			this.idChallenge = idChallenge;
		}

		public void setChallenges(List<Challenges> challenges) {
			this.challenges = challenges;
		}

		public Category getCategory() {
			return category;
		}

		public void setCategory(Category category) {
			this.category = category;
		}

		public Integer getNbreplaces() {
			return nbreplaces;
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

		public UploadedFile getUploadedFile() {
			return uploadedFile;
		}

		public void setUploadedFile(UploadedFile uploadedFile) {
			this.uploadedFile = uploadedFile;
		}

		public TypeChallenge getTypeChallenge() {
			return typeChallenge;
		}

		public void setTypeChallenge(TypeChallenge typeChallenge) {
			this.typeChallenge = typeChallenge;
		}



		public Integer getRating1() {
			return rating1;
		}



		public void setRating1(Integer rating1) {
			this.rating1 = rating1;
		}





}
