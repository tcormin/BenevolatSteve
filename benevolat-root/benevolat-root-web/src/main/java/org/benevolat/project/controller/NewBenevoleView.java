package org.benevolat.project.controller;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;

import org.benevolat.project.model.Association;
import org.benevolat.project.model.Benevole;
import org.benevolat.project.model.Domaine;
import org.benevolat.project.model.Image;
import org.benevolat.project.service.BenevoleService;
import org.benevolat.project.service.ImageService;

@RequestScoped
@Named("newBenevoleView")
public class NewBenevoleView implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1127340180998168006L;

	@Inject
	private BenevoleService benevoleService;
	
	@Inject
	private ImageService imageService;
	
	@Inject
	private SessionBean sessionBean;
	
	private Benevole b;
	private String progressString = "Fill the form please";
	private String success;
	
	public NewBenevoleView(){
	}
	
    @PostConstruct
    public void init() {
		if(sessionBean.getModify() == 0){
			this.b = new Benevole();
		}else{
			this.b = benevoleService.getFromId(Benevole.class, sessionBean.getModify().toString());
		}
		
    }
    
	public void record() {
		
		if(sessionBean.getModify() == 0){
			this.b.setImage(this.imageService.getFromId(Image.class, "2"));
			this.benevoleService.save(b);
		}else{
			benevoleService.update(b);
		}
		
		
		//int i = this.sessionBean.getNextFreeId();
		this.success = "ok";

		if(!this.success.isEmpty()){
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Enregistrement réussi!", "Enregistrement réussi!"));
		}
		// return "profileAssociation";
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

	public Benevole getB() {
		return b;
	}

	public void setB(Benevole b) {
		this.b = b;
	}
	
	

}
