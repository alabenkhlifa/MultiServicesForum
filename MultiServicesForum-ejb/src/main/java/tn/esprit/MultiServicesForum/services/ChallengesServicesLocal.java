package tn.esprit.MultiServicesForum.services;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.MultiServicesForum.entities.Category;
import tn.esprit.MultiServicesForum.entities.Challenges;

@Local
public interface ChallengesServicesLocal {

	public void ajouterChallenge(Challenges challenge);

	public List<Challenges> getAllChallenges();

	public void removeChallenge(int challengeId);

	public void updateChallenge(Challenges challenge);

	public List<Challenges> getChallengesByCategory(Category category);

	void participate(int idChallenge, int idMember);

	byte[] findPictureByChallengeId(int id);

}