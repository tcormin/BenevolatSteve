package org.benevolat.project.controller;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.benevolat.project.model.Benevole;
import org.benevolat.project.service.BenevoleService;

@RequestScoped
@Named("benevoleView")
public class BenevoleView implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3733912007149394439L;
	
	@Inject
	private BenevoleService benevoleService;
	
	private Benevole b;
	
	public Benevole getB() {
		return b;
	}

	public void setB(Benevole b) {
		this.b = b;
	}
	
	public void setNextBenevole(String nextBenevole) {
		this.b = benevoleService.getFromId(Benevole.class, nextBenevole);
	}
	
	public String delete(){
		benevoleService.removeUserFromId(this.b.getid().toString());
		return "allBenevoles";
	}
	
	public String update(){
		benevoleService.update(this.b);
		return "profileBenevole";
	}
}
