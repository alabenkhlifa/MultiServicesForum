package tn.esprit.MultiServicesForum.services;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.MultiServicesForum.entities.Categories;

@Remote
public interface CategoriesServiceRemote {
	public List<Categories> getAllCategories();
}
