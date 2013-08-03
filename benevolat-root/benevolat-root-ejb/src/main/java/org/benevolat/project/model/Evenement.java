package org.benevolat.project.model;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Future;
import javax.validation.constraints.Size;

@Entity(name="evenement")
public class Evenement implements Serializable {

	private static final long serialVersionUID = -2301865569982128521L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Size(min=3, max=28, message="Longueur entre 3 et 28 caractères.")
	private String nom;
	
	@Future(message="Date invalide")
	private Date dateDebut;
	private Date dateFin;
	
	@Size(min=3, max=30, message="Longueur entre 3 et 30 caractères.")
	private String lieu;
	
	@Column(length=512)
	@Size(min=3, max=400, message="Longueur entre 3 et 400 caractères.")
	private String description;
	
	//@URL(message="Entrez un nom de domaine valide.")
	private String url;
	
	@OneToOne(cascade=CascadeType.ALL)
	private Image image;

	@OneToOne(cascade=CascadeType.ALL)
	private Association organisateur;

	@OneToMany(mappedBy="evenement", cascade=CascadeType.ALL)
	private Collection<Mission> missions;// = new ArrayList<Mission>();
	
	public Evenement(){
		missions = new ArrayList<Mission>();
	}
	
	public Evenement(Long id){
		this.id = id;
		missions = new ArrayList<Mission>();
	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
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
	public String getLieu() {
		return lieu;
	}
	public void setLieu(String lieu) {
		this.lieu = lieu;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Collection<Mission> getMissions() {
		return missions;
	}
	public void setMissions(Collection<Mission> missions) {
		this.missions = missions;
	}
	public Long getid() {
		return id;
	}
	public Image getImage() {
		return image;
	}
	public void setImage(Image image) {
		this.image = image;
	}
	public String date(){
		SimpleDateFormat formater = new SimpleDateFormat("d.MM.yyyy");
		if(this.dateDebut == null){
			return "";
		}
		if(this.dateFin == null){
			return formater.format(dateDebut);
		}
		return "du " + formater.format(dateDebut) + " au " + formater.format(dateFin);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	@AssertTrue(message = "La date de fin ne peut précéder la date de début")
	public boolean isDateDebutFinCoherant() {
		if(dateFin == null){
			return true;
		}else{
			return dateDebut.before(dateFin);
		}
	}
}
