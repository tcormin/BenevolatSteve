package org.benevolat.project.controller;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.benevolat.project.model.Utilisateur;
import org.benevolat.project.service.UtilisateurService;

/**
 * CONTROLEUR page de login
 * 
 * @author tcormin
 */
@RequestScoped
@Named("loginView")
public class LoginView implements Serializable{

	/**
	 * serial version UID
	 */
	private static final long serialVersionUID = -5189819015740876947L;
	
	/**
	 * Service pour les utilisateurs
	 */
	@Inject
	private UtilisateurService utilisateurService;
	
	/**
	 * session Bean
	 */
	@Inject
	private SessionBean sessionBean;
	
	/**
	 * username entré par l'utilisateur
	 */
	private String username;
	
	/**
	 * password entré par l'utilisateur
	 */
	private String password;
	
	/** Constructeur */
	public LoginView(){
	}
	
	/**
	 * 
	 * @return le username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * 
	 * @param username
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * 
	 * @return le password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * 
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * Vérifie la paire username/password et récupère l'utilisateur dans la DB
	 * @return l'action "index"
	 */
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
	
	/**
	 * Effectue le logout et réinitialise le username/mdp
	 */
	public String logout(){
		this.username = "";
		this.password = "";
		this.sessionBean.logout();
		return "index";
	}
	

}
