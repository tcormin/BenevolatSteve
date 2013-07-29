package org.benevolat.project.controller;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.benevolat.project.model.Mission;
import org.benevolat.project.service.MissionService;

@RequestScoped
@Named("allMissionsView")
public class AllMissionsView implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3297688869116450946L;

	//@ManagedProperty(value = "sessionBean")
	@Inject
	MissionService missionService;
	
	private String type="";

	public List<Mission> getMissionsRegulieres() throws Exception {
		return missionService.getMissionsRegulieres();
	}

	public List<Mission> getMissionsPonctuelles() throws Exception {
		return missionService.getMissionsPonctuelles();
	}

	public List<Mission> getMissions() throws Exception {
		if(type == ""){return missionService.getMissions();}
		if(type == "ponctuelles"){return missionService.getMissionsPonctuelles();}
		if(type == "regulieres"){return missionService.getMissionsRegulieres();}
		return null;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String ponctuelles(){
		this.setType("ponctuelles");
		return "allMissions";
	}
	
	public String regulieres(){
		this.setType("regulieres");
		return "allMissions";
	}
	
}
