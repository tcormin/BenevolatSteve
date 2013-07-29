package org.benevolat.project.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;

import org.benevolat.project.model.Domaine;
import org.benevolat.project.model.Evenement;
import org.benevolat.project.model.Mission;
import org.benevolat.project.model.TypeMission;
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
	
	private String progressString = "Fill the form please";
	
	private String titre;
	private Date dateDebut;
	private Date dateFin;
	private int nombreBenevoles = 1;
	private Date delaiInscription;
	private String description;
	private String lieu;
	private Domaine categorie;
	private Evenement evenement;
	private int id=54;
	private String success;
	private List<SelectItem> domainesOptions = null;
	private TypeMission typeMission;
	private String selectType;
	
	public NewMissionView(){
	}
	
    @PostConstruct
    public void init() {
    	domainesOptions = new ArrayList<SelectItem>();
    	for (Domaine domaine : Domaine.values()) {
        	domainesOptions.add(new SelectItem(domaine.toString(),domaine.toString()));
        }
    }
    
	public String getSuccess() {
		return success;
	}

	public void setSuccess(String success) {
		this.success = success;
	}

	public String getLieu() {
		return lieu;
	}

	public void setLieu(String lieu) {
		this.lieu = lieu;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getid() {
		return id;
	}

	public void setid(int id) {
		this.id = id;
	}
	
	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public int getNombreBenevoles() {
		return nombreBenevoles;
	}

	public void setNombreBenevoles(int nombreBenevoles) {
		this.nombreBenevoles = nombreBenevoles;
	}

	public Date getDelaiInscription() {
		return delaiInscription;
	}

	public void setDelaiInscription(Date delaiInscription) {
		this.delaiInscription = delaiInscription;
	}

	public Domaine getCategorie() {
		return categorie;
	}

	public void setCategorie(Domaine categorie) {
		this.categorie = categorie;
	}

	public Evenement getEvenement() {
		return evenement;
	}

	public void setEvenement(Evenement evenement) {
		this.evenement = evenement;
	}

	public void record() {
		
//        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Successfully changed!", "Successfully changed!"));
//        this.success = "success";
//        System.out.println(this.success.isEmpty());
        
		
		Mission m = new Mission();
		m.setTitre(titre);
		m.setDescription(description);
		m.setLieu(lieu);
		//this.sessionBean.getgMissions().getDaoMission().getMissions().add(m);
		//int i = this.sessionBean.getNextFreeId();
		this.success = "ok";
		 
		 
		if(dateDebut.after(dateFin)){
			FacesContext.getCurrentInstance().addMessage(null,
				 new FacesMessage(FacesMessage.SEVERITY_ERROR, "La date de fin ne peut pas précéder la date de début !", "Enregistrement réussi!"));
			this.success = "";
			System.out.println("Date fin");
		}
		if(this.delaiInscription.after(dateDebut)){
			FacesContext.getCurrentInstance().addMessage(null,
				 new FacesMessage(FacesMessage.SEVERITY_ERROR, "La date de délai ne peut pas être après la date de début !", "Enregistrement réussi!"));
			this.success = "";
		}
		 
		System.out.println(this.success);
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

    public TypeMission getType() {
		return typeMission;
	}

	public void setType(TypeMission type) {
		this.typeMission = type;
	}

	//public void selectType(ValueChangeEvent event) {
	public void selectType(String s) {
        //String tLocale = (String) event.getNewValue();
        if(s == "R") {
            this.typeMission = TypeMission.REGULIERE; 
        }
        if(s == "P") {
        	this.typeMission = TypeMission.PONCTUELLE;
        }
    }

	public TypeMission getTypeMission() {
		return typeMission;
	}

	public void setTypeMission(TypeMission typeMission) {
		this.typeMission = typeMission;
	}

	public String getSelectType() {
		return selectType;
	}

	public void setSelectType(String selectType) {
		this.selectType = selectType;
        if(selectType == "R") {
            this.typeMission = TypeMission.REGULIERE; 
        }
        if(selectType == "P") {
        	this.typeMission = TypeMission.PONCTUELLE;
        }
	}
	 
}
