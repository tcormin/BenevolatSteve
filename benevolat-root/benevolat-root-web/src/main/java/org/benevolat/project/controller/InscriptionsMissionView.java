package org.benevolat.project.controller;

import java.io.Serializable;
import java.util.Collection;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.benevolat.project.model.InscriptionMission;
import org.benevolat.project.model.Mission;
import org.benevolat.project.service.InscriptionMissionService;
import org.benevolat.project.service.MissionService;

/**
 * CONTROLEUR profile inscriptionsMission
 * 
 * @author tcormin
 */
@SessionScoped
@Named("inscriptionsMissionView")
public class InscriptionsMissionView implements Serializable {

	/**
	 * serial version UID
	 */
	private static final long serialVersionUID = -998019519804607972L;

	/**
	 * Service pour les événements
	 */
	@Inject
	private MissionService missionService;
	
	/**
	 * Service pour les inscriptionsMissions
	 */
	@Inject
	private InscriptionMissionService inscriptionMissionService;
	
	/** le sessionBean */
	@Inject
	private SessionBean sessionBean;
	
	/** l'inscription à la mission */
	private InscriptionMission im;
	
	/** la mission */
	private Mission mission = null;

	/**
	 * 
	 * @return les inscriptions acceptées
	 * @throws Exception
	 */
	public Collection<InscriptionMission> getInscriptionsAcceptees() throws Exception {
		return inscriptionMissionService.getInscriptionsAcceptees(this.mission);
	}
	
	/**
	 * 
	 * @return les inscriptions refusées
	 * @throws Exception
	 */
	public Collection<InscriptionMission> getInscriptionsRefusees() throws Exception {
		return inscriptionMissionService.getInscriptionsRefusees(this.mission);
	}
	
	/**
	 * 
	 * @return les inscriptions en cours (sans réponse)
	 * @throws Exception
	 */
	public Collection<InscriptionMission> getInscriptionsEnCours() throws Exception {
		return inscriptionMissionService.getInscriptionsEnCours(this.mission);
	}
	
	/**
	 * 
	 * @return les inscriptions validées comme accomplies
	 * @throws Exception
	 */
	public Collection<InscriptionMission> getInscriptionsAccomplies() throws Exception {
		return inscriptionMissionService.getInscriptionsAccomplies(this.mission);
	}

	/**
	 * 
	 * @return la mission concernée
	 */
	public Mission getMission() {
		return mission;
	}

	/**
	 * 
	 * @return l'inscriptionMission concernée
	 */
	public InscriptionMission getIm() {
		return im;
	}
	
	/**
	 * Permet de préciser quelle est l'inscription de mission à gérer, en envoyant son id
	 * @param nextInscriptionMission
	 */
	public void setNextInscriptionMission(String nextInscriptionMission) {
		this.im = inscriptionMissionService.getFromId(InscriptionMission.class, nextInscriptionMission);
	}
	/**
	 * 
	 * @param nextMission
	 */
	public void setNextMission(String nextMission) {
		this.mission = missionService.getFromId(Mission.class, nextMission);
	}

	public void accept(){
		System.out.println("ACCEPTED");
	}
	
	
		
}
