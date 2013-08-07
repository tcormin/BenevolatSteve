package org.benevolat.project.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import org.benevolat.project.model.Association;
import org.benevolat.project.model.InscriptionMission;
import org.benevolat.project.model.Mission;
import org.benevolat.project.model.Status;

/**
 * SERVICE missions
 * 
 * @author tcormin
 */
@Stateless
public class MissionService extends PersistenceService{

	/**
	* Enregistre la mission
	* @param mission
	* @throws Exception
	*/
	public void setData(Mission mission) throws Exception {
		save(mission);
		this.getLog().info("Mission is registred with title: "+mission.getTitre());
	}
	  
	/**
	 * Récupère toutes les missions
	 * @return
	 * @throws Exception
	 */
	public List<Mission> getMissions() throws Exception {
		List<Mission> m = findAll(Mission.class);
		this.getLog().info(m.size() + " missions found");
		return m;
	}
	   
	/**
	 * Renvoie toutes les missions régulières
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<Mission> getMissionsRegulieres() throws Exception {
		Query query = this.getEm().createQuery("from "+Mission.class.getName()+ " WHERE typeMission = 1 AND status = 5 ORDER BY dateDebut");
		return query.getResultList();
	}
	   
	/**
	 * Renvoie toutes les missions ponctuelles
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<Mission> getMissionsPonctuelles() throws Exception {
		Query query = this.getEm().createQuery("from "+Mission.class.getName()+ " WHERE typeMission = 0  AND status = 5 ORDER BY dateDebut");
		return query.getResultList();
	}
	
	/**
	 * Recherche de mission ponctuelles
	 * @param searchText
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Mission> searchPonctuelles(String searchText) {
		Query query = this.getEm().createQuery("from mission WHERE typeMission = 0 and (titre LIKE '%"+searchText+"%'" +
				" or description LIKE '%"+searchText+"%' )");
		List<Mission> m = query.getResultList();
		this.getLog().info(m.size() + " missions ponctuelles found for "+searchText);
		return m;
	}
	
	/**
	 * Recherche de mission ponctuelles
	 * @param searchText
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Mission> searchRegulieres(String searchText) {
		Query query = this.getEm().createQuery("from mission WHERE typeMission = 1 and (titre LIKE '%"+searchText+"%'" +
				" or description LIKE '%"+searchText+"%' )");
		List<Mission> m = query.getResultList();
		this.getLog().info(m.size() + " missions régulières found for "+searchText);
		return m;
	}
	
	/**
	 * Renvoie les missions incomplètes (reste de la place) d'une association
	 * @param l'association
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<Mission> getMyMissionsIncompletes(Association a) throws Exception {
		if(a == null){
			return new ArrayList<Mission>();
		}
		checkTerminees(a);
		Query query = this.getEm().createQuery("from " +Mission.class.getName()+ " WHERE status = 5 AND association_id = " + a.getid().toString());
		return query.getResultList();
	}
	
	/**
	 * Renvoie les missions complètes (plus de place) d'une association
	 * @param l'association
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<Mission> getMyMissionsCompletes(Association a) throws Exception {
		if(a == null){
			return new ArrayList<Mission>();
		}
		Query query = this.getEm().createQuery("from " +Mission.class.getName()+ " WHERE status = 6 AND association_id = " + a.getid().toString());
		return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public void checkTerminees(Association a){
		
		Query query = this.getEm().createQuery("from " +Mission.class.getName()+ " WHERE (association_id = " + a.getid().toString() + ") AND (status = 6 OR status = 5)");
		List<Mission> missions = query.getResultList();
		
		Date today = new Date();
		
		for(Mission m : missions){
			if(m.getDateFin() == null){
				if(m.getDateDebut().before(today)){
					this.setComplete(m.getId());
					m.setStatus(Status.TERMINEE);
					this.getEm().flush();
				}
			}
			else{
				if(m.getDateFin().before(today)){
					this.setComplete(m.getId());
					m.setStatus(Status.TERMINEE);
					this.getEm().flush();
				}
			}
		}
	}
	
	/**
	 * Renvoie les missions terminées (passées mais doit confirmer les présences) d'une association
	 * @param l'association
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<Mission> getMyMissionsTerminees(Association a) throws Exception {
		if(a == null){
			return new ArrayList<Mission>();
		}
		Query query = this.getEm().createQuery("from " +Mission.class.getName()+ " WHERE status = 7 AND association_id = " + a.getid().toString());
		return query.getResultList();
	}
	 
	/**
	 * Renvoie les missions archivées (reste de la place) d'une association
	 * @param l'association
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<Mission> getMyMissionsArchives(Association a) throws Exception {
		if(a == null){
			return new ArrayList<Mission>();
		}
		Query query = this.getEm().createQuery("from " +Mission.class.getName()+ " WHERE status = 8 AND association_id = " + a.getid().toString());
		return query.getResultList();
	}
	
	/**
	* Affecte une mission à une association et vice-versa
	* @param mId
	* @param aId
	* @return
	*/
	public Mission setMissionAssociation(Long mId, Long aId) {
		Mission m = this.getEm().find(Mission.class, mId);
		Association a = this.getEm().find(Association.class, aId);
		a.addMission(m);
		return m;
	}
	
	public void setComplete(Long mId){
		Mission m = this.getFromId(Mission.class, mId.toString());
		
		m.setStatus(Status.COMPLETE);
		
		this.getEm().flush();
	}
	
	public void setArchive(String mId){
		Mission m = this.getFromId(Mission.class, mId);
		
		m.setStatus(Status.ARCHIVE);
		
		this.getEm().flush();
	}
	
	public boolean checkArchive(String mId){
		Query query = this.getEm().createQuery("from " +InscriptionMission.class.getName()+ " WHERE mission_id = " + mId + "AND status = 0");
		return query.getResultList().isEmpty();
	}
	
	/**
	 * Met à jour la mission dans la BDD
	 * @param mission
	 */
	public void update(Mission mission){
		Mission m = this.getFromId(Mission.class, mission.getId().toString());
		m.setAssociation(mission.getAssociation());
		m.setCategorie(mission.getCategorie());
		m.setDateDebut(mission.getDateDebut());
		m.setDateFin(mission.getDateFin());
		m.setDelaiInscription(mission.getDelaiInscription());
		m.setDescription(mission.getDescription());
		m.setEvenement(mission.getEvenement());
		m.setInscriptionsMissions(mission.getInscriptionsMissions());
		m.setLieu(mission.getLieu());
		m.setNombreBenevoles(mission.getNombreBenevoles());
		m.setTitre(mission.getTitre());
		m.setTypeMission(mission.getTypeMission());
		
		this.getEm().flush();
	}
}