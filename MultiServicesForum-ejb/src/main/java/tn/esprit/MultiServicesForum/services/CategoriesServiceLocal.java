package tn.esprit.MultiServicesForum.services;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.MultiServicesForum.entities.Categories;

@Local
public interface CategoriesServiceLocal {

	public List<Categories> getAllCategories();

}
