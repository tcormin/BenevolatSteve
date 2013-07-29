package org.benevolat.project.controller;

import java.io.Serializable;
import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.benevolat.project.model.Association;
import org.benevolat.project.model.Benevole;
import org.benevolat.project.model.InscriptionMission;
import org.benevolat.project.model.Mission;
import org.benevolat.project.service.InscriptionMissionService;
import org.benevolat.project.service.MissionService;

@RequestScoped
@Named("myMissionsView")
public class MyMissionsView implements Serializable {

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
	
	private Mission mission;
	
	@PostConstruct
	public void init() {
//		this.utilisateur = this.sessionBean.getgUtilisateurs().getDaoBenevole().getBenevoles().get(0);
//		if (utilisateur.getClass() == Benevole.class){
//			Benevole b = (Benevole) this.utilisateur;
//			Iterator<InscriptionMission> itr = b.getInscriptionsMissions().iterator();
//			InscriptionMission i;
//			while(itr.hasNext()){
//				i=itr.next();
//				if(i.getStatus() == Status.EN_COURS){
//					missionsEnCours.add(i);
//				}
//				if(i.getStatus() == Status.REFUSE){
//					missionsRefusees.add(i);
//				}
//				if(i.getStatus() == Status.ACCEPTE){
//					missionsAcceptees.add(i);
//				}
//				if(i.getStatus() == Status.ACCOMPLIE){
//					missionsAccomplies.add(i);
//				}
//			}
//		}
	}

	public Collection<InscriptionMission> getMissionsAcceptees() throws Exception {
		return inscriptionMissionService.getMyMissionsAcceptees((Benevole) sessionBean.getUser());
	}
	public Collection<InscriptionMission> getMissionsRefusees() throws Exception {
		return inscriptionMissionService.getMyMissionsRefusees((Benevole) sessionBean.getUser());
	}
	public Collection<InscriptionMission> getMissionsEnCours() throws Exception {
		return inscriptionMissionService.getMyMissionsEnCours((Benevole) sessionBean.getUser());
	}
	public Collection<InscriptionMission> getMissionsAccomplies() throws Exception {
		return inscriptionMissionService.getMyMissionsAccomplies((Benevole) sessionBean.getUser());
	}
	public Collection<Mission> getMissionsCompletes() throws Exception {
		return missionService.getMyMissionsCompletes((Association) sessionBean.getUser());
	}
	public Collection<Mission> getMissionsIncompletes() throws Exception {
		return missionService.getMyMissionsCompletes((Association) sessionBean.getUser());
	}
	public Collection<Mission> getMissionsTerminees() throws Exception {
		return missionService.getMyMissionsCompletes((Association) sessionBean.getUser());
	}
	public Collection<Mission> getMissionsArchives() throws Exception {
		return missionService.getMyMissionsCompletes((Association) sessionBean.getUser());
	}

	public Mission getMission() {
		return mission;
	}

	public void setMission(Mission mission) {
		this.mission = mission;
	}

	public void setNextMission(String nextMission) {
		System.out.println("Id : "+nextMission);
		this.mission =missionService.getFromId(Mission.class, nextMission);
	}
	
		
}
