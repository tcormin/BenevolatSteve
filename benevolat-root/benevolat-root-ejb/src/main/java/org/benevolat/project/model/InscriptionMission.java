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

/**
 * Inscrption à une mission DOM
 * 
 * @author tcormin
 */
@Entity(name="inscriptionmission")
public class InscriptionMission implements Serializable{
	
	/** serialVersionUID */
	private static final long serialVersionUID = 2864348058409385170L;
	
	/** id de l'inscription */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	/** bénévole demandant l'inscription */
	@ManyToOne(cascade=CascadeType.ALL)
	private Benevole benevole;
	
	/** mission concernée par l'inscription */
	@ManyToOne(cascade=CascadeType.PERSIST)
	private Mission mission;
	
	/** date de l'inscription */
	private Date dateInscription = new Date();
	
	/** status de l'inscription */
	private Status status;
	
	/** commentaire de l'inscription pour la réponse */
	private String commentaire;
	
	public InscriptionMission(){
		this.status = Status.EN_COURS;
	}
	
	/**
	 * 
	 * @return le bénévole
	 */
	public Benevole getBenevole() {
		return benevole;
	}
	/**
	 * 
	 * @param benevole
	 */
	public void setBenevole(Benevole benevole) {
		this.benevole = benevole;
	}
	/**
	 * 
	 * @return la mission
	 */
	public Mission getMission() {
		return mission;
	}
	/**
	 * 
	 * @param mission
	 */
	public void setMission(Mission mission) {
		this.mission = mission;
	}
	/**
	 * 
	 * @return la date d'inscription
	 */
	public Date getDateInscription() {
		return dateInscription;
	}
	/**
	 * 
	 * @param dateInscription
	 */
	public void setDateInscription(Date dateInscription) {
		this.dateInscription = dateInscription;
	}
	/**
	 * 
	 * @return le status
	 */
	public Status getStatus() {
		return status;
	}
	/**
	 * 
	 * @param status
	 */
	public void setStatus(Status status) {
		this.status = status;
	}
	/**
	 * 
	 * @return le commentaire de la réponse
	 */
	public String getCommentaire() {
		return commentaire;
	}
	/**
	 * 
	 * @param commentaire
	 */
	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}
	/**
	 * 
	 * @return l'id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 
	 * @param id
	 */
	public void setId(Long id) {
		this.id = id;
	}
	
	/**
	 * 
	 * @return la date d'inscription pour l'affichage
	 */
	public String dateInscription() {
		SimpleDateFormat formater = new SimpleDateFormat("d.MM.yyyy");
		return formater.format(dateInscription);
	}
	
	/**
	 * Permet d'enregistrer la réponse donnée par l'association
	 * @param selectReponse
	 */
	public void setSelectReponse(String selectReponse) {
        if(selectReponse.equalsIgnoreCase("A")) {
            this.status = Status.ACCEPTE;
        }
        if(selectReponse.equalsIgnoreCase("R")) {
        	this.status = Status.REFUSE;
        }
	}
}
