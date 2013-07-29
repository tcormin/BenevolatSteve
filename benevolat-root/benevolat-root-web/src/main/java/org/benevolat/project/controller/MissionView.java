package org.benevolat.project.controller;

import java.io.Serializable;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import org.benevolat.project.model.Mission;
import org.benevolat.project.service.MissionService;

@Singleton
//@RequestScoped
@Named("missionView")
public class MissionView implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7091166290127610568L;

	@Inject
	private MissionService missionService;
	
	private Mission m;

	public Mission getM() {
		return m;
	}

	public void setM(Mission m) {
		this.m = m;
	}

	public void setNextMission(String nextMission) {
		this.m =missionService.getFromId(Mission.class, nextMission);
	}
	
	public String delete(){
		System.out.println("Suppression de la mission "+ this.m.getId().toString());
		missionService.removeFromId(Mission.class, this.m.getId().toString());
		return "allMissions";
	}
	
}
