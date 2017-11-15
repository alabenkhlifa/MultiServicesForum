package tn.esprit.MultiServicesForum.presentation.mbeans;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import tn.esprit.MultiServicesForum.entities.TypeChallenge;

@ManagedBean
@ApplicationScoped
public class DataTypeChallenge {

	public TypeChallenge[] getTypeChallenges() {
		return TypeChallenge.values();
	}

}