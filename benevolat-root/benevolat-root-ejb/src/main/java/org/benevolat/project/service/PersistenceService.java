package org.benevolat.project.service;

import java.util.List;
import java.util.logging.Logger;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.benevolat.project.model.Benevole;
import org.benevolat.project.model.Domaine;
import org.benevolat.project.model.Utilisateur;

public class PersistenceService{
	

   @Inject
   protected Logger log;

   @PersistenceContext
   protected EntityManager em;

	/**
	 * {@inheritDoc}
	 * Insert a new data in the base.
	 */
	   
	public <T> T save(T object) {
		T savedObject = em.merge(object);
		em.persist(savedObject);
		return savedObject;
	}
	
	public <T> void merge(T object) {
		//em.merge(object);
		em.flush();
	}
	
	public <T> void refresh(T object) {
		Benevole b= (Benevole) object;
		System.out.println("Je passe là " +b.getNom());
		em.refresh(object);
	}
	
	public <T> void flush(T object) {
		em.flush();
	}
	
	public <T> void removeFromId(Class<T> clazz,String id) {
		Query query = em.createQuery("DELETE from "+clazz.getName()+ " WHERE id = '"+id+"'");
		query.executeUpdate();
	}
	
	public <T> T remove(T object) {
		T savedObject = em.merge(object);
		em.remove(savedObject);
		return savedObject;
	}
	
	public void removeUserFromId(String id) {
		Query query = em.createQuery("DELETE from "+Utilisateur.class.getName()+ " WHERE id = '"+id+"'");
		query.executeUpdate();
	}
		
	@SuppressWarnings("unchecked")
	public <T> List<T> searchByDomaine(Class<T> clazz, Domaine d) {
		Query query = em.createQuery("from "+clazz.getName()+ " WHERE domaine = '"+d.toString()+"'");
		return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public <T> List<T> findAll(Class<T> clazz) {
		Query query = em.createQuery("from "+clazz.getName());
		return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public <T> T getFromId(Class<T> clazz, String id) {
		Query query = em.createQuery("from "+clazz.getName()+ " WHERE id = '"+id+"'");
		return (T) query.getSingleResult();
	}
	
   @SuppressWarnings("unchecked")
	public <T> List<T> getFromPassword(Class<T> clazz, String username, String password) {
		Query query = em.createQuery("from "+clazz.getName()+ " WHERE username = '"+username+"' and password = '"+password+"'");
		return query.getResultList();
	}
}
