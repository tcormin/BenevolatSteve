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
import org.benevolat.project.model.Evenement;
import org.benevolat.project.model.Image;
import org.benevolat.project.service.AssociationService;
import org.benevolat.project.service.EvenementService;
import org.benevolat.project.service.ImageService;
import org.richfaces.event.FileUploadEvent;
import org.richfaces.model.UploadedFile;

@RequestScoped
@Named("newEvenementView")
public class NewEvenementView implements Serializable{

	/** serialVersionUID */
	private static final long serialVersionUID = 1127340180998168006L;

	@Inject
	private EvenementService evenementService;
	@Inject
	private AssociationService associationService;
	@Inject
	private ImageService imageService;
	@Inject
	private SessionBean sessionBean;
	@Inject
	EvenementView evenementView;
	
	private Evenement e;
	private String progressString = "Fill the form please";
	private String success;
	private String organisateur;
	
	private List<SelectItem> associationsOptions = null;
	
	public NewEvenementView(){
	}
	
    @PostConstruct
    public void init() throws Exception {
		if(sessionBean.getModify() == 0){
			this.e = new Evenement();
		}else{
			this.e = evenementService.getFromId(Evenement.class, sessionBean.getModify().toString());
		}
		
    	associationsOptions = new ArrayList<SelectItem>();
    	for (Association a : associationService.getAssociations()) {
    		associationsOptions.add(new SelectItem(a.getid().toString(),a.getNom()));
        }
    }
    
	public void record() {
		this.success = e.getNom();
		
		if(sessionBean.getModify() == 0){
			this.e.setImage(this.imageService.getFromId(Image.class, "1"));
			this.evenementService.save(e);
		}else{
			evenementService.update(e);
		}
		
		this.e = evenementService.getFromNom(this.success);
		
		if(!this.success.isEmpty()){
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Enregistrement réussi!", "Enregistrement réussi!"));
		}
		// return "profileEvenement";
    }
	
	public String getDefaultLabelOptions(){
		if(this.e.getOrganisateur() == null){
			return "Tapez ou choisissez";
		}
		return this.e.getOrganisateur().getNom();
	}
	
	public String getProgressString() {
		return progressString;
	}

	public void setProgressString(String progressString) {
		this.progressString = progressString;
	}

	public String getSuccess() {
		return success;
	}

	public void setSuccess(String success) {
		this.success = success;
	}

	public Evenement getE() {
		return e;
	}

	public void setE(Evenement e) {
		this.e = e;
	}

	public List<SelectItem> getAssociationsOptions() {
		return associationsOptions;
	}

	public void setAssociationsOptions(List<SelectItem> associationsOptions) {
		this.associationsOptions = associationsOptions;
	}
	
	public void setOrganisateur(String organisateur){
		if(!organisateur.isEmpty()){
			this.e.setOrganisateur(associationService.getFromId(Association.class, organisateur));
		}else{
			this.e.setOrganisateur(null);
		}
	}

	public String getOrganisateur() {
		return organisateur;
	}
	

}
