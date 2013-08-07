package org.benevolat.project.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

/**
 * Association DOM
 * 
 * @author tcormin
 */
@Entity(name="association")
@DiscriminatorValue("ASSOCIATION")
public class Association extends Utilisateur{
	
	/** Nom de l'association */
	@Size(min=3, max=35, message="Longueur entre 3 et 35 caractères.")
	@Column(unique=true)
	private String nom;
	
	/** Acronyme de l'association */
	@Size(min=3, max=28, message="Longueur entre 3 et 28 caractères.")
	private String acronyme;
	
	/** Présentation de l'association */
	@Column(length=512)
	@Size(min=3, max=240, message="Longueur entre 3 et 240 caractères.")
	private String presentation;
	
	/** Buts de l'association */
	@Column(length=512)
	@Size(min=3, max=80, message="Longueur entre 3 et 80 caractères.")
	private String buts;
	
	/** Date de création de l'association */
	@Size(min=4, max=4, message="Entre une année à 4 chiffre, p.ex. 2013")
	private String dateCreation;
	
	/** Personne de contact de l'association */
	@Size(max=50, message="Longueur maximale de 50 caractères.")
	private String contact;
	
	/** Domaine d'activité de l'association */
	private Domaine domaineNiveau1;
	
<<<<<<< HEAD
	/** Missions créées par l'association */
	@OneToMany(mappedBy="association", cascade=CascadeType.PERSIST, fetch=FetchType.EAGER)
=======
	@OneToMany(mappedBy="association", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
>>>>>>> 014a35e93a94e6ef8b908689f9e45c5c29b6055d
	private Collection<Mission> missions;
	
	/** image illustrant l'événement */
	@OneToOne(cascade=CascadeType.PERSIST, fetch=FetchType.EAGER)
	private Image image;
	
	/** Formations proposées par l'association */
	@Transient
	private ArrayList<Formation> formations = new ArrayList<Formation>();

	/** Constructeur */
	public Association(){
		super();
		missions = new ArrayList<Mission>();
	}
	
	// Getters et Setters *******************************
	/**
	 * 
	 * @return le nom
	 */
	public String getNom() {
		return nom;
	}
	/**
	 * 
	 * @param name
	 */
	public void setNom(String name) {
		this.nom = name;
	}
	/**
	 * 
	 * @return la présentation
	 */
	public String getPresentation() {
		return presentation;
	}
	/**
	 * 
	 * @param presentation
	 */
	public void setPresentation(String presentation) {
		this.presentation = presentation;
	}
	/**
	 * 
	 * @return les buts
	 */
	public String getButs() {
		return buts;
	}
	/**
	 * 
	 * @param buts
	 */
	public void setButs(String buts) {
		this.buts = buts;
	}
	/**
	 * 
	 * @return la date de création
	 */
	public String getDateCreation() {
		return dateCreation;
	}
	/**
	 * 
	 * @param dateCreation
	 */
	public void setDateCreation(String dateCreation) {
		this.dateCreation = dateCreation;
	}
	/**
	 * 
	 * @return la personne de contact
	 */
	public String getContact() {
		return contact;
	}
	/**
	 * 
	 * @param contact
	 */
	public void setContact(String contact) {
		this.contact = contact;
	}
	/**
	 * 
	 * @return les missions
	 */
	public Collection<Mission> getMissions() {
		return missions;
	}
	/**
	 * 
	 * @param collection
	 */
	public void setMissions(Collection<Mission> collection) {
		this.missions = collection;
	}
	/**
	 * 
	 * @return les formations
	 */
	public ArrayList<Formation> getFormations() {
		return formations;
	}
	/**
	 * 
	 * @param formations
	 */
	public void setFormations(ArrayList<Formation> formations) {
		this.formations = formations;
	}
	/**
	 * 
	 * @return le domaine d'activité
	 */
	public Domaine getDomaineNiveau1() {
		return domaineNiveau1;
	}
	/**
	 * 
	 * @param domaineNiveau1
	 */
	public void setDomaineNiveau1(Domaine domaineNiveau1) {
		this.domaineNiveau1 = domaineNiveau1;
	}
	/**
	 * 
	 * @return l'acronyme
	 */
	public String getAcronyme() {
		return acronyme;
	}
	/**
	 * 
	 * @param acronyme
	 */
	public void setAcronyme(String acronyme) {
		this.acronyme = acronyme;
	}
	
	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	/**
	 * Ajoute une mission
	 * @param mission
	 */
	public void addMission(Mission m) {
        if (!getMissions().contains(m)) {
        	getMissions().add(m);
//            if (m.getAssociation() != null) {
//                m.getAssociation().getMissions().remove(m);
//            }
//            m.setAssociation(this);
        }
    }
	
	
}
