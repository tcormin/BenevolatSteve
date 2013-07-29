package org.benevolat.project.service;

import java.util.List;

import javax.ejb.Stateless;

import org.benevolat.project.model.Association;

@Stateless
public class AssociationService extends PersistenceService{

	   public void setData(Association association) throws Exception {
		   save(association);
		   log.info("Association is registred with name: "+association.getNom());
	   }
	   
	   public List<Association> getAssociations() throws Exception {
		   List<Association> m = findAll(Association.class);
		   log.info(m.size() + " association found");
		   return m;
	   }

}