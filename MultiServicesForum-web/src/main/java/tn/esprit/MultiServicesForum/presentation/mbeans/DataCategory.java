package tn.esprit.MultiServicesForum.presentation.mbeans;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import tn.esprit.MultiServicesForum.entities.Category;


@ManagedBean
@ApplicationScoped
public class DataCategory {



public Category[] geCategories(){
	return Category.values();
}


}
