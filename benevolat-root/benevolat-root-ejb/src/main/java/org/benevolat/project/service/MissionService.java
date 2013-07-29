package org.benevolat.project.service;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.Query;

import org.benevolat.project.model.Association;
import org.benevolat.project.model.Mission;

@Stateless
public class MissionService extends PersistenceService{

	   public void setData(Mission mission) throws Exception {
		   save(mission);
		   log.info("Mission is registred with title: "+mission.getTitre());
	   }
	   
	   public List<Mission> getMissions() throws Exception {
		   List<Mission> m = findAll(Mission.class);
		   log.info(m.size() + " missions found");
		   return m;
	   }
	   
	   @SuppressWarnings("unchecked")
	   public List<Mission> getMissionsRegulieres() throws Exception {
		   Query query = em.createQuery("from "+Mission.class.getName()+ " WHERE typeMission = 1");
		   return query.getResultList();
	   }
	   
	   @SuppressWarnings("unchecked")
	   public List<Mission> getMissionsPonctuelles() throws Exception {
		   Query query = em.createQuery("from "+Mission.class.getName()+ " WHERE typeMission = 0");
		   return query.getResultList();
	   }
	   
	   @SuppressWarnings("unchecked")
	   public List<Mission> getMyMissionsCompletes(Association a) throws Exception {
		   Query query = em.createQuery("from "+Mission.class.getName());//" WHERE typeMission = 0");
		   return query.getResultList();
	   }
	   
	   
	   public Mission setMissionAssociation(Long mId, Long aId) {
		   Mission m = em.find(Mission.class, mId);
		   Association a = em.find(Association.class, aId);
		   a.addMission(m);
		   return m;
	   }
	   
	   @PostConstruct
	   void init(){
		  
	   }
}