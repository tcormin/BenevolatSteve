package org.benevolat.project.controller;

import java.io.Serializable;

<<<<<<< HEAD
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
=======
import javax.enterprise.context.RequestScoped;
>>>>>>> 014a35e93a94e6ef8b908689f9e45c5c29b6055d
import javax.inject.Inject;
import javax.inject.Named;

import org.benevolat.project.model.Association;
import org.benevolat.project.model.Benevole;
import org.benevolat.project.model.Utilisateur;
<<<<<<< HEAD
import org.benevolat.project.service.InitialisationService;
import org.benevolat.project.service.MissionService;
import org.richfaces.application.push.Session;

@SessionScoped
=======

@RequestScoped
>>>>>>> 014a35e93a94e6ef8b908689f9e45c5c29b6055d
@Named("sessionBean")
public class SessionBean implements Serializable {

	private static final long serialVersionUID = 745858547796786996L;

	private String searchText = "";

<<<<<<< HEAD
	@Inject
	private BenevoleView benevoleView;

	@Inject
	private AssociationView associationView;

=======
>>>>>>> 014a35e93a94e6ef8b908689f9e45c5c29b6055d
	@Inject
	private MyMissionsView myMissionsView;
	
	@Inject
<<<<<<< HEAD
	private InitialisationService initialisationService;

	@Inject
	private MissionService missionService;

	private Utilisateur user;
	private boolean log = false;
	private Long modify = (long) 0;

	public String getTitre() {
		return "Plateforme du Bénévolat";
	}

	@PostConstruct
	void init() throws Exception {
		// this.initialisationService.init();
	}

	public void destroy() {
		// TODO Auto-generated method stub

	}

	public Session getPushSession(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public void putPushSession(Session arg0) throws IllegalStateException {
		// TODO Auto-generated method stub

	}

	public void requeue(Session arg0) {
		// TODO Auto-generated method stub

	}

=======
	AssociationView associationView;

	Utilisateur user;
	boolean log = false;

	public String getTitre() {
		return "Plateforme du Bénévolat";
	}

>>>>>>> 014a35e93a94e6ef8b908689f9e45c5c29b6055d
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
<<<<<<< HEAD
=======
		System.out.println("J'ai trouvé un(e) : " + user.getClass());
>>>>>>> 014a35e93a94e6ef8b908689f9e45c5c29b6055d
		this.setLog(true);

		if (this.isAssociation()) {
			this.missionService.checkTerminees((Association) this.user);
		}
	}

	public boolean isLog() {
		return log;
	}

	public void setLog(boolean log) {
		this.log = log;
	}

<<<<<<< HEAD
	public Long getModify() {
		return modify;
	}

	public void setModify(Long modify) {
		this.modify = modify;
	}

	public boolean isAdministrateur() {
		if (this.user == null) {
			return false;
		}
		return this.user.getClass() == Administrateur.class;
	}

	public boolean isAssociation() {
		if (this.user == null) {
			return false;
		}
		return this.user.getClass() == Association.class;
	}

	public boolean isBenevole() {
		if (this.user == null) {
			return false;
		}
		return this.user.getClass() == Benevole.class;
	}

=======
>>>>>>> 014a35e93a94e6ef8b908689f9e45c5c29b6055d
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
<<<<<<< HEAD
		if (user.getClass() == Benevole.class) {
			myMissionsView.setNextBenevole(Long.toString(this.user.getid()));
			return "myMissionsBenevole";
		}
		if (this.user.getClass() == Association.class) {
			myMissionsView.setNextAssociation(Long.toString(this.user.getid()));
			return "myMissionsAssociation";
		}
		return "index";
	}

	public String action() {
		System.out.println("Remplir ici l'action souhaitée");
		return "allAssociations";
=======
		// if (user.getClass() == Benevole.class){
		// benevoleView.setNextBenevole(Long.toString(this.user.getid()));
		// return "myMissionsBenevole";
		// }
		// if (this.user.getClass() == Association.class){
		// associationView.setNextAssociation(Long.toString(this.user.getid()));
		// return "myMissionsAssociation";
		// }
		return "myMissionsAssociation"; // index
>>>>>>> 014a35e93a94e6ef8b908689f9e45c5c29b6055d
	}
}
