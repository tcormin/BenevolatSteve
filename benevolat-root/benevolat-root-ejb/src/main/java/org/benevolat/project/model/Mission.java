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

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 * Mission DOM
 * 
 * @author tcormin
 */
@Entity(name="mission")
public class Mission implements Serializable{

	/** serialVersionUID */
	private static final long serialVersionUID = -3636281361774052980L;

	/** id de la mission */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	/** titre de la mission */
	@Size(min = 3, max=25, message="Longueur entre 3 et 25 caractères.")
	private String titre;
	
	/** date de début de la mission */
	private Date dateDebut;
	
	/** date de fin de la mission */
	private Date dateFin;
	
	/** délai d'inscription à la mission */
	private Date delaiInscription = new Date();
	
	/** nombre de bénévoles recherchés */
	@Min(value=1,message="Recherche minimum de 1 bénévole.")
	private int nombreBenevoles =1;
	
	/** description de la mission */
	@Column(length=512)
	@Size(min=10, max=500, message="Longueur entre 10 et 500 caractères.")
	private String description;
	
	/** lieu de la mission */
	@Size(min = 3, max=50, message="Longueur entre 3 et 50 caractères.")
	private String lieu;
	
	/** domaine d'activité de la mission */
	private Domaine categorie;
	
	/** type de la mission (régulière/ponctuelle) */
	private TypeMission typeMission;
	
	/** association qui propose mission */
	@ManyToOne(cascade=CascadeType.PERSIST)
	private Association association;
	
	/** status de la mission */
	private Status status;
	
	/** inscriptions des bénévoles à la mission */
	@OneToMany(mappedBy="mission", cascade=CascadeType.PERSIST)
	@LazyCollection(LazyCollectionOption.FALSE)
	private Collection<InscriptionMission> inscriptionsMissions;
	
	/** événement associé */
	@ManyToOne(cascade=CascadeType.PERSIST)
	private Evenement evenement;
	
	/**
	 * Constructeur
	 */
	public Mission(){
		inscriptionsMissions = new ArrayList<InscriptionMission>();
		this.status = Status.INCOMPLETE;
	}

	/**
	 * 
	 * @return l'id
	 */
	public Long getId() {
		return this.id;
	}
	/**
	 * 
	 * @return le titre
	 */
	public String getTitre() {
		return titre;
	}
	/**
	 * 
	 * @param titre
	 */
	public void setTitre(String titre) {
		this.titre = titre;
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
	 * @return le nombre de bénévoles
	 */
	public int getNombreBenevoles() {
		return nombreBenevoles;
	}
	/**
	 * 
	 * @param nombreBenevoles
	 */
	public void setNombreBenevoles(int nombreBenevoles) {
		this.nombreBenevoles = nombreBenevoles;
	}
	/**
	 * 
	 * @return le délai d'inscription
	 */
	public Date getDelaiInscription() {
		return delaiInscription;
	}
	/**
	 * 
	 * @param delaiInscription
	 */
	public void setDelaiInscription(Date delaiInscription) {
		this.delaiInscription = delaiInscription;
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
	 * @return la catégorie
	 */
	public Domaine getCategorie() {
		return categorie;
	}
	/**
	 * 
	 * @param categorie
	 */
	public void setCategorie(Domaine categorie) {
		this.categorie = categorie;
	}
	/**
	 * 
	 * @return l'association
	 */
	public Association getAssociation() {
		return association;
	}
	/**
	 * 
	 * @param association
	 */
	public void setAssociation(Association association) {
		this.association = association;
	}
	/**
	 * 
	 * @return les inscriptions des bénévoles
	 */
	public Collection<InscriptionMission> getInscriptionsMissions() {
		return inscriptionsMissions;
	}
	/**
	 * 
	 * @param collection
	 */
	public void setInscriptionsMissions(Collection<InscriptionMission> collection) {
		this.inscriptionsMissions = collection;
	}
	/**
	 * 
	 * @param l'inscription à ajouter
	 */
	public void addInscriptionsMissions(InscriptionMission im) {
		this.inscriptionsMissions.add(im);
	}
	/**
	 * 
	 * @return l'événement
	 */
	public Evenement getEvenement() {
		return evenement;
	}
	/**
	 * 
	 * @param evenement
	 */
	public void setEvenement(Evenement evenement) {
		this.evenement = evenement;
	}
	/**
	 * 
	 * @return l'id en String
	 */
	public String getidString() {
		return String.valueOf(id);
	}
	/**
	 * 
	 * @return le type de la mission
	 */
	public TypeMission getTypeMission() {
		return typeMission;
	}
	/**
	 * 
	 * @return le type de la mission en String
	 */
	public String typeMission() {
		if(typeMission == TypeMission.PONCTUELLE){
			return "Ponctuelle";}
		if(typeMission == TypeMission.REGULIERE){
			return "Régulière";}
		return "";
	}
	/**
	 * 
	 * @param typeMission
	 */
	public void setTypeMission(TypeMission typeMission) {
		this.typeMission = typeMission;
	}
	/**
	 * 
	 * @return le status
	 */
	public Status getStatus() {
		return status;
	}
	/**
	 * 
	 * @param status
	 */
	public void setStatus(Status status) {
		this.status = status;
	}

	/**
	 * 
	 * @return les inscriptions en cours (donc sans réponse)
	 */
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
	/**
	 * 
	 * @return les inscriptions acceptées
	 */
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
	/**
	 * 
	 * @return les inscriptions refusées
	 */
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
	/**
	 * 
	 * @return le nombre de places restantes
	 */
	public int getPlacesRestantes(){
		return this.nombreBenevoles - this.getNombreInscriptionsAcceptees();
	}
	
	/**
	 * 
	 * @return le nombre de places restantes
	 */
	public int getNombreInscriptionsAcceptees(){
		return this.getInscriptionsMissionsAcceptees().size();
	}

	/**
	 * 
	 * @return le délai d'inscription
	 */
	public String delaiInscription(){
		SimpleDateFormat formater = new SimpleDateFormat("d.MM.yyyy");
		return formater.format(delaiInscription);
	}

	/**
	 * 
	 * @return le nombre de bénévoles déjà acceptés
	 */
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
	
	/**
	 * 
	 * @return la date pour l'affichage
	 */
	public String date(){
		SimpleDateFormat formater = new SimpleDateFormat("d.MM.yyyy");
		if(this.dateDebut == null){
			return "";
		}
		if(this.dateFin == null){
			if(this.typeMission == TypeMission.REGULIERE){
				return "dès le " + formater.format(dateDebut);
			}else{
				
			}return "le " + formater.format(dateDebut);
		}
		return "du " + formater.format(dateDebut) + " au " + formater.format(dateFin);
	}
	/**
	 * Vérification de la cohérance des dates
	 * @return vrai si les dates sont cohérantes
	 */
	@AssertTrue(message = "La date de fin ne peut précéder la date de début.")
	public boolean isDateDebutFinCoherant() {
		if(dateFin == null){
			return true;
		}else{
			return dateDebut.before(dateFin);
		}
	}
	/**
	 * Vérification de la cohérance du délai d'inscription
	 * @return vrai si le délai est cohérant
	 */
	@AssertTrue(message = "Délai non cohérant.")
	public boolean isDateDebutDelaiCoherant() {
		return delaiInscription.before(dateDebut);
	}
	
	public boolean isPonctuelle(){
		return this.typeMission == TypeMission.PONCTUELLE;
	}
}
