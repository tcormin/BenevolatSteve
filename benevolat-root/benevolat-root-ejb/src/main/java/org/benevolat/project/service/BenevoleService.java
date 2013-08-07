package org.benevolat.project.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import org.benevolat.project.model.Benevole;
import org.benevolat.project.model.Evenement;
import org.benevolat.project.model.Image;

/**
 * SERVICE bénévole
 * 
 * @author tcormin
 */
@Stateless
public class BenevoleService extends PersistenceService{

	/**
	* Enregistre le bénévole
	* @param benevole
	* @throws Exception
	*/
	public void setData(Benevole benevole) throws Exception {
		save(benevole);
		this.getLog().info("Benevole is registred with name: "+benevole.getNom());
	}
	
	/**
	* Récupère tous les bénévoles
	* @return
	* @throws Exception
	*/
	public List<Benevole> getBenevoles() throws Exception {
		List<Benevole> m = findAll(Benevole.class);
		this.getLog().info(m.size() + " benevole found");
		return m;
	}
	
	/**
	 * Récupère le username/password de l'utilisateur
	 * @param clazz
	 * @param username
	 * @param password
	 * @return
	 */
	public <T> void setImageToId(String id, Image image) {
		Query query = this.getEm().createQuery("from "+Benevole.class.getName()+ " WHERE id = '"+id+"'");
		Benevole b = (Benevole) query.getSingleResult();
		b.setImage(image);
		
		this.getEm().flush();
		
	}
	
	/**
	 * Met à jour le bénévole dans la BDD
	 * @param benevole
	 */
	public void update(Benevole benevole){
		Benevole b = this.getFromId(Benevole.class, benevole.getid().toString());
		b.setAdresse(benevole.getAdresse());
		b.setCommune(benevole.getCommune());
		b.setDateNaissance(benevole.getDateNaissance());
		b.setEmail(benevole.getEmail());
		b.setNom(benevole.getNom());
		b.setNpa(benevole.getNpa());
		b.setPassword(benevole.getPassword());
		b.setPrenom(benevole.getPrenom());
		b.setPresentation(benevole.getPresentation());
		b.setProfession(benevole.getProfession());
		b.setTelephone(benevole.getTelephone());
		b.setUrl(benevole.getUrl());
		b.setUsername(benevole.getUsername());
		
		this.getEm().flush();
	}
	 
}