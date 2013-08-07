package org.benevolat.project.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.Query;

import org.benevolat.project.model.Association;
import org.benevolat.project.model.Evenement;
import org.benevolat.project.model.Image;

/**
 * SERVICE événements
 * 
 * @author tcormin
 */
@Stateless
public class EvenementService extends PersistenceService {

	@Inject
	private AssociationService associationService;

	/**
	 * Enregistre l'événement
	 * 
	 * @param evenement
	 * @throws Exception
	 */
	public void setData(Evenement evenement) throws Exception {
		save(evenement);
		this.getLog().info(
				"Evenement is registred with name: " + evenement.getNom());
	}

	/**
	 * Récupère tous les événements
	 * 
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<Evenement> getEvenements() throws Exception {
		Query query = this.getEm().createQuery("from "+Evenement.class.getName() + " ORDER BY dateDebut");
		List<Evenement> m = query.getResultList();
		this.getLog().info(m.size() + " evenements found");
		return m;
	}

	/**
	 * Recherche d'événement
	 * 
	 * @param searchText
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Evenement> search(String searchText) {
		Query query = this.getEm().createQuery(
				"from evenement WHERE nom LIKE '%" + searchText + "%'"
						+ " or lieu LIKE '%" + searchText + "%'"
						+ " or description LIKE '%" + searchText + "%'");
		// Query query = em.createQuery("from "+Evenement.class.getName());//+
		// " WHERE lieu = '"+searchText+"'");
		List<Evenement> e = query.getResultList();
		this.getLog().info(e.size() + " evenements found for " + searchText);
		return e;
	}

	/**
	 * Recherche d'événement par nom
	 * 
	 * @param nom
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Evenement getFromNom(String nom) {
		this.getLog().info(" Searching :" + nom);
		Query query = this.getEm().createQuery(
				"from evenement WHERE nom = '" + nom + "'");
		Evenement e = (Evenement) query.getSingleResult();
		this.getLog().info(" Find :" + e.getClass());
		return e ;
	}

	/**
	 * Met à jour l'événement dans la BDD
	 * 
	 * @param événement
	 */
	public void update(Evenement evenement) {
		Evenement e = this.getFromId(Evenement.class, evenement.getid()
				.toString());
		e.setDateDebut(evenement.getDateDebut());
		e.setDateFin(evenement.getDateFin());
		e.setDescription(evenement.getDescription());
		e.setLieu(evenement.getLieu());
		e.setNom(evenement.getNom());
		e.setOrganisateur(associationService.getFromId(Association.class,
				evenement.getOrganisateur().getid().toString()));
		e.setUrl(evenement.getUrl());

		this.getEm().flush();
	}

	/**
	 * Récupère le username/password de l'utilisateur
	 * 
	 * @param clazz
	 * @param username
	 * @param password
	 * @return
	 */
	public <T> void setImageToId(String id, Image image) {
		Query query = this.getEm().createQuery(
				"from " + Evenement.class.getName() + " WHERE id = '" + id
						+ "'");
		Evenement e = (Evenement) query.getSingleResult();
		e.setImage(image);

		this.getEm().flush();

	}
}