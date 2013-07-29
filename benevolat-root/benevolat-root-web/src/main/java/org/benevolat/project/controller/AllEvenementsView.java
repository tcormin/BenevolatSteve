package org.benevolat.project.controller;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.benevolat.project.model.Evenement;
import org.benevolat.project.service.EvenementService;

@RequestScoped
@Named("allEvenementsView")
public class AllEvenementsView implements Serializable{

	@Inject
	private EvenementService evenementService;
	
	private static final long serialVersionUID = 5003811116459112872L;

	public List<Evenement> getEvenements() throws Exception {
		return evenementService.getEvenements();
	}
	
}
