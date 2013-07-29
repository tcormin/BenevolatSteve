package org.benevolat.project.service;

import java.util.List;

import javax.ejb.Stateless;

import org.benevolat.project.model.Benevole;

@Stateless
public class BenevoleService extends PersistenceService{

	   public void setData(Benevole benevole) throws Exception {
		   save(benevole);
		   log.info("Benevole is registred with name: "+benevole.getNom());
	   }
	   
	   public List<Benevole> getBenevoles() throws Exception {
		   List<Benevole> m = findAll(Benevole.class);
		   log.info(m.size() + " benevole found");
		   return m;
	   }
	   
	   public void update(Benevole benevole){
		   Benevole b = this.getFromId(Benevole.class, benevole.getid().toString());
		   b.setNom(benevole.getNom());
		   b.setProfession(benevole.getProfession());
		   em.flush();
	   }
	   
//	   public void update(Benevole benevole) throws Exception {
//		   try{
//			    em.getTransaction().begin();
//			    Benevole b = em.find(Benevole.class, benevole.getid());
//			    b.setNom(benevole.getNom());
//			    em.getTransaction().commit();
//			  } finally {
//			  }
//		   log.info("Benevole is updated with name : "+benevole.getNom());
//	   }
	 
}