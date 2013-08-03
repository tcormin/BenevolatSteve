package org.benevolat.project.model;

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


@Entity(name="utilisateur")
//@Table
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name="TYPE_ENTITE")
@DiscriminatorValue("UTILISATEUR")
public class Utilisateur {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Size(min=3, max=25, message="Longueur entre 3 et 25 caractères.")
	private String username;
	
	@Size(min=6, max=25, message="Longueur entre 6 et 25 caractères.")
	private String password;
	
	@Size(max=50, message="Longueur maximale de 50 caractères.")
	private String adresse;
	
	@Size(min=4,max=4, message="Entre un NPA à 4 chiffre, p.ex. 1201.")
	private String npa;
	
	@Size(max=30, message="Longueur maximale de 30 caractères.")
	private String commune;
	
	@Email(message="Entrez un email valide")
	private String email;
	
	//@Size(min=13, max=13, message="Format : 022 XXX XX XX")
	private String telephone;
	
	//@URL(message="Entrez un nom de domaine valide.")
	private String url;
	
	public Utilisateur(){
	}
	
	public Utilisateur(final Long id){
		this.id = id;
	}
	
	public String getAdresse() {
		return adresse;
	}
	public String getNpa() {
		return npa;
	}
	public void setNpa(String npa) {
		this.npa = npa;
	}
	public String getCommune() {
		return commune;
	}
	public void setCommune(String commune) {
		this.commune = commune;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Long getid() {
		return id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
        return password;
	}
	public void setPassword(String password) {
        this.password = password;
	}
}
