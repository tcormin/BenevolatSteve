package org.benevolat.project.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity(name="administrateur")
@DiscriminatorValue("ADMINISTRATEUR")
public class Administrateur extends Utilisateur{

	private String nom;
	private String prenom;
	
	public Administrateur() {
		super();
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
	
	
}
