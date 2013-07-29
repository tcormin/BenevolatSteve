package org.benevolat.project.controller;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@RequestScoped
@Named("allAttestationsView")
public class AllAttestationsView implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3297688869116450946L;
	
	private int idBenevole;

	public int getIdBenevole() {
		return idBenevole;
	}

	public void setIdBenevole(int idBenevole) {
		this.idBenevole = idBenevole;
		this.load();
	}
	
	public void load(){
		
	}
	
}
