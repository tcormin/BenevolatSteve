package org.benevolat.project.controller;

import java.io.Serializable;
import java.util.Collection;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.benevolat.project.model.Association;
import org.benevolat.project.model.Benevole;
import org.benevolat.project.model.InscriptionMission;
import org.benevolat.project.model.Mission;
import org.benevolat.project.service.AssociationService;
import org.benevolat.project.service.BenevoleService;
import org.benevolat.project.service.InscriptionMissionService;
import org.benevolat.project.service.MissionService;

/**
 * CONTROLEUR profile mission
 * 
 * @author tcormin
 */
@SessionScoped
@Named("myMissionsView")
public class MyMissionsView implements Serializable {

	/** serialVersionUID */
	private static final long serialVersionUID = -998019519804607972L;

	/** Service pour les missions */
	@Inject
	private MissionService missionService;
	
	/** Service pour les inscriptions missions */
	@Inject
	private InscriptionMissionService inscriptionMissionService;
	
	/** sessionBean */
	@Inject
	private SessionBean sessionBean;
	
	@Inject
	private AssociationService associationService;
	
	@Inject
	private BenevoleService benevoleService;
	
	
	/** mission à afficher */
	private Mission mission;
	
	private Benevole b;
	private Association a;
	
	/**
	 * 
	 * @return les missions acceptées de l'utilisateur si c'est un bénévole
	 * @throws Exception
	 */
	public Collection<InscriptionMission> getMissionsAcceptees() throws Exception {
		return inscriptionMissionService.getMyMissionsAcceptees(b);
	}
	
	/**
	 * 
	 * @return les missions refusées de l'utilisateur si c'est un bénévole
	 * @throws Exception
	 */
	public Collection<InscriptionMission> getMissionsRefusees() throws Exception {
		return inscriptionMissionService.getMyMissionsRefusees(b);
	}
	
	/**
	 * 
	 * @return les missions en cours de l'utilisateur si c'est un bénévole
	 * @throws Exception
	 */
	public Collection<InscriptionMission> getMissionsEnCours() throws Exception {
		return inscriptionMissionService.getMyMissionsEnCours(b);
	}
	/**
	 * 
	 * @return les missions accomplies de l'utilisateur si c'est un bénévole
	 * @throws Exception
	 */
	public Collection<InscriptionMission> getMissionsAccomplies() throws Exception {
		return inscriptionMissionService.getMyMissionsAccomplies(b);
	}
	
	/**
	 * 
	 * @return les missions complètes de l'utilisateur si c'est une association
	 * @throws Exception
	 */
	public Collection<Mission> getMissionsCompletes() throws Exception {
		return missionService.getMyMissionsCompletes(a);
	}
	
	/**
	 * 
	 * @return les missions incomplètes de l'utilisateur si c'est une association
	 * @throws Exception
	 */
	public Collection<Mission> getMissionsIncompletes() throws Exception {
		return missionService.getMyMissionsIncompletes(a);
	}
	
	/**
	 * 
	 * @return les missions terminées de l'utilisateur si c'est une association, càd où l'association doit encore confirmer la présence des gens
	 * @throws Exception
	 */
	public Collection<Mission> getMissionsTerminees() throws Exception {
		return missionService.getMyMissionsTerminees(a);
	}
	
	/**
	 * 
	 * @return les missions archives de l'utilisateur si c'est une association
	 * @throws Exception
	 */
	public Collection<Mission> getMissionsArchives() throws Exception {
		return missionService.getMyMissionsArchives(a);
	}

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
		this.mission =missionService.getFromId(Mission.class, nextMission);
	}
	
	/**
	 * Permet de préciser quelle est le bénévole que l'on va afficher, en envoyant son id
	 * @param nextBenevole
	 */
	public void setNextAssociation(String nextAssociation) {
		this.a = associationService.getFromId(Association.class, nextAssociation);
	}
	
	/**
	 * Permet de préciser quelle est le bénévole que l'on va afficher, en envoyant son id
	 * @param nextBenevole
	 */
	public void setNextBenevole(String nextBenevole) {
		this.b = benevoleService.getFromId(Benevole.class, nextBenevole);
	}

	public Benevole getB() {
		return b;
	}

	public void setB(Benevole b) {
		this.b = b;
	}

	public Association getA() {
		return a;
	}

	public void setA(Association a) {
		this.a = a;
	}	
	
}
