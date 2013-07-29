package org.benevolat.project.controller;

import java.io.Serializable;
import java.util.Collection;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.benevolat.project.model.InscriptionMission;
import org.benevolat.project.model.Mission;
import org.benevolat.project.service.InscriptionMissionService;
import org.benevolat.project.service.MissionService;

@RequestScoped
@Named("inscriptionsMissionView")
public class InscriptionsMissionView implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -998019519804607972L;

	@Inject
	private MissionService missionService;
	@Inject
	private InscriptionMissionService inscriptionMissionService;
	@Inject
	private SessionBean sessionBean;
	
	private InscriptionMission im;
	
	private Mission mission = null;

	public Collection<InscriptionMission> getInscriptionsAcceptees() throws Exception {
		return inscriptionMissionService.getInscriptionsAcceptees(this.mission);
	}
	public Collection<InscriptionMission> getInscriptionsRefusees() throws Exception {
		return inscriptionMissionService.getInscriptionsRefusees(this.mission);
	}
	public Collection<InscriptionMission> getInscriptionsEnCours() throws Exception {
		return inscriptionMissionService.getInscriptionsEnCours(this.mission);
	}
	public Collection<InscriptionMission> getInscriptionsAccomplies() throws Exception {
		return inscriptionMissionService.getInscriptionsAccomplies(this.mission);
	}

	public Mission getMission() {
		return mission;
	}

	public InscriptionMission getIm() {
		return im;
	}
	
	public void setNextInscriptionMission(String nextInscriptionMission) {
		System.out.println("Id = " + nextInscriptionMission);
		this.im = inscriptionMissionService.getFromId(InscriptionMission.class, nextInscriptionMission);
	}
	
	public void setNextMission(String nextMission) {
		this.mission = missionService.getFromId(Mission.class, nextMission);
	}

	public void accept(){
		System.out.println("ACCEPTED");
	}
	
	
		
}
