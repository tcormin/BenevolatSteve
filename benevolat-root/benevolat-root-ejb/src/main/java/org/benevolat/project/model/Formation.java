package org.benevolat.project.model;
import java.util.ArrayList;
import java.util.Date;

/**
 * Formation DOM
 * 
 * actuellement en standby
 * @author tcormin
 */
public class Formation {
	
	private String titre;
	private final int id;
	private Date dateDebut;
	private Date dateFin;
	private int nombreBenevoles;
	private Date delaiInscription;
	private String description;
	private String lieu;
	private Association association;
	private ArrayList<InscriptionFormation> inscriptionsFormations = new ArrayList<InscriptionFormation>();
	
	public Formation(final int id){
		this.id = id;
	}
	public int getId() {
		return id;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public Date getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}
	public Date getDateFin() {
		return dateFin;
	}
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}
	public int getNombreBenevoles() {
		return nombreBenevoles;
	}
	public void setNombreBenevoles(int nombreBenevoles) {
		this.nombreBenevoles = nombreBenevoles;
	}
	public Date getDelaiInscription() {
		return delaiInscription;
	}
	public void setDelaiInscription(Date delaiInscription) {
		this.delaiInscription = delaiInscription;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLieu() {
		return lieu;
	}
	public void setLieu(String lieu) {
		this.lieu = lieu;
	}
	public Association getAssociation() {
		return association;
	}
	public void setAssociation(Association association) {
		this.association = association;
	}
	public ArrayList<InscriptionFormation> getInscriptionsFormations() {
		return inscriptionsFormations;
	}
	public void setInscriptionsFormations(
			ArrayList<InscriptionFormation> inscriptionsFormations) {
		this.inscriptionsFormations = inscriptionsFormations;
	}
	
}
