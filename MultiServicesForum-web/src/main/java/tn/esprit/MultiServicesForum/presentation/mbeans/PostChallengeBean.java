//package tn.esprit.MultiServicesForum.presentation.mbeans;
//
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.List;
//
//
//import javax.ejb.EJB;
//import javax.faces.bean.ManagedBean;
//import javax.faces.bean.SessionScoped;
//
//import org.primefaces.model.UploadedFile;
//
//import tn.esprit.MultiServicesForum.entities.PostChallenge;
//import tn.esprit.MultiServicesForum.services.PostChallengeService;
//
//@SessionScoped
//@ManagedBean
//public class PostChallengeBean {
//
//	private Integer idPost;
//	private String description;
//	private Date datePub;
//	private Integer idPostToBeUpdated;
//	private List<PostChallenge> posts;
//	private UploadedFile uploadedFile;
//	private byte[] image;
//	
//	
//	@EJB
//	PostChallengeService pcs ; 
//	
//	public void addPost()throws ParseException{
//		SimpleDateFormat simpleFormat = new SimpleDateFormat("dd-MM-yyyy");
//		
//		pcs.addPost(new PostChallenge(description, new Date() ));
//		
//	}
////	public void supprimer(Integer postId){
////		pcs.removePost(postId);
////	}
////	public void modifier(PostChallenge post){
////		this.setImage(post.getImage());
////		this.setDescription(post.getDescription());
////		this.setDatePub(post.getDatePub());
////		this.setIdPostToBeUpdated(post.getIdPost());
////	}
////	public void updateChallenge(){
////		pcs.updatePost(new PostChallenge(image,description, new Date(),idPostToBeUpdated ));
////	}	
////	public List<PostChallenge> getPosts(){
////		posts= pcs.getAllPosts();
////		return posts;
////	}
//	public String getDescription() {
//		return description;
//	}
//	public void setDescription(String description) {
//		this.description = description;
//	}
//	public Integer getIdPost() {
//		return idPost;
//	}
//	public void setIdPost(Integer idPost) {
//		this.idPost = idPost;
//	}
//	public Date getDatePub() {
//		return datePub;
//	}
//	public void setDatePub(Date datePub) {
//		this.datePub = datePub;
//	}
//	public PostChallengeService getPcs() {
//		return pcs;
//	}
//	public void setPcs(PostChallengeService pcs) {
//		this.pcs = pcs;
//	}
//	public Integer getIdPostToBeUpdated() {
//		return idPostToBeUpdated;
//	}
//	public void setIdPostToBeUpdated(Integer idPostToBeUpdated) {
//		this.idPostToBeUpdated = idPostToBeUpdated;
//	}
//	public UploadedFile getUploadedFile() {
//		return uploadedFile;
//	}
//	public void setUploadedFile(UploadedFile uploadedFile) {
//		this.uploadedFile = uploadedFile;
//	}
//	public byte[] getImage() {
//		return image;
//	}
//	public void setImage(byte[] image) {
//		this.image = image;
//	}
//	public void setPosts(List<PostChallenge> posts) {
//		this.posts = posts;
//	}
//	public List<PostChallenge> getPosts() {
//		return posts;
//	}
//
//}
