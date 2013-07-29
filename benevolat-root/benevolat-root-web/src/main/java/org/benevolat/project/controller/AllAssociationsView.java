package org.benevolat.project.controller;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.inject.Named;

import org.benevolat.project.model.Association;
import org.benevolat.project.service.AssociationService;

@Model
@RequestScoped
@Named("allAssociationsView")
public class AllAssociationsView implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2643943138080056668L;

	@Inject
	private AssociationService associationService;

	public List<Association> getAssociations() throws Exception {
		return associationService.getAssociations();
	}

}
