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
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Size;

@Entity(name="benevole")
@DiscriminatorValue("BENEVOLE")
public class Benevole extends Utilisateur{

	@Size(min=3, max=25, message="Longueur entre 3 et 25 caractères.")
	private String nom;
	
	@Size(min=3, max=25, message="Longueur entre 3 et 25 caractères.")
	private String prenom;
	
	private Date dateNaissance = new Date();
	
	@Size(min=3, max=35, message="Longueur entre 3 et 35 caractères.")
	private String profession;
	
	@Column(length=512)
	@Size(max=400, message="Longueur maximale de 400 caractères.")
	private String presentation;
	
	@OneToMany(mappedBy="benevole", cascade=CascadeType.ALL)
	private Collection<InscriptionMission> inscriptionsMissions;// = new ArrayList<InscriptionMission>();
	
	@Transient
	private ArrayList<Referencement> reference = new ArrayList<Referencement>();
	
	@Transient
	private ArrayList<InscriptionFormation> inscriptionsFormations = new ArrayList<InscriptionFormation>();

	public Benevole(){
		super();
		inscriptionsMissions = new ArrayList<InscriptionMission>();
	}
	
	public Benevole(Long ID) {
		super(ID);
		// TODO Auto-generated constructor stub
	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public Date getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	public String getPresentation() {
		return presentation;
	}
	public void setPresentation(String presentation) {
		this.presentation = presentation;
	}
	public Collection<InscriptionMission> getInscriptionsMissions() {
		return inscriptionsMissions;
	}
	public void setInscriptionsMissions(
			Collection<InscriptionMission> inscriptionsMissions) {
		this.inscriptionsMissions = inscriptionsMissions;
	}
	public ArrayList<Referencement> getReference() {
		return reference;
	}
	public void setReference(ArrayList<Referencement> reference) {
		this.reference = reference;
	}
	public ArrayList<InscriptionFormation> getInscriptionsFormations() {
		return inscriptionsFormations;
	}
	public void setInscriptionsFormations(
			ArrayList<InscriptionFormation> inscriptionsFormations) {
		this.inscriptionsFormations = inscriptionsFormations;
	}
	public String getDate(){
		SimpleDateFormat formater = new SimpleDateFormat("d.MM.yyyy");
		return formater.format(dateNaissance);
	}
	public String displayName(){
		return this.nom + " " + this.prenom; 
	}
	
	@AssertTrue(message = "Vous devez être agé de 18 ans au minimum pour vous inscrire.")
	public boolean isPasswordsEquals() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(dateNaissance);
		cal.add(Calendar.YEAR, 18);
		return cal.getTime().before(new Date());
	}
}
