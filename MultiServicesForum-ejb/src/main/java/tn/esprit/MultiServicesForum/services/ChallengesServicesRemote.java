package tn.esprit.MultiServicesForum.services;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.MultiServicesForum.entities.Category;
import tn.esprit.MultiServicesForum.entities.Challenge;

@Remote
public interface ChallengesServicesRemote {

	public void ajouterChallenge(Challenge challenge);

	public List<Challenge> getAllChallenges();

	public void removeChallenge(int challengeId);

	public void updateChallenge(Challenge challenge);

	public List<Challenge> getChallengesByCategory(Category category);

	void participate(int idChallenge, int idMember);

	byte[] findPictureByChallengeId(int id);

}
