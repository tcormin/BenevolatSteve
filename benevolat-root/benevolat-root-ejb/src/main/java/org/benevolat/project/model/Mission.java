package org.benevolat.project.model;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Entity(name="mission")
public class Mission implements Serializable{

	private static final long serialVersionUID = -3636281361774052980L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Size(min = 3, max=25, message="Longueur entre 3 et 25 caractères.")
	private String titre;
	
	@Future(message="Date invalide")
	private Date dateDebut;
	private Date dateFin;
	private Date delaiInscription = new Date();
	
	@Min(value=1,message="Recherche minimum de 1 bénévole.")
	private int nombreBenevoles =1;
	
	@Column(length=512)
	@Size(min=10, max=500, message="Longueur entre 10 et 500 caractères.")
	private String description;
	
	@Size(min = 3, max=50, message="Longueur entre 3 et 50 caractères.")
	private String lieu;
	
	private Domaine categorie;
	private TypeMission typeMission;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private Association association;
	
	@OneToMany(mappedBy="mission", cascade=CascadeType.ALL)
	private Collection<InscriptionMission> inscriptionsMissions;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private Evenement evenement;
	
	public Mission(){
		inscriptionsMissions = new ArrayList<InscriptionMission>();
	}

	public Long getId() {
		return this.id;
	}
	
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
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
	public int getNombreBenevoles() {
		return nombreBenevoles;
	}
	public void setNombreBenevoles(int nombreBenevoles) {
		this.nombreBenevoles = nombreBenevoles;
	}
	public Date getDelaiInscription() {
		return delaiInscription;
	}
	public void setDelaiInscription(Date delaiInscription) {
		this.delaiInscription = delaiInscription;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLieu() {
		return lieu;
	}
	public void setLieu(String lieu) {
		this.lieu = lieu;
	}
	public Domaine getCategorie() {
		return categorie;
	}
	public void setCategorie(Domaine categorie) {
		this.categorie = categorie;
	}
	public Association getAssociation() {
		return null;//association;
	}
	public void setAssociation(Association association) {
		//this.association = association;
	}
	public Collection<InscriptionMission> getInscriptionsMissions() {
		return inscriptionsMissions;
	}
	public void setInscriptionsMissions(
			ArrayList<InscriptionMission> inscriptionsMissions) {
		this.inscriptionsMissions = inscriptionsMissions;
	}
	public Evenement getEvenement() {
		return evenement;
	}
	public void setEvenement(Evenement evenement) {
		this.evenement = evenement;
	}
	public String getidString() {
		return String.valueOf(id);
	}
	public TypeMission getTypeMission() {
		return typeMission;
	}
	public String typeMission() {
		if(typeMission == TypeMission.PONCTUELLE){return "Ponctuelle";}
		if(typeMission == TypeMission.REGULIERE){return "Régulière";}
		return "";
	}
	public void setTypeMission(TypeMission typeMission) {
		this.typeMission = typeMission;
	}
	public ArrayList<InscriptionMission> getInscriptionsMissionsEnCours(){
		ArrayList<InscriptionMission> i = new ArrayList<InscriptionMission>();
		Iterator<InscriptionMission> itr = this.inscriptionsMissions.iterator();
		
		while(itr.hasNext()){
			InscriptionMission im = itr.next();
			if(im.getStatus() == Status.EN_COURS){
				i.add(im);
			}
		}
		
		return i;
	}
	public ArrayList<InscriptionMission> getInscriptionsMissionsAcceptees(){
		ArrayList<InscriptionMission> i = new ArrayList<InscriptionMission>();
		Iterator<InscriptionMission> itr = this.inscriptionsMissions.iterator();
		
		while(itr.hasNext()){
			InscriptionMission im = itr.next();
			if((im.getStatus() == Status.ACCEPTE) || (im.getStatus() == Status.ACCOMPLIE)){
				i.add(im);
			}
		}
		
		return i;
	}
	public ArrayList<InscriptionMission> getInscriptionsMissionsRefusees(){
		ArrayList<InscriptionMission> i = new ArrayList<InscriptionMission>();
		Iterator<InscriptionMission> itr = this.inscriptionsMissions.iterator();
		
		while(itr.hasNext()){
			InscriptionMission im = itr.next();
			if(im.getStatus() == Status.REFUSE){
				i.add(im);
			}
		}
		
		return i;
	}
	public int getPlacesRestantes(){
		return this.nombreBenevoles - this.getInscriptionsMissionsAcceptees().size();
	}
	
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
	
	public String delaiInscription(){
		SimpleDateFormat formater = new SimpleDateFormat("d.MM.yyyy");
		return formater.format(delaiInscription);
	}
	
	public int benevolesInscrits(){
		Iterator<InscriptionMission> itr = this.inscriptionsMissions.iterator();
		int cpt = 0;
		while (itr.hasNext()){
			if(itr.next().getStatus().compareTo(Status.ACCEPTE) == 0){
				cpt++;
			}
		}
		return cpt;
	}
	
	@AssertTrue(message = "La date de fin ne peut précéder la date de début.")
	public boolean isDateDebutFinCoherant() {
		if(dateFin == null){
			return true;
		}else{
			return dateDebut.before(dateFin);
		}
	}
	
	@AssertTrue(message = "Délai non cohérant.")
	public boolean isDateDebutDelaiCoherant() {
		return delaiInscription.before(dateDebut);
	}
	
}
