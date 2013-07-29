package org.benevolat.project.controller;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.benevolat.project.model.Utilisateur;
import org.benevolat.project.service.UtilisateurService;

@RequestScoped
@Named("loginView")
public class loginView implements Serializable{

	private static final long serialVersionUID = -5189819015740876947L;
	
	@Inject
	private UtilisateurService utilisateurService;
	@Inject
	private SessionBean sessionBean;
	private String username;
	private String password;
	
	public loginView(){
	}
	
	public String login() {
		
		Utilisateur user = this.utilisateurService.getUserFromId(username, password);
		
		if(user == null){
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Mauvais nom d'utilisateur ou mot de passe!", "Mauvais nom d'utilisateur ou mot de passe!"));
		}
		else{
			sessionBean.setUser(user);
			return "index";
		}
		return "";
    }

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public void logout(){
		this.username = "";
		this.password = "";
		this.sessionBean.logout();
	}
	

}
