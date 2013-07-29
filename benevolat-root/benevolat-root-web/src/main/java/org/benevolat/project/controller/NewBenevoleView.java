package org.benevolat.project.controller;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.benevolat.project.model.Benevole;
import org.benevolat.project.service.BenevoleService;

@RequestScoped
@Named("newBenevoleView")
public class NewBenevoleView implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1127340180998168006L;

	@Inject
	private BenevoleService benevoleService;
	
	private Benevole b;
	private String progressString = "Fill the form please";
	private String success;
	private boolean nouveau = true;
	
	public NewBenevoleView(){
		b = new Benevole();
	}
	
	public void record() {
		
		this.benevoleService.save(b);
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
