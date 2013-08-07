package org.benevolat.project.controller;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.inject.Named;

import org.benevolat.project.model.Benevole;
import org.benevolat.project.service.BenevoleService;

/**
 * CONTROLEUR allBenevoles
 * 
 * @author tcormin
 */
@Model
@RequestScoped
@Named("allBenevolesView")
public class AllBenevolesView implements Serializable {

	/**
	 * serial version UID
	 */
	private static final long serialVersionUID = 2643943138080056668L;

	/**
	 * Service pour les bénévoles
	 */
	@Inject
	private BenevoleService benevolesService;

	/**
	 * 
	 * @return tous les bénévoles depuis la DB
	 * @throws Exception
	 */
	public List<Benevole> getBenevoles() throws Exception {
		return benevolesService.getBenevoles();
	}

}
