package org.benevolat.project.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

/**
 * Utilisateur DOM
 * 
 * @author tcormin
 */
@Entity(name="utilisateur")
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name="TYPE_ENTITE")
@DiscriminatorValue("UTILISATEUR")
public class Utilisateur {

	/** id de l'utilisateur */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/** username de l'utilisateur */
	@Size(min=3, max=25, message="Longueur entre 3 et 25 caractères.")
	@Column(unique=true)
	private String username;
	
	/** password de l'utilisateur */
	@Size(min=6, max=255, message="Longueur entre 6 et 25 caractères.")
	private String password;
	
	/** adresse de l'utilisateur */
	@Size(max=50, message="Longueur maximale de 50 caractères.")
	private String adresse;
	
	/** npa de l'utilisateur */
	@Size(min=4,max=4, message="Entre un NPA à 4 chiffre, p.ex. 1201.")
	private String npa;
	
	/** commune de l'utilisateur */
	@Size(max=30, message="Longueur maximale de 30 caractères.")
	private String commune;
	
	/** email de l'utilisateur */
	@Email(message="Entrez un email valide")
	private String email;
	
	/** téléphone de l'utilisateur */
	//@Size(min=13, max=13, message="Format : 022 XXX XX XX")
	private String telephone;
	
	private String role;

	/** site web de l'utilisateur */
	//@URL(message="Entrez un nom de domaine valide.")
	private String url;
	
	/** Constructeur */
	public Utilisateur(){
		role = "BENEVOLE";
	}
	
	/**
	 * 
	 * @return l'adresse
	 */
	public String getAdresse() {
		return adresse;
	}
	/**
	 * 
	 * @return
	 */
	public String getNpa() {
		return npa;
	}
	/**
	 * 
	 * @param npa
	 */
	public void setNpa(String npa) {
		this.npa = npa;
	}
	/**
	 * 
	 * @return la commune
	 */
	public String getCommune() {
		return commune;
	}
	/**
	 * 
	 * @param commune
	 */
	public void setCommune(String commune) {
		this.commune = commune;
	}
	/**
	 * 
	 * @param adresse
	 */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	/**
	 * 
	 * @return l'email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * 
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * 
	 * @returnle téléphone
	 */
	public String getTelephone() {
		return telephone;
	}
	/**
	 * 
	 * @param telephone
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	/**
	 * 
	 * @return l'url
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
	 * @return l'id
	 */
	public Long getid() {
		return id;
	}
	/**
	 * 
	 * @return le username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * 
	 * @param username
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * 
	 * @return le password
	 */
	public String getPassword() {
        return password;
	}
	/**
	 * 
	 * @param password
	 */
	public void setPassword(String password) {
        this.password = password;
	}
}
