package org.benevolat.project.service;

import java.util.List;

import javax.ejb.Stateless;

import org.benevolat.project.model.Administrateur;
import org.benevolat.project.model.Association;
import org.benevolat.project.model.Benevole;
import org.benevolat.project.model.Mission;
import org.benevolat.project.model.Utilisateur;

/**
 * SERVICE utilisateur
 * 
 * @author tcormin
 */
@Stateless
public class UtilisateurService extends PersistenceService{
	
	/**
	 * 
	 * @param utilisateur
	 * @throws Exception
	 */
	public void setData(Utilisateur utilisateur) throws Exception {
		save(utilisateur);
		this.getLog().info("Utilisateur is registred with name: "+utilisateur.getUsername());
	}
	
	/**
	 * Trouve tous les utilisateurs
	 * @return
	 * @throws Exception
	 */
	public List<Utilisateur> getData() throws Exception {
		List<Utilisateur> m = findAll(Utilisateur.class);
		this.getLog().info(m.size() + " utilisateur found");
		return m;
	}
	
	/**
	 * Recherche un utilisateur qui peut être de plusieurs type (bénévole/administrateur/association) depuis son id
	 * @param username
	 * @param password
	 * @return
	 */
	public Utilisateur getUserFromId(String username) {

		List<Benevole> b = this.getFromUsername(Benevole.class, username);
		if(b.size()>0){
			return b.get(0);
		}

		List<Association> a = this.getFromUsername(Association.class, username);
		if(a.size()>0){
			return a.get(0);
		}

		List<Administrateur> ad = this.getFromUsername(Administrateur.class, username);
		if(ad.size()>0){
			return ad.get(0);
		}
		   

		   
		return null;
	}
	
}