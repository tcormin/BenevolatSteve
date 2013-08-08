package org.benevolat.project.controller;

import java.io.OutputStream;
import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.benevolat.project.model.Evenement;
import org.benevolat.project.service.EvenementService;

/**
 * CONTROLEUR allEvenements
 * 
 * @author tcormin
 */
@RequestScoped
@Named("allEvenementsView")
public class AllEvenementsView implements Serializable{

	/**
	 * serial version UID
	 */
	private static final long serialVersionUID = 5003811116459112872L;

	/**
	 * Service pour les événements
	 */
	@Inject
	private EvenementService evenementService;
	
	private int cpt = 0;
	
	/**
	 * 
	 * @return tous les événements depuis la DB
	 * @throws Exception
	 */
	public List<Evenement> getEvenements() throws Exception {
		return evenementService.getEvenements();
	}
	
}
