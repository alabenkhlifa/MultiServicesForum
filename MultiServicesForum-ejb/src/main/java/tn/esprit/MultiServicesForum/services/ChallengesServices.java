package tn.esprit.MultiServicesForum.services;

import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import tn.esprit.MultiServicesForum.entities.Category;
import tn.esprit.MultiServicesForum.entities.Challenges;
import tn.esprit.MultiServicesForum.entities.Participation;
import tn.esprit.MultiServicesForum.entities.ParticipationPk;
import tn.esprit.MultiServicesForum.entities.Rating;
import tn.esprit.MultiServicesForum.entities.TypePart;

@Stateless
@LocalBean
public class ChallengesServices implements ChallengesServicesLocal,ChallengesServicesRemote {

	@PersistenceContext
	private EntityManager em;
	Challenges challenge = new Challenges();

	@Override
	public void ajouterChallenge(Challenges challenge) {
		em.persist(challenge);
	}

	@Override
	public List<Challenges> getAllChallenges() {
		return em.createQuery("select c from Challenges c order by typeChallenge",
				Challenges.class).getResultList();
	}

	@Override
	public void removeChallenge(int challengeId) {
		em.remove(em.find(Challenges.class, challengeId));
	}

	@Override
	public void updateChallenge(Challenges challenge) {
		em.merge(challenge);
	}

	// public byte[] getProductImage(int challengeId) throws IOException,
	// SQLException {
	//
	// byte[] productImage = null;
	// em.find(Challenges.class, challengeId);
	// stmt = con.prepareStatement("select * from product where productId=?");
	// stmt.setString(1, productId);
	// ResultSet rs = stmt.executeQuery();
	//
	// productImage = challenge.getBytes("productImage");
	//
	// return productImage;
	// }

	@Override
	public List<Challenges> getChallengesByCategory(Category category) {
		return em.createQuery("select e from Challenges e where e.category=:cat",
				Challenges.class).setParameter("cat", category).getResultList();
	}

	@Override
	public void participate(int idChallenge, int idMember) {
		ParticipationPk tpk = new ParticipationPk();
		tpk.setIdChallenge(idChallenge);
		tpk.setIdMember(1);
		Challenges chal = em.find(Challenges.class, idChallenge);
		System.out.println("**************************************" + chal.getNbreplaces());
		if (chal.getNbreplaces() > 0 && chal.getDatefin().before(new Date())) {
			Participation part = new Participation();
			part.setPpk(tpk);
			part.setTypePart((TypePart.Participant));
			// em.persist(part);
			Integer places = chal.getNbreplaces();
			chal.setNbreplaces(places--);
			em.merge(chal);
			em.persist(part);
		} else {
			Participation part = new Participation();
			part.setPpk(tpk);
			part.setTypePart((TypePart.Invite));
			em.persist(part);
		}
	}

	public int Rating(Rating rate) {
		em.persist(rate);
		return rate.getIdRating();
	}

	@Override
	public byte[] findPictureByChallengeId(int id) {
		byte[] picture = null;
		Query query = em.createQuery("select p.picture from Challenges p where p.id=:x");
		query.setParameter("x", id);
		try {
			picture = (byte[]) query.getSingleResult();
		} catch (Exception ex) {
			Logger.getLogger(this.getClass().getName()).log(Level.INFO, "no picture");
		}
		return picture;
	}
	
}
