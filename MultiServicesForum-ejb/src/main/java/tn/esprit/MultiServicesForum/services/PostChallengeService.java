package tn.esprit.MultiServicesForum.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import tn.esprit.MultiServicesForum.entities.PostChallenge;

@Stateless
@LocalBean
public class PostChallengeService implements PostChallengeServiceRemote {

	@PersistenceContext
	private EntityManager em;
	PostChallenge post = new PostChallenge();

	@Override
	public int addPost(PostChallenge post) {
		em.persist(post);
		return post.getIdPost();
	}

	@Override
	public void removePost(int postId) {
		em.remove(em.find(PostChallenge.class, postId));
	}

	@Override
	public void updatePost(PostChallenge post) {
		em.merge(post);
	}

	@Override
	public List<PostChallenge> getAllPosts() {
		TypedQuery<PostChallenge> query = em.createQuery("select c from PostChallenge c", PostChallenge.class);
		return query.getResultList();
	}
	
	

	

	// @Override
	// public List<PostChallenge> getAllPosts(int challengeid) {
	// TypedQuery<PostChallenge> query = em.createQuery("select c from
	// PostChallenge c where c.idChallenge= challengeid", PostChallenge.class);
	// query.setParameter("challengeid", challengeid);
	// return query.getResultList();
	// }

}
