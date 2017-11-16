package tn.esprit.MultiServicesForum.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.MultiServicesForum.entities.Categories;

@Stateless
@LocalBean
public class CategoriesService implements CategoriesServiceLocal,CategoriesServiceRemote {
	@PersistenceContext
	private EntityManager em;
	
	
	
	public CategoriesService() {
	}



	@Override
	public List<Categories> getAllCategories() {
		return em.createQuery("select c from Categories c",
				Categories.class).getResultList();
	}
}
