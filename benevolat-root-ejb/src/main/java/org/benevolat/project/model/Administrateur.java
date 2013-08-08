package org.benevolat.project.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Administrateur DOM
 * 
 * @author tcormin
 */
@Entity(name="administrateur")
@DiscriminatorValue("ADMINISTRATEUR")
public class Administrateur extends Utilisateur{

	/** Nom de l'administrateur */
	private String nom;
	/** Prénom de l'administrateur */
	private String prenom;
	
	/** Constructeur */
	public Administrateur() {
		super();
	}
	
	// Getters et Setters *******************************
	/** @return le nom*/
	public String getNom() {
		return nom;
	}
	/** @param le nom*/
	public void setNom(String nom) {
		this.nom = nom;
	}
	/** @return le prénom*/
	public String getPrenom() {
		return prenom;
	}
	/** @param le nom*/
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
}
