package org.benevolat.project.model;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Size;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
/**
 * Benevole DOM
 * 
 * @author tcormin
 */
@Entity(name="benevole")
@DiscriminatorValue("BENEVOLE")
public class Benevole extends Utilisateur{

	/** Nom du bénévole */
	@Size(min=3, max=25, message="Longueur entre 3 et 25 caractères.")
	private String nom;
	
	/** Prénom du bénévole */
	@Size(min=3, max=25, message="Longueur entre 3 et 25 caractères.")
	private String prenom;
	
	/** Date de naissancedu bénévole */
	private Date dateNaissance;
	
	/** Profession du bénévole */
	@Size(min=3, max=35, message="Longueur entre 3 et 35 caractères.")
	private String profession;
	
	/** Présentation du bénévole */
	@Column(length=512)
	@Size(max=400, message="Longueur maximale de 400 caractères.")
	private String presentation;
	
	/** Missions auxquelles le bénévole est inscrit */
	@OneToMany(mappedBy="benevole", cascade=CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	private Collection<InscriptionMission> inscriptionsMissions;// = new ArrayList<InscriptionMission>();
	
	/** image illustrant l'événement */
	@OneToOne(cascade=CascadeType.PERSIST, fetch=FetchType.EAGER)
	private Image image;
	
	/** Formations auxquelles le bénévole est inscrit */
	@Transient
	private ArrayList<InscriptionFormation> inscriptionsFormations = new ArrayList<InscriptionFormation>();

	/** Constructeur */
	public Benevole(){
		super();
		inscriptionsMissions = new ArrayList<InscriptionMission>();
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
	 * @return le prénom
	 */
	public String getPrenom() {
		return prenom;
	}
	/**
	 * 
	 * @param prenom
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	/**
	 * 
	 * @return la date de naissance
	 */
	public Date getDateNaissance() {
		return dateNaissance;
	}
	/**
	 * 
	 * @param dateNaissance
	 */
	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	/**
	 * 
	 * @return la profession
	 */
	public String getProfession() {
		return profession;
	}
	/**
	 * 
	 * @param profession
	 */
	public void setProfession(String profession) {
		this.profession = profession;
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
	 * @return les inscriptions aux missions
	 */
	public Collection<InscriptionMission> getInscriptionsMissions() {
		return inscriptionsMissions;
	}
	/**
	 * 
	 * @param inscriptionsMissions
	 */
	public void setInscriptionsMissions(
			Collection<InscriptionMission> inscriptionsMissions) {
		this.inscriptionsMissions = inscriptionsMissions;
	}
	/**
	 * 
	 * @return les inscriptions aux formations
	 */
	public ArrayList<InscriptionFormation> getInscriptionsFormations() {
		return inscriptionsFormations;
	}
	/**
	 * 
	 * @param inscriptionsFormations
	 */
	public void setInscriptionsFormations(
			ArrayList<InscriptionFormation> inscriptionsFormations) {
		this.inscriptionsFormations = inscriptionsFormations;
	}
	/**
	 * 
	 * @return la date de naissance au format String pour l'affichage
	 */
	public String getDate(){
		SimpleDateFormat formater = new SimpleDateFormat("d.MM.yyyy");
		return formater.format(dateNaissance);
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
	 * @return les noms/prénoms pour l'affichage
	 */
	public String displayName(){
		return this.nom + " " + this.prenom; 
	}
	
	/**
	 * 
	 * @param l'inscription à ajouter
	 */
	public void addInscriptionsMissions(InscriptionMission im) {
		this.inscriptionsMissions.add(im);
	}
	
	/**
	 * Vérification de l'âge du bénévole
	 * @return vrai si le bénévole peut s'inscrire
	 */
	@AssertTrue(message = "Vous devez être agé de 18 ans au minimum pour vous inscrire.")
	public boolean isPasswordsEquals() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(dateNaissance);
		cal.add(Calendar.YEAR, 18);
		return cal.getTime().before(new Date());
	}
}
