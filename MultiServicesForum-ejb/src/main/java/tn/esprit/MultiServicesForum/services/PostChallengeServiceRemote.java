package tn.esprit.MultiServicesForum.services;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.MultiServicesForum.entities.PostChallenge;

@Remote
public interface PostChallengeServiceRemote {

	int addPost(PostChallenge post);

	void removePost(int postId);

	void updatePost(PostChallenge post);

	List<PostChallenge> getAllPosts();

}
