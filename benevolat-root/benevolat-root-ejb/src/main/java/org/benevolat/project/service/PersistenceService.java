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

/**
 * SERVICE persistence général
 * 
 * @author tcormin
 */
public class PersistenceService{
	
	/** Logger pour affichage */
	@Inject
	private Logger log;

	/** Entity manager pour la connection à la DB */
	@PersistenceContext
	private EntityManager em;

	/**
	 * 
	 * @return le log
	 */
	public Logger getLog() {
		return log;
	}

	/**
	 * 
	 * @return l'entity manager
	 */
	public EntityManager getEm() {
		return em;
	}

	/**
	 * Enregistre dans la BDD l'objet et le retourne
	 * @param object
	 * @return
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
		Benevole b = (Benevole) object;
		em.refresh(object);
	}
	
	public <T> void flush(T object) {
		em.flush();
	}
	
	/**
	 * Supprime de la BDD l'objet par id
	 * @param clazz
	 * @param id
	 */
	public <T> void removeFromId(Class<T> clazz,String id) {
		Query query = em.createQuery("DELETE from "+clazz.getName()+ " WHERE id = '"+id+"'");
		query.executeUpdate();
	}

	public <T> T remove(T object) {
		T savedObject = em.merge(object);
		em.remove(savedObject);
		return savedObject;
	}
	
	/**
	 * Supprime de la BDD l'utilisateurs par id
	 * @param id
	 */
	public void removeUserFromId(String id) {
		Query query = em.createQuery("DELETE from "+Utilisateur.class.getName()+ " WHERE id = '"+id+"'");
		query.executeUpdate();
	}
	
	/**
	 * Recherche si un élément de la classe est du domaine d
	 * @param clazz
	 * @param d
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public <T> List<T> searchByDomaine(Class<T> clazz, Domaine d) {
		Query query = em.createQuery("from "+clazz.getName()+ " WHERE domaine = '"+d.toString()+"'");
		return query.getResultList();
	}
	
	/**
	 * Renvoie tous les éléments du type T
	 * @param clazz
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public <T> List<T> findAll(Class<T> clazz) {
		Query query = em.createQuery("from "+clazz.getName());
		return query.getResultList();
	}
	
	/**
	 * Récupère un élément par son id
	 * @param clazz
	 * @param id
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public <T> T getFromId(Class<T> clazz, String id) {
		Query query = em.createQuery("from "+clazz.getName()+ " WHERE id = '"+id+"'");
		return (T) query.getSingleResult();
	}
	
	/**
	 * Récupère le username/password de l'utilisateur
	 * @param clazz
	 * @param username
	 * @param password
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public <T> List<T> getFromPassword(Class<T> clazz, String username, String password) {
		Query query = em.createQuery("from "+clazz.getName()+ " WHERE username = '"+username+"' and password = '"+password+"'");
		return query.getResultList();
	}

}
