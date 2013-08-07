package org.benevolat.project.controller;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.benevolat.project.model.Association;
import org.benevolat.project.model.Benevole;
import org.benevolat.project.model.Utilisateur;

@RequestScoped
@Named("sessionBean")
public class SessionBean implements Serializable {

	private static final long serialVersionUID = 745858547796786996L;

	private String searchText = "";

	@Inject
	BenevoleView benevoleView;
	@Inject
	AssociationView associationView;

	Utilisateur user;
	boolean log = false;

	public String getTitre() {
		return "Plateforme du Bénévolat";
	}

	public String getSearchText() {
		return searchText;
	}

	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}

	public Utilisateur getUser() {
		return user;
	}

	public void setUser(Utilisateur user) {
		this.user = user;
		System.out.println("J'ai trouvé un(e) : " + user.getClass());
		this.setLog(true);
	}

	public boolean isLog() {
		return log;
	}

	public void setLog(boolean log) {
		this.log = log;
	}

	public String logout() {
		this.user = null;
		this.log = false;
		return "index";
	}

	public String monProfil() {
		if (user.getClass() == Benevole.class) {
			benevoleView.setNextBenevole(Long.toString(this.user.getid()));
			return "profileBenevole";
		}
		if (this.user.getClass() == Association.class) {
			associationView
					.setNextAssociation(Long.toString(this.user.getid()));
			return "profileAssociation";
		}
		return "index";
	}

	public String myMissions() {
		// if (user.getClass() == Benevole.class){
		// benevoleView.setNextBenevole(Long.toString(this.user.getid()));
		// return "myMissionsBenevole";
		// }
		// if (this.user.getClass() == Association.class){
		// associationView.setNextAssociation(Long.toString(this.user.getid()));
		// return "myMissionsAssociation";
		// }
		return "myMissionsAssociation"; // index
	}
}
