package org.benevolat.project.service;

import java.util.List;

import javax.ejb.Stateless;

import org.benevolat.project.model.Administrateur;
import org.benevolat.project.model.Association;
import org.benevolat.project.model.Benevole;
import org.benevolat.project.model.Utilisateur;

@Stateless
public class UtilisateurService extends PersistenceService{
	
	   public void setData(Utilisateur utilisateur) throws Exception {
		   save(utilisateur);
		   log.info("Utilisateur is registred with name: "+utilisateur.getUsername());
	   }
	   
	   public List<Utilisateur> getData() throws Exception {
		   List<Utilisateur> m = findAll(Utilisateur.class);
		   log.info(m.size() + " utilisateur found");
		   return m;
	   }
	   
	   public Utilisateur getUserFromId(String username, String password) {
		   

		   List<Benevole> b = this.getFromPassword(Benevole.class, username, password);
		   if(b.size()>0){
			   return b.get(0);
		   }
		   
		   List<Administrateur> ad = this.getFromPassword(Administrateur.class, username, password);
		   if(ad.size()>0){
			   return ad.get(0);
		   }
		   
		   List<Association> a = this.getFromPassword(Association.class, username, password);
		   if(a.size()>0){
			   return a.get(0);
		   }
		   
		   return null;
	   }
}