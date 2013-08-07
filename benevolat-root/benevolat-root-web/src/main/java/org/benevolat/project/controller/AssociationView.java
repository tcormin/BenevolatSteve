package org.benevolat.project.controller;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.benevolat.project.model.Association;
import org.benevolat.project.service.AssociationService;

@RequestScoped
@Named("associationView")
public class AssociationView implements Serializable{

	private static final long serialVersionUID = 9088185671638510312L;
	
	@Inject
	private AssociationService associationService;
	
	private Association a;
	
	public Association getA() {
		return a;
	}

	public void setA(Association a) {
		this.a = a;
	}
	
	public void setNextAssociation(String nextAssociation) {
		this.a = associationService.getFromId(Association.class, nextAssociation);
	}
	
	public String delete(){
		System.out.println("Suppression de l'association "+ this.a.getid().toString());
		associationService.removeUserFromId(this.a.getid().toString());
		return "allAssociations";
	}
	
}
