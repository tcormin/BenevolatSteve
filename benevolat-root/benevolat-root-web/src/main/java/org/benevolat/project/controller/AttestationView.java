package org.benevolat.project.controller;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.benevolat.project.model.InscriptionMission;
import org.benevolat.project.service.InscriptionMissionService;

@RequestScoped
@Named("attestationView")
public class AttestationView implements Serializable{

	private static final long serialVersionUID = 7091166290127610568L;

	@Inject
	InscriptionMissionService inscriptionMissionService;
	
	private InscriptionMission i;

	public void setNextInscriptionMission(String nextInscriptionMission) {
		this.i =inscriptionMissionService.getFromId(InscriptionMission.class, nextInscriptionMission);
	}

	public InscriptionMission getI() {
		return i;
	}

	public void setI(InscriptionMission i) {
		this.i = i;
	}
	
	
	
}
