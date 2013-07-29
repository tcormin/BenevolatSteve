package org.benevolat.project.model;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity(name="inscriptionmission")
public class InscriptionMission implements Serializable{
	
	private static final long serialVersionUID = 2864348058409385170L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private Benevole benevole;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private Mission mission;
	
	private Date dateInscription = new Date();
	private Status status;
	private String commentaire;
	
	public Benevole getBenevole() {
		return benevole;
	}
	public void setBenevole(Benevole benevole) {
		this.benevole = benevole;
	}
	public Mission getMission() {
		return mission;
	}
	public void setMission(Mission mission) {
		this.mission = mission;
	}
	public Date getDateInscription() {
		return dateInscription;
	}
	public String dateInscription() {
		SimpleDateFormat formater = new SimpleDateFormat("d.MM.yyyy");
		return formater.format(dateInscription);
	}
	public void setDateInscription(Date dateInscription) {
		this.dateInscription = dateInscription;
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
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setSelectReponse(String selectReponse) {
        if(selectReponse == "A") {
            this.status = Status.ACCEPTE;
        }
        if(selectReponse == "R") {
        	this.status = Status.REFUSE;
        }
        System.out.println("Nouveau status : " + this.status);
	}
	
}
