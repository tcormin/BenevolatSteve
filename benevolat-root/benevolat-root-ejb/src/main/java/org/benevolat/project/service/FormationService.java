package org.benevolat.project.service;

import java.util.List;

import javax.ejb.Stateless;

import org.benevolat.project.model.Formation;

@Stateless
public class FormationService extends PersistenceService{

	   public void setData(Formation formation) throws Exception {
		   save(formation);
		   log.info("Formation is registred with title: "+formation.getTitre());
	   }
	   
	   public List<Formation> getFormations() throws Exception {
		   List<Formation> f = findAll(Formation.class);
		   log.info(f.size() + " formation found");
		   return f;
	   }
}