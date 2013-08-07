package org.benevolat.project.service;

import java.util.Collection;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.Query;

import org.benevolat.project.model.Benevole;
import org.benevolat.project.model.InscriptionMission;
import org.benevolat.project.model.Mission;
import org.benevolat.project.model.Status;

/**
 * SERVICE inscription aux missions
 * 
 * @author tcormin
 */
@Stateless
public class InscriptionMissionService extends PersistenceService{

	@Inject
	private MissionService missionService;
	
	/**
	* Enregistre l'inscription
	* @param inscriptionMission
	* @throws Exception
	*/
	public void setData(InscriptionMission inscriptionMission) throws Exception {
		save(inscriptionMission);
		this.getLog().info("InscriptionMission is registred with id: "+String.valueOf(inscriptionMission.getId()));
	}
	   
	/**
	* Récupère toutes les inscriptions
	* @return
	* @throws Exception
	*/
	public Collection<InscriptionMission> getInscriptionMission() throws Exception {
		List<InscriptionMission> f = findAll(InscriptionMission.class);
		this.getLog().info(f.size() + " inscriptionMission found");
		return f;
	}

	/**
	 * Renvoie les inscriptions du bénvole qui ont été acceptées
	 * @param b
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public Collection<InscriptionMission> getMyMissionsAcceptees(Benevole b) throws Exception {
		Query query = this.getEm().createQuery("from "+InscriptionMission.class.getName()+ " WHERE status = 0");
		return query.getResultList();	
	}

	/**
	 * Renvoie les inscriptions du bénvole qui sont en cours
	 * @param b
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public Collection<InscriptionMission> getMyMissionsEnCours(Benevole user) throws Exception {
		Query query = this.getEm().createQuery("from "+InscriptionMission.class.getName()+ " WHERE status = 1");
		return query.getResultList();
	}

	/**
	 * Renvoie les inscriptions du bénvole qui ont été refusées
	 * @param b
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public Collection<InscriptionMission> getMyMissionsRefusees(Benevole user) throws Exception {
		Query query = this.getEm().createQuery("from "+InscriptionMission.class.getName()+ " WHERE status = 2");
		return query.getResultList();
	}

	/**
	 * Renvoie les inscriptions du bénvole qui ont été accomplies
	 * @param b
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public Collection<InscriptionMission> getMyMissionsAccomplies(Benevole user) throws Exception {
		Query query = this.getEm().createQuery("from "+InscriptionMission.class.getName()+ " WHERE status = 3");
		return query.getResultList();
	}
		
	/**
	 * Renvoie les inscriptions d'une mission qui ont été acceptées
	 * @param m
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public Collection<InscriptionMission> getInscriptionsAcceptees(Mission m) throws Exception {
		Query query = this.getEm().createQuery("from "+InscriptionMission.class.getName()+ " WHERE mission_id = "+String.valueOf(m.getId()) + " and status = 0");
		return query.getResultList();
	}
		
	/**
	 * Renvoie les inscriptions d'une mission qui sont en cours
	 * @param m
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public Collection<InscriptionMission> getInscriptionsEnCours(Mission m) throws Exception {
		Query query = this.getEm().createQuery("from "+InscriptionMission.class.getName()+ " WHERE mission_id = "+String.valueOf(m.getId()) + " and status = 1");
		return query.getResultList();
	}
		
	/**
	 * Renvoie les inscriptions d'une mission qui ont été refusées
	 * @param m
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public Collection<InscriptionMission> getInscriptionsRefusees(Mission m) throws Exception {
		Query query = this.getEm().createQuery("from "+InscriptionMission.class.getName()+ " WHERE mission_id = "+String.valueOf(m.getId()) + " and status = 2");
		return query.getResultList();
	}
		
	/**
	 * Renvoie les inscriptions d'une mission qui ont été accomplies
	 * @param m
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public Collection<InscriptionMission> getInscriptionsAccomplies(Mission m) throws Exception {
		Query query = this.getEm().createQuery("from "+InscriptionMission.class.getName()+ " WHERE mission_id = "+String.valueOf(m.getId()) + " and status = 3");
		return query.getResultList();
	}
	
	/**
	 * Accepte l'inscription
	 * @param id
	 */
	public void accept(String id, String commentaire){
		InscriptionMission i = this.getFromId(InscriptionMission.class, id);
		i.setStatus(Status.ACCEPTE);
		i.setCommentaire(commentaire);
	}
	
	/**
	 * Refuse l'inscription
	 * @param id
	 */
	public void refuse(String id, String commentaire){
		InscriptionMission i = this.getFromId(InscriptionMission.class, id);
		i.setStatus(Status.REFUSE);
		i.setCommentaire(commentaire);
	}
	
	/**
	 * Annonce présent l'inscrit
	 * @param id
	 */
	public void present(String id){
		InscriptionMission i = this.getFromId(InscriptionMission.class, id);
		i.setStatus(Status.ACCOMPLIE);
	}
	
	/**
	 * Annonce absent l'inscrit
	 * @param id
	 */
	public void absent(String id){
		InscriptionMission i = this.getFromId(InscriptionMission.class, id);
		i.setStatus(Status.NONACCOMPLIE);
	}
	public void checkComplete(String id){
		Mission m = this.getFromId(InscriptionMission.class, id).getMission();
		
		m.getNombreBenevoles();
		if(m.benevolesInscrits() == m.getNombreBenevoles()){
			for (InscriptionMission im : m.getInscriptionsMissionsEnCours()) {
	        	im.setCommentaire("La mission est désormais complète");
	        	im.setStatus(Status.REFUSE);
	        }
			missionService.setComplete(m.getId());
		}
		
	}
	
	public void checkArchive(String id){
		if(missionService.checkArchive(id)){
			missionService.setArchive(id);
		}
	}
	
	/**
	 * Met à jour l'inscription dans la BDD
	 * @param inscriptionMission
	 */
	public void update(InscriptionMission inscriptionMission){
		InscriptionMission i = this.getFromId(InscriptionMission.class, inscriptionMission.getId().toString());
		i.setBenevole(inscriptionMission.getBenevole());
		i.setCommentaire(inscriptionMission.getCommentaire());
		i.setDateInscription(inscriptionMission.getDateInscription());
		i.setMission(inscriptionMission.getMission());
		i.setStatus(inscriptionMission.getStatus());
		
		this.getEm().flush();
	}
}