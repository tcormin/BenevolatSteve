package org.benevolat.project.controller;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.benevolat.project.service.FormationService;

@RequestScoped
@Named("newFormationView")
public class NewFormationView implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8829761210752205475L;
	
	@Inject
	private FormationService formationService;
	
	private String progressString = "Fill the form please";
	
	private String name;
	private String success = "";

	public String getProgressString() {
		return progressString;
	}

	public void setProgressString(String progressString) {
		this.progressString = progressString;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSuccess() {
		return success;
	}

	public void setSuccess(String success) {
		this.success = success;
	}

	public void record() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Successfully changed!", "Successfully changed!"));
        this.success = "success";
        System.out.println(this.success.isEmpty());
    }
    
}
