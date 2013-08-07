package org.benevolat.project.controller;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.inject.Named;

import org.benevolat.project.model.Association;
import org.benevolat.project.service.AssociationService;

/**
 * CONTROLEUR allAssociations
 * 
 * @author tcormin
 */
@Model
@RequestScoped
@Named("allAssociationsView")
public class AllAssociationsView implements Serializable {

	/**
	 * serial version UID
	 */
	private static final long serialVersionUID = 2643943138080056668L;

	/**
	 * Service pour les associations
	 */
	@Inject
	private AssociationService associationService;

	/**
	 * 
	 * @return toutes les associations depuis la DB
	 * @throws Exception
	 */
	public List<Association> getAssociations() throws Exception {
		return associationService.getAssociations();
	}

	/**
	 * 
	 * @return toutes les associations depuis la DB
	 * @throws Exception
	 */
	public List<Association> getAssociationsRandom() throws Exception {
		
		
		return associationService.getAssociationsRandom();
	}
}
