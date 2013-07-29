package org.benevolat.project.controller;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.inject.Named;

import org.benevolat.project.model.Benevole;
import org.benevolat.project.service.BenevoleService;

@Model
@RequestScoped
@Named("allBenevolesView")
public class AllBenevolesView implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2643943138080056668L;

	@Inject
	private BenevoleService benevolesService;

	public List<Benevole> getBenevoles() throws Exception {
		return benevolesService.getBenevoles();
	}

}
