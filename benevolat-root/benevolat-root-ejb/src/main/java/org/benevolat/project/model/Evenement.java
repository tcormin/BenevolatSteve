package org.benevolat.project.model;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Future;
import javax.validation.constraints.Size;

/**
 * Evenement DOM
 * 
 * @author tcormin
 */
@Entity(name="evenement")
public class Evenement implements Serializable {

	/** serialVersion UID */
	private static final long serialVersionUID = -2301865569982128521L;

	/** id de l'événement */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	/** nom de l'événement */
	@Size(min=3, max=28, message="Longueur entre 3 et 28 caractères.")
	private String nom;
	
	/** date de debut de l'événement */
	@Future(message="Date invalide")
	private Date dateDebut;

	/** date de fin de l'événement */
	private Date dateFin;
	
	/** lieu de l'événement */
	@Size(min=3, max=30, message="Longueur entre 3 et 30 caractères.")
	private String lieu;
	
	/** description de l'événement */
	@Column(length=512)
	@Size(min=3, max=400, message="Longueur entre 3 et 400 caractères.")
	private String description;
	
	/** site web de l'événement */
	//@URL(message="Entrez un nom de domaine valide.")
	private String url;
	
	/** image illustrant l'événement */
	@OneToOne(cascade=CascadeType.PERSIST, fetch=FetchType.EAGER)
	private Image image;

	/** association organisant l'événement */
	@OneToOne(cascade=CascadeType.PERSIST)
	private Association organisateur;

	/** missions associées à l'événement */
	@OneToMany(mappedBy="evenement", cascade=CascadeType.PERSIST, fetch=FetchType.EAGER)
	private Collection<Mission> missions;// = new ArrayList<Mission>();
	
	/**
	 * Constructeur
	 */
	public Evenement(){
		missions = new ArrayList<Mission>();
	}
	/**
	 * 
	 * @return le nom
	 */
	public String getNom() {
		return nom;
	}
	/**
	 * 
	 * @param nom
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	/**
	 * 
	 * @return la date de début
	 */
	public Date getDateDebut() {
		return dateDebut;
	}
	/**
	 * 
	 * @param dateDebut
	 */
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}
	/**
	 * 
	 * @return la date de fin
	 */
	public Date getDateFin() {
		return dateFin;
	}
	/**
	 * 
	 * @param dateFin
	 */
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}
	/**
	 * 
	 * @return le lieu
	 */
	public String getLieu() {
		return lieu;
	}
	/**
	 * 
	 * @param lieu
	 */
	public void setLieu(String lieu) {
		this.lieu = lieu;
	}
	/**
	 * 
	 * @return la description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * 
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * 
	 * @return le site web
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * 
	 * @param url
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * 
	 * @return les missions associées
	 */
	public Collection<Mission> getMissions() {
		return missions;
	}
	/**
	 * 
	 * @param missions
	 */
	public void setMissions(Collection<Mission> missions) {
		this.missions = missions;
	}
	/**
	 * 
	 * @return l'id
	 */
	public Long getid() {
		return id;
	}
	/**
	 * 
	 * @return l'image
	 */
	public Image getImage() {
		return image;
	}
	/**
	 * 
	 * @param image
	 */
	public void setImage(Image image) {
		this.image = image;
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
	 * @return l'organisateur
	 */
	public Association getOrganisateur() {
		return organisateur;
	}
	/**
	 * 
	 * @param organisateur
	 */
	public void setOrganisateur(Association organisateur) {
		this.organisateur = organisateur;
	}
	/**
	 * Ajoute une mission
	 * @param mission
	 */
	public void addMission(Mission m) {
        if (!getMissions().contains(m)) {
        	getMissions().add(m);
        }
	}
	/**
	 * 
	 * @return le texte à afficher précisant la (les) date(s)
	 */
	public String date(){
		SimpleDateFormat formater = new SimpleDateFormat("d.MM.yyyy");
		if(this.dateDebut == null){
			return "";
		}
		if(this.dateFin == null){
			return "le " + formater.format(dateDebut);
		}
		return "du " + formater.format(dateDebut) + " au " + formater.format(dateFin);
	}
	
	/**
	 * Vérifie la cohérance des dates
	 * @return vrai si la date de début précède bien la taille de fin
	 */
	@AssertTrue(message = "La date de fin ne peut précéder la date de début")
	public boolean isDateDebutFinCoherant() {
		if(dateFin == null){
			return true;
		}else{
			return dateDebut.before(dateFin);
		}
	}

}
