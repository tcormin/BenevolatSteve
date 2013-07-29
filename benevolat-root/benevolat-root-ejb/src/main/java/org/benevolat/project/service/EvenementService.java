package org.benevolat.project.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import org.benevolat.project.model.Evenement;

@Stateless
public class EvenementService extends PersistenceService{

	   public void setData(Evenement evenement) throws Exception {
		   save(evenement);
		   log.info("Evenement is registred with name: "+evenement.getNom());
	   }
	   
	   public List<Evenement> getEvenements() throws Exception {
		   List<Evenement> m = findAll(Evenement.class);
		   log.info(m.size() + " evenements found");
		   return m;
	   }
	  
		@SuppressWarnings("unchecked")
		public List<Evenement> search(String searchText) {
			Query query = em.createQuery("from evenement WHERE nom LIKE '%"+searchText+"%'" +
					" or lieu LIKE '%"+searchText+"%'" +
					" or description LIKE '%"+searchText.toString()+"%'");
			//Query query = em.createQuery("from "+Evenement.class.getName());//+ " WHERE lieu = '"+searchText+"'");
			List<Evenement> e = query.getResultList();
			log.info(e.size() + " evenements found for "+searchText);
			return e;
		}
}