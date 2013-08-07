package org.benevolat.project.controller;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.benevolat.project.model.Mission;
import org.benevolat.project.service.MissionService;

/**
 * CONTROLEUR allMissions
 * 
 * @author tcormin
 */
@RequestScoped
@Named("allMissionsView")
public class AllMissionsView implements Serializable{

	/**
	 * serial version UID
	 */
	private static final long serialVersionUID = -3297688869116450946L;

<<<<<<< HEAD
	/**
	 * Service pour les missions
	 */
=======
>>>>>>> 014a35e93a94e6ef8b908689f9e45c5c29b6055d
	@Inject
	MissionService missionService;
	
	/**
	 * Type de mission au format String pour l'affichage.
	 * Permet de sélectionner seulement les régulières/ponctuelles
	 */
	private String type="";

	/**
	 * 
	 * @return toutes les missions régulière depuis la DB
	 * @throws Exception
	 */
	public List<Mission> getMissionsRegulieres() throws Exception {
		return missionService.getMissionsRegulieres();
	}

	/**
	 * 
	 * @return toutes les missions ponctuelles depuis la DB
	 * @throws Exception
	 */
	public List<Mission> getMissionsPonctuelles() throws Exception {
		return missionService.getMissionsPonctuelles();
	}

	/**
	 * 
	 * @return toutes les missions régulière/ponctuelles/toutes selon le type depuis la DB
	 * @throws Exception
	 */
	public List<Mission> getMissions() throws Exception {
		if(type.equalsIgnoreCase("")){
			return missionService.getMissions();}
		if(type.equalsIgnoreCase("ponctuelles")){
			return missionService.getMissionsPonctuelles();}
		if(type.equalsIgnoreCase("regulieres")){
			return missionService.getMissionsRegulieres();}
		return null;
	}

	/**
	 * 
	 * @return le type
	 */
	public String getType() {
		return type;
	}
	/**
	 * 
	 * @param type
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * Setter qui met le type à PONCTUELLES et qui renvoie l'action allMissions
	 * @return
	 */
	public String ponctuelles(){
		this.setType("ponctuelles");
		return "allMissions";
	}
	/**
	 * Setter qui met le type à REGULIERES et qui renvoie l'action allMissions
	 * @return
	 */
	public String regulieres(){
		this.setType("regulieres");
		return "allMissions";
	}
	
}
