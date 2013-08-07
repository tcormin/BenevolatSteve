package org.benevolat.project.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import org.benevolat.project.model.Association;
import org.benevolat.project.model.Benevole;
import org.benevolat.project.model.Evenement;
import org.benevolat.project.model.Image;

/**
 * SERVICE association
 * 
 * @author tcormin
 */
@Stateless
public class AssociationService extends PersistenceService{

	/**
	* Enregistre l'association
	* @param association
	* @throws Exception
	*/
	public void setData(Association association) throws Exception {
		save(association);
		this.getLog().info("Association is registred with name: "+association.getNom());
	}
	
	/**
	* Récupère toutes les associations
	* @return
	* @throws Exception
	*/
	@SuppressWarnings("unchecked")
	public List<Association> getAssociations() throws Exception {
		Query query = this.getEm().createQuery("from "+Association.class.getName() + " ORDER BY nom");
		List<Association> m = query.getResultList();
		this.getLog().info(m.size() + " association found");
		return m;
	}

	
	
	/**
	* Récupère 4 associations au hasard
	* @return
	* @throws Exception
	*/
	@SuppressWarnings("unchecked")
	public List<Association> getAssociationsRandom() throws Exception {
		Query query = this.getEm().createQuery("from "+Association.class.getName() + " ORDER BY RAND()");
		List<Association> m = query.getResultList();
		this.getLog().info(m.size() + " association found");
		return m;
	}
	
	/**
	 * Recherche d'association
	 * @param searchText
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Association> search(String searchText) {
		Query query = this.getEm().createQuery("from association WHERE nom LIKE '%"+searchText+"%'" +
				" or acronyme LIKE '%"+searchText+"%'" +
				" or presentation LIKE '%"+searchText+"%'" +
				" or buts LIKE '%"+searchText+"%'");
		List<Association> a = query.getResultList();
		this.getLog().info(a.size() + " associations found for "+searchText);
		return a;
	}
	
	/**
	 * Récupère le username/password de l'utilisateur
	 * @param clazz
	 * @param username
	 * @param password
	 * @return
	 */
	public <T> void setImageToId(String id, Image image) {
		Query query = this.getEm().createQuery("from "+Association.class.getName()+ " WHERE id = '"+id+"'");
		Association a = (Association) query.getSingleResult();
		a.setImage(image);
		
		this.getEm().flush();
		
	}
	
	/**
	 * Met à jour l'association dans la BDD
	 * @param association
	 */
	public void update(Association association){
		Association a = this.getFromId(Association.class, association.getid().toString());
		a.setAdresse(association.getAdresse());
		a.setCommune(association.getCommune());
		a.setEmail(association.getEmail());
		a.setNom(association.getNom());
		a.setNpa(association.getNpa());
		a.setPassword(association.getPassword());
		a.setPresentation(association.getPresentation());
		a.setTelephone(association.getTelephone());
		a.setUrl(association.getUrl());
		a.setUsername(association.getUsername());
		a.setAcronyme(association.getAcronyme());
		a.setButs(association.getButs());
		a.setContact(association.getContact());
		a.setDateCreation(association.getDateCreation());
		a.setDomaineNiveau1(association.getDomaineNiveau1());
		
		this.getEm().flush();
	}
}