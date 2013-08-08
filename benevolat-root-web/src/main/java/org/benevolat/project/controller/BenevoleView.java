package org.benevolat.project.controller;

import java.io.OutputStream;
import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.benevolat.project.model.Benevole;
import org.benevolat.project.service.BenevoleService;

/**
 * CONTROLEUR profileBenevole
 * 
 * @author tcormin
 */

@SessionScoped
@Named("benevoleView")
public class BenevoleView implements Serializable{

	/**
	 * serial version UID
	 */
	private static final long serialVersionUID = 3733912007149394439L;
	
	/**
	 * Service pour les bénévoles
	 */
	@Inject
	private BenevoleService benevoleService;
	
	@Inject
	private SessionBean sessionBean;
	
	/**
	 * Benevole que l'on va afficher
	 */
	private Benevole b;
	
	/**
	 * 
	 * @return le bénévole
	 */
	public Benevole getB() {
		return b;
	}

	/**
	 * 
	 * @param b
	 */
	public void setB(Benevole b) {
		this.b = b;
	}
	/**
	 * Permet de préciser quelle est le bénévole que l'on va afficher, en envoyant son id
	 * @param nextBenevole
	 */
	public void setNextBenevole(String nextBenevole) {
		this.b = benevoleService.getFromId(Benevole.class, nextBenevole);
	}
	/**
	 * Supprime le bénévole affichée de la DB
	 * @return l'action allBenevoles
	 */
	public String delete(){
		benevoleService.removeUserFromId(this.b.getid().toString());
		return "allBenevoles";
	}
	
	/**
	 * Permet d'afficher l'image de profil
	 * @param stream
	 * @param object
	 * @throws Exception
	 */
	public void paint(OutputStream stream, Object object) throws Exception {
		stream.write(b.getImage().getData());
        stream.close();
    }
	
	public boolean isMyProfile(){
		if(this.sessionBean.isLog()){
			return this.b.getid() == this.sessionBean.getUser().getid();
		}
		return false;
	}
}
