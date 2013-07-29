package org.benevolat.project.service;

import java.util.Collection;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import org.benevolat.project.model.Benevole;
import org.benevolat.project.model.InscriptionMission;
import org.benevolat.project.model.Mission;

@Stateless
public class InscriptionMissionService extends PersistenceService{

	   public void setData(InscriptionMission inscriptionMission) throws Exception {
		   save(inscriptionMission);
		   log.info("InscriptionMission is registred with id: "+String.valueOf(inscriptionMission.getId()));
	   }
	   
	   public Collection<InscriptionMission> getInscriptionMission() throws Exception {
		   List<InscriptionMission> f = findAll(InscriptionMission.class);
		   log.info(f.size() + " inscriptionMission found");
		   return f;
	   }

	   @SuppressWarnings("unchecked")
	   public Collection<InscriptionMission> getMyMissionsAcceptees(Benevole b) throws Exception {
		   Query query = em.createQuery("from "+InscriptionMission.class.getName()+ " WHERE status = 0");
		   return query.getResultList();	
		}

		@SuppressWarnings("unchecked")
		public Collection<InscriptionMission> getMyMissionsEnCours(Benevole user) throws Exception {
			Query query = em.createQuery("from "+InscriptionMission.class.getName()+ " WHERE status = 1");
			return query.getResultList();
		}

		@SuppressWarnings("unchecked")
		public Collection<InscriptionMission> getMyMissionsRefusees(Benevole user) throws Exception {
			Query query = em.createQuery("from "+InscriptionMission.class.getName()+ " WHERE status = 2");
			return query.getResultList();
		}

		@SuppressWarnings("unchecked")
		public Collection<InscriptionMission> getMyMissionsAccomplies(Benevole user) throws Exception {
			Query query = em.createQuery("from "+InscriptionMission.class.getName()+ " WHERE status = 3");
			return query.getResultList();
		}
		
		@SuppressWarnings("unchecked")
		public Collection<InscriptionMission> getInscriptionsAcceptees(Mission m) throws Exception {
			Query query = em.createQuery("from "+InscriptionMission.class.getName()+ " WHERE mission_id = "+String.valueOf(m.getId()) + " and status = 0");
			return query.getResultList();
		}
		
		@SuppressWarnings("unchecked")
		public Collection<InscriptionMission> getInscriptionsEnCours(Mission m) throws Exception {
			Query query = em.createQuery("from "+InscriptionMission.class.getName()+ " WHERE mission_id = "+String.valueOf(m.getId()) + " and status = 1");
			return query.getResultList();
		}
		
		@SuppressWarnings("unchecked")
		public Collection<InscriptionMission> getInscriptionsRefusees(Mission m) throws Exception {
			Query query = em.createQuery("from "+InscriptionMission.class.getName()+ " WHERE mission_id = "+String.valueOf(m.getId()) + " and status = 2");
			return query.getResultList();
		}
		
		@SuppressWarnings("unchecked")
		public Collection<InscriptionMission> getInscriptionsAccomplies(Mission m) throws Exception {
			Query query = em.createQuery("from "+InscriptionMission.class.getName()+ " WHERE mission_id = "+String.valueOf(m.getId()) + " and status = 3");
			return query.getResultList();
		}
}