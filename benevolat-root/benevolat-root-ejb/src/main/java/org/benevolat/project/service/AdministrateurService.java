package org.benevolat.project.service;

import java.util.List;

import javax.ejb.Stateless;

import org.benevolat.project.model.Administrateur;

@Stateless
public class AdministrateurService extends PersistenceService{

	   public void setData(Administrateur administrateur) throws Exception {
		   save(administrateur);
		   log.info("Administrateur is registred with name: "+administrateur.getNom());
	   }
	   
	   public List<Administrateur> getAdministrateurs() throws Exception {
		   List<Administrateur> m = findAll(Administrateur.class);
		   log.info(m.size() + " administrateur found");
		   return m;
	   }

}