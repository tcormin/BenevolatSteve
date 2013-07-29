package org.benevolat.project.model;
import java.util.Date;


public class InscriptionFormation {

	private Benevole benevole;
	private Formation formation;
	private Date dateInscrition;
	private Status status;
	private String commentaire;
	
	public Benevole getBenevole() {
		return benevole;
	}
	public void setBenevole(Benevole benevole) {
		this.benevole = benevole;
	}
	public Formation getFormation() {
		return formation;
	}
	public void setFormation(Formation formation) {
		this.formation = formation;
	}
	public Date getDateInscrition() {
		return dateInscrition;
	}
	public void setDateInscrition(Date dateInscrition) {
		this.dateInscrition = dateInscrition;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public String getCommentaire() {
		return commentaire;
	}
	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}
	
}
