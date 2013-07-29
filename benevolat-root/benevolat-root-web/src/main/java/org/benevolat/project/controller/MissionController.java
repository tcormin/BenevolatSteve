package org.benevolat.project.controller;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import org.benevolat.project.model.Mission;
import org.benevolat.project.service.MissionService;


@Model
public class MissionController implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private MissionService missionService;
	
	private Mission mission;
	
	public MissionController(){
		mission = new Mission();
	}
	
	public Mission getMission() {
		return mission;
	}
	
	public void setMission(Mission mission) {
		this.mission = mission;
	}
	
	public void setMemberRegistration(MissionService missionService) {
		this.missionService = missionService;
	}
	
	public void addData() throws Exception {
		missionService.setData(mission);
	}
	
	public List<Mission> getMissions() throws Exception {
		List<Mission> m =  missionService.getMissions();
		return m;
	}
	
	public Mission getOneMission() throws Exception {	
		Mission m = missionService.getMissions().get(0);
		return m;
	}
	
}
