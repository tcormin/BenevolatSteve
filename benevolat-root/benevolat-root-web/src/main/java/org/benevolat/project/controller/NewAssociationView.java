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
import org.benevolat.project.service.AssociationService;

@RequestScoped
@Named("newAssociationView")
public class NewAssociationView implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4916161171755017950L;

	@Inject
	private AssociationService associationService;
	
	private String progressString = "Fill the form please";
	private String success;
	Association a;
	private List<SelectItem> domainesOptions = null;
	
	public NewAssociationView(){
		this.a = new Association();
	}
	
    @PostConstruct
    public void init() {
    	domainesOptions = new ArrayList<SelectItem>();
    	for (Domaine domaine : Domaine.values()) {
        	domainesOptions.add(new SelectItem(domaine.toString(),domaine.toString()));
        }
    }

	public void record() {
		
		associationService.save(a);
		//int i = this.sessionBean.getNextFreeId();
		this.success = "ok";

		if(!this.success.isEmpty()){
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Enregistrement réussi!", "Enregistrement réussi!"));
		}
		// return "profileAssociation";
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

	public String getSuccess() {
		return success;
	}

	public void setSuccess(String success) {
		this.success = success;
	}

	public Association getA() {
		return a;
	}

	public void setA(Association a) {
		this.a = a;
	}

}
