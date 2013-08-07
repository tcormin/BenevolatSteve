package org.benevolat.project.service;

import java.util.List;

import javax.ejb.Stateless;

import org.benevolat.project.model.Administrateur;
import org.benevolat.project.model.Mission;

/**
 * SERVICE administrateur
 * 
 * @author tcormin
 */
@Stateless
public class AdministrateurService extends PersistenceService{

	/**
	* Enregistre l'administrateur
	* @param administrateur
	* @throws Exception
	*/
	public void setData(Administrateur administrateur) throws Exception {
		save(administrateur);
		this.getLog().info("Administrateur is registred with name: "+administrateur.getNom());
	}
   
	/**
	* Récupère tous les administrateurs
	* @return
	* @throws Exception
	*/
	public List<Administrateur> getAdministrateurs() throws Exception {
		List<Administrateur> m = findAll(Administrateur.class);
		this.getLog().info(m.size() + " administrateur found");
		return m;
	}
	
	/**
	 * Met à jour l'administrateur dans la BDD
	 * @param administrateur
	 */
	public void update(Administrateur administrateur){
		Administrateur a = this.getFromId(Administrateur.class, administrateur.getid().toString());
		a.setAdresse(administrateur.getAdresse());
		a.setCommune(administrateur.getCommune());
		a.setEmail(administrateur.getEmail());
		a.setNom(administrateur.getNom());
		a.setNpa(administrateur.getNpa());
		a.setPassword(administrateur.getPassword());
		a.setPrenom(administrateur.getPrenom());
		a.setTelephone(administrateur.getTelephone());
		a.setUrl(administrateur.getUrl());
		a.setUsername(administrateur.getUsername());
		
		this.getEm().flush();
	}

}