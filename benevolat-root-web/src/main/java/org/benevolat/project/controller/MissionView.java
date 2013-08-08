package org.benevolat.project.controller;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.benevolat.project.model.Benevole;
import org.benevolat.project.model.InscriptionMission;
import org.benevolat.project.model.Mission;
import org.benevolat.project.service.BenevoleService;
import org.benevolat.project.service.InscriptionMissionService;
import org.benevolat.project.service.MissionService;

/**
 * CONTROLEUR profile mission
 * 
 * @author tcormin
 */
@SessionScoped
@Named("missionView")
public class MissionView implements Serializable{

	/** serialVersionUID */
	private static final long serialVersionUID = 7091166290127610568L;

	/** Service pour les missions */
	@Inject
	private MissionService missionService;
	
	/** Service pour les bénévoles */
	@Inject
	private BenevoleService benevoleService;
	
	/** Service pour les inscriptions */
	@Inject
	private InscriptionMissionService inscriptionMissionService;
	
	/** le session bean	 */
	@Inject
	private SessionBean sessionBean;
	
	/**
	 * Mission que l'on va afficher
	 */
	private Mission m;

	/**
	 * 
	 * @return la mission
	 */
	public Mission getM() {
		return m;
	}

	/**
	 * 
	 * @param m
	 */
	public void setM(Mission m) {
		this.m = m;
	}

	/**
	 * 
	 * @param nextMission
	 */
	public void setNextMission(String nextMission) {
		this.m =missionService.getFromId(Mission.class, nextMission);
	}
	
	/**
	 * Supprime la mission de la DB
	 * @return l'action allMissions
	 */
	public String delete(){
		missionService.removeFromId(Mission.class, this.m.getId().toString());
		return "allMissions";
	}
	
	public String inscrire(){
		InscriptionMission im = new InscriptionMission();
		Benevole b = benevoleService.getFromId(Benevole.class, sessionBean.getUser().getid().toString());
		
		im.setBenevole(b);
		b.addInscriptionsMissions(im);
		im.setMission(this.m);
		m.addInscriptionsMissions(im);
		
		inscriptionMissionService.save(im);
		
		return "myMissionsBenevole";
	}
	
}
