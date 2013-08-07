package org.benevolat.project.controller;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.benevolat.project.model.Association;
import org.benevolat.project.model.Evenement;
import org.benevolat.project.model.Mission;
import org.benevolat.project.service.AssociationService;
import org.benevolat.project.service.BenevoleService;
import org.benevolat.project.service.EvenementService;
import org.benevolat.project.service.MissionService;

@SessionScoped
@Named("searchView")
public class SearchView implements Serializable {

	private static final long serialVersionUID = -7083396080063284495L;

	@Inject
	private AssociationService associationService;
	@Inject
	private BenevoleService benevoleService;
	@Inject
	private MissionService missionService;
	@Inject
	private EvenementService evenementService;
	
	private boolean evenementsEmpty = true;
	private boolean missionsPonctuellesEmpty  = true;
	private boolean associationsEmpty  = true;
	private boolean missionsRegulieresEmpty  = true;
	private String searchText;//="";

	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}

	public String getSearchText() {
		return searchText;
	}
	
	public List<Evenement> getEvenements(){
		if(searchText.length() > 0){
			List<Evenement> le = this.evenementService.search(this.searchText);
			this.setEvenementsEmpty(le.size() == 0);
			return le;
		}
		this.setEvenementsEmpty(true);
		return null;
	}
	
	public List<Association> getAssociations(){
		if(searchText.length() > 0){
			List<Association> la = this.associationService.search(this.searchText);
			this.setAssociationsEmpty(la.size() == 0);
			return la;
		}
		this.setAssociationsEmpty(true);
		return null;
	}
	
	public List<Mission> getMissionsPonctuelles(){
		if(searchText.length() > 0){
			List<Mission> lm = this.missionService.searchPonctuelles(this.searchText);
			this.setMissionsPonctuellesEmpty(lm.size() == 0);
			return lm;
		}
		this.setMissionsPonctuellesEmpty(true);
		return null;
	}
	
	public List<Mission> getMissionsRegulieres(){
		if(searchText.length() > 0){
			List<Mission> lm = this.missionService.searchRegulieres(this.searchText);
			this.setMissionsRegulieresEmpty(lm.size() == 0);
			return lm;
		}
		this.setMissionsRegulieresEmpty(true);
		return null;
	}

	public boolean isEvenementsEmpty() {
		System.out.println("Evenement IS EMPTY ???? " + evenementsEmpty );
		return evenementsEmpty;
	}

	public void setEvenementsEmpty(boolean evenementsEmpty) {
		this.evenementsEmpty = evenementsEmpty;
	}

	public boolean isMissionsPonctuellesEmpty() {
		return missionsPonctuellesEmpty;
	}

	public void setMissionsPonctuellesEmpty(boolean missionsPonctuellesEmpty) {
		this.missionsPonctuellesEmpty = missionsPonctuellesEmpty;
	}

	public boolean isAssociationsEmpty() {
		return associationsEmpty;
	}

	public void setAssociationsEmpty(boolean associationsEmpty) {
		this.associationsEmpty = associationsEmpty;
	}

	public boolean isMissionsRegulieresEmpty() {
		return missionsRegulieresEmpty;
	}

	public void setMissionsRegulieresEmpty(boolean missionsRegulieresEmpty) {
		this.missionsRegulieresEmpty = missionsRegulieresEmpty;
	}
	
	public String launchSearch(){
		return "search";
	}
}
