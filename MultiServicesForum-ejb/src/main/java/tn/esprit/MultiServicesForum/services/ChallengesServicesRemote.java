package tn.esprit.MultiServicesForum.services;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.MultiServicesForum.entities.Category;
import tn.esprit.MultiServicesForum.entities.Challenges;

@Remote
public interface ChallengesServicesRemote {

	public void ajouterChallenge(Challenges challenge);

	public List<Challenges> getAllChallenges();

	public void removeChallenge(int challengeId);

	public void updateChallenge(Challenges challenge);

	public List<Challenges> getChallengesByCategory(Category category);

	void participate(int idChallenge, int idMember);

	byte[] findPictureByChallengeId(int id);

}
