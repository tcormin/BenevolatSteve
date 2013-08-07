package org.benevolat.project.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;

import org.benevolat.project.model.Association;
import org.benevolat.project.model.Domaine;
import org.benevolat.project.model.Evenement;
import org.benevolat.project.model.Mission;
import org.benevolat.project.model.TypeMission;
import org.benevolat.project.service.AssociationService;
import org.benevolat.project.service.EvenementService;
import org.benevolat.project.service.MissionService;

@RequestScoped
@Named("newMissionView")
public class NewMissionView implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7091166290127610568L;

	@Inject
	private MissionService missionService;
	@Inject
	private AssociationService associationService;
	@Inject
	private EvenementService evenementService;
	
	@Inject
	private SessionBean sessionBean;
	
	private Mission m;
	
	private String progressString = "Fill the form please";
	private String success;
	private List<SelectItem> domainesOptions = null;
	private List<SelectItem> evenementsOptions = null;
	private String evenement;
	private String selectType;
	
	public NewMissionView(){
		this.m = new Mission();
	}
	
    @PostConstruct
    public void init() throws Exception {
    	domainesOptions = new ArrayList<SelectItem>();
    	for (Domaine domaine : Domaine.values()) {
        	domainesOptions.add(new SelectItem(domaine.toString(),domaine.toString()));
        }
    	
    	evenementsOptions = new ArrayList<SelectItem>();
    	for (Evenement e : evenementService.getEvenements()) {
    		evenementsOptions.add(new SelectItem(e.getid().toString(),e.getNom()));
        }
    }
    
	public String getSuccess() {
		return success;
	}

	public void setSuccess(String success) {
		this.success = success;
	}

	public void record() {
        
		Association a = associationService.getFromId(Association.class, this.sessionBean.getUser().getid().toString());
		m.setAssociation(a);
		a.addMission(m);
		missionService.save(m);
		this.success = "ok";
		 
		if(!this.success.isEmpty()){
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Enregistrement réussi!", "Enregistrement réussi!"));
		}
		// return "profileMission";
    }

	public List<SelectItem> getDomainesOptions() {
		return domainesOptions;
	}

	public void setDomainesOptions(List<SelectItem> domainesOptions) {
		this.domainesOptions = domainesOptions;
	}

	public String getProgressString() {
		return progressString;
	}

	public void setProgressString(String progressString) {
		this.progressString = progressString;
	}

	public Mission getM() {
		return m;
	}

	public void setM(Mission m) {
		this.m = m;
	}

	public void selectType(String s) {
        if(s.equalsIgnoreCase("R")) {
            this.m.setTypeMission(TypeMission.REGULIERE); 
        }
        if(s.equalsIgnoreCase("P")) {
        	this.m.setTypeMission(TypeMission.PONCTUELLE); 
        }
    }

	public String getSelectType() {
		return selectType;
	}

	public void setSelectType(String selectType) {
		this.selectType = selectType;
        if(selectType.equalsIgnoreCase("R")) {
            this.m.setTypeMission(TypeMission.REGULIERE); 
        }
        if(selectType.equalsIgnoreCase("P")) {
        	this.m.setTypeMission(TypeMission.PONCTUELLE);
        }
	}

	public List<SelectItem> getEvenementsOptions() {
		return evenementsOptions;
	}

	public void setEvenementsOptions(List<SelectItem> evenementsOptions) {
		this.evenementsOptions = evenementsOptions;
	}

	public String getEvenement() {
		return evenement;
	}

	public void setEvenement(String evenement) {
		if(!evenement.isEmpty()){
			this.m.setEvenement(evenementService.getFromId(Evenement.class, evenement));
		}else{
			this.m.setEvenement(null);
		}
	}
	 
}
