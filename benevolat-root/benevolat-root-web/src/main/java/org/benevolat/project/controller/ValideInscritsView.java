package org.benevolat.project.controller;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.benevolat.project.model.InscriptionMission;
import org.benevolat.project.service.InscriptionMissionService;

/**
 * CONTROLEUR profile mission
 * 
 * @author tcormin
 */
@SessionScoped
@Named("valideInscritsView")
public class ValideInscritsView implements Serializable {


	/** serialVersionUID */
	private static final long serialVersionUID = -2626975029887195991L;
	
	/** Service pour les inscriptions missions */
	@Inject
	private InscriptionMissionService inscriptionMissionService;

	private String commentaire;
	private String idInscription;
	
	public ValideInscritsView(){
		System.out.println("Constructeur");
	}
	
	public void setAcceptInscription(String acceptInscription) {
		inscriptionMissionService.accept(acceptInscription, commentaire);
		inscriptionMissionService.checkComplete(acceptInscription);
		this.commentaire = "";
	}
	
	public void setRefuseInscription(String refuseInscription) {
		inscriptionMissionService.refuse(refuseInscription, commentaire);
		this.commentaire = "";
	}

	public void setPresentInscrit(String presentInscription) {
		inscriptionMissionService.present(presentInscription);
		inscriptionMissionService.checkArchive(presentInscription);
	}
	
	public void setAbsentInscrit(String absentInscription) {
		inscriptionMissionService.absent(absentInscription);
		inscriptionMissionService.checkArchive(absentInscription);
	}
	
	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		if(commentaire.length()>0){
			this.commentaire = commentaire;
		}
		System.out.println(this.commentaire);
	}

	public String getIdInscription() {
		return idInscription;
	}

	public void setIdInscription(String id) {
		this.idInscription = id;
	}
	
	
}
