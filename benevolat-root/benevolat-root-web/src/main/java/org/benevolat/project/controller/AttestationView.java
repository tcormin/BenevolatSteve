package org.benevolat.project.controller;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.benevolat.project.model.InscriptionMission;
import org.benevolat.project.service.InscriptionMissionService;

/**
 * CONTROLEUR allAttestations
 * 
 * @author tcormin
 */
@RequestScoped
@Named("attestationView")
public class AttestationView implements Serializable{

	/**
	 * serial version UID
	 */
	private static final long serialVersionUID = 7091166290127610568L;

	/**
	 * Service pour les associations
	 */
	@Inject
	private InscriptionMissionService inscriptionMissionService;
	
	/**
	 * l'inscription mission qui contient la mission pour l'attestation
	 */
	private InscriptionMission i;

	/**
	 * Permet de préciser quelle est l'inscription que l'on va afficher, en envoyant son id
	 * @param nextInscriptionMission
	 */
	public void setNextInscriptionMission(String nextInscriptionMission) {
		this.i =inscriptionMissionService.getFromId(InscriptionMission.class, nextInscriptionMission);
	}

	/**
	 * 
	 * @return l'inscription
	 */
	public InscriptionMission getI() {
		return i;
	}

	/**
	 * 
	 * @param i
	 */
	public void setI(InscriptionMission i) {
		this.i = i;
	}
	
}
