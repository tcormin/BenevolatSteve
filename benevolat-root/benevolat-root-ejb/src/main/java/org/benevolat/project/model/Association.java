package org.benevolat.project.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

@Entity(name="association")
@DiscriminatorValue("ASSOCIATION")
public class Association extends Utilisateur{
	
	@Size(min=3, max=35, message="Longueur entre 3 et 35 caractères.")
	private String nom;
	
	@Size(min=3, max=28, message="Longueur entre 3 et 28 caractères.")
	private String acronyme;
	
	@Column(length=512)
	@Size(min=3, max=240, message="Longueur entre 3 et 240 caractères.")
	private String presentation;
	
	@Column(length=512)
	@Size(min=3, max=80, message="Longueur entre 3 et 80 caractères.")
	private String buts;
	
	@Size(min=4, max=4, message="Entre une année à 4 chiffre, p.ex. 2013")
	private String dateCreation;
	
	@Size(max=50, message="Longueur maximale de 50 caractères.")
	private String contact;
	
	private Domaine domaineNiveau1;
	
	@OneToMany(mappedBy="association", cascade=CascadeType.ALL)
	private Collection<Mission> missions;
	
	@Transient
	private ArrayList<Formation> formations = new ArrayList<Formation>();
	
	@Transient
	private ArrayList<Referencement> reference = new ArrayList<Referencement>();

	public Association(){
		super();
		missions = new ArrayList<Mission>();
	}
	
	public Association(Long ID) {
		super(ID);
		missions =  new ArrayList<Mission>();
	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String name) {
		this.nom = name;
	}
	public String getPresentation() {
		return presentation;
	}
	public void setPresentation(String presentation) {
		this.presentation = presentation;
	}
	public String getButs() {
		return buts;
	}
	public void setButs(String buts) {
		this.buts = buts;
	}
	public String getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(String dateCreation) {
		this.dateCreation = dateCreation;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public Collection<Mission> getMissions() {
		return missions;
	}
	public void setMissions(ArrayList<Mission> missions) {
		this.missions = missions;
	}
	public ArrayList<Formation> getFormations() {
		return formations;
	}
	public void setFormations(ArrayList<Formation> formations) {
		this.formations = formations;
	}
	public ArrayList<Referencement> getReference() {
		return reference;
	}
	public void setReference(ArrayList<Referencement> reference) {
		this.reference = reference;
	}
	public Domaine getDomaineNiveau1() {
		return domaineNiveau1;
	}
	public void setDomaineNiveau1(Domaine domaineNiveau1) {
		this.domaineNiveau1 = domaineNiveau1;
	}
	public String getAcronyme() {
		return acronyme;
	}
	public void setAcronyme(String acronyme) {
		this.acronyme = acronyme;
	}
	
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
