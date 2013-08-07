package org.benevolat.project.controller;

import java.io.Serializable;
import java.util.Collection;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.benevolat.project.model.InscriptionMission;
import org.benevolat.project.model.Mission;
import org.benevolat.project.model.Status;
import org.benevolat.project.service.InscriptionMissionService;
import org.benevolat.project.service.MissionService;

/**
 * CONTROLEUR profile mission
 * 
 * @author tcormin
 */
@SessionScoped
@Named("inscritsView")
public class InscritsView implements Serializable {

	/** serialVersionUID */
	private static final long serialVersionUID = -2320937072620536561L;

	/** Service pour les missions */
	@Inject
	private MissionService missionService;
	
	/** Service pour les inscriptions missions */
	@Inject
	private InscriptionMissionService inscriptionMissionService;
	
	/** sessionBean */
	@Inject
	private SessionBean sessionBean;
	
	/** mission à afficher */
	private Mission mission;
	
	private String idMission;
	private String commentaire;
	
	/**
	 * 
	 * @return la mission
	 */
	public Mission getMission() {
		return mission;
	}

	/**
	 * 
	 * @param mission
	 */
	public void setMission(Mission mission) {
		this.mission = mission;
	}

	/**
	 * 
	 * @param nextMission
	 */
	public void setNextMission(String nextMission) {
		System.out.println("Prochaine mission id :"+nextMission);
		this.mission = missionService.getFromId(Mission.class, nextMission);
	}
	
	/**
	 * 
	 * @return les inscriptions en cours
	 * @throws Exception
	 */
	public Collection<InscriptionMission> getInscriptionsEnCours() throws Exception{
		return inscriptionMissionService.getInscriptionsEnCours(this.mission);
	}
	
	/**
	 * 
	 * @return les inscriptions acceptées
	 * @throws Exception
	 */
	public Collection<InscriptionMission> getInscriptionsAcceptees() throws Exception{
		return inscriptionMissionService.getInscriptionsAcceptees(this.mission);
	}
	
	/**
	 * 
	 * @return les inscriptions refusées
	 * @throws Exception
	 */
	public Collection<InscriptionMission> getInscriptionsRefusees() throws Exception{
		return inscriptionMissionService.getInscriptionsRefusees(this.mission);
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}
	
	public int getPlacesRestantes() throws Exception{
		return this.mission.getNombreBenevoles() - this.getNombreInscriptionsAcceptees();
	}
	
	public int getNombreInscriptionsAcceptees() throws Exception{
		return this.getInscriptionsAcceptees().size();
	}
	
	public boolean isEnCours(){
		return (this.mission.getStatus() == Status.COMPLETE) || (this.mission.getStatus() == Status.INCOMPLETE);
	}
	
	public boolean isTerminee(){
		return this.mission.getStatus() == Status.TERMINEE;
	}
	
}
