package org.benevolat.project.controller;

import java.io.OutputStream;
import java.io.Serializable;
import java.util.Collection;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.benevolat.project.model.Association;
import org.benevolat.project.model.Mission;
import org.benevolat.project.service.AssociationService;
import org.benevolat.project.service.MissionService;

/**
 * CONTROLEUR profileAssociation
 * 
 * @author tcormin
 */
@SessionScoped
@Named("associationView")
public class AssociationView implements Serializable{

	/**
	 * serial version UID
	 */
	private static final long serialVersionUID = 9088185671638510312L;
	
	/**
	 * Service pour les associations
	 */
	@Inject
	private AssociationService associationService;
	
	/**
	 * Service pour les associations
	 */
	@Inject
	private MissionService missionService;
	
	@Inject
	private SessionBean sessionBean;
	
	/**
	 * Association que l'on va afficher
	 */
	private Association a;
	
	/**
	 * 
	 * @return l'association
	 */
	public Association getA() {
		return a;
	}

	/**
	 * 
	 * @param a
	 */
	public void setA(Association a) {
		this.a = a;
	}
	
	/**
	 * Permet de préciser quelle est l'association que l'on va afficher, en envoyant son id
	 * @param nextAssociation
	 */
	public void setNextAssociation(String nextAssociation) {
		this.a = associationService.getFromId(Association.class, nextAssociation);
	}
	
	/**
	 * Supprime l'association affichée de la DB
	 * @return l'action allAssociations
	 */
	public String delete(){
		associationService.removeUserFromId(this.a.getid().toString());
		return "allAssociations";
	}
	
	/**
	 * Permet d'afficher l'image de profil
	 * @param stream
	 * @param object
	 * @throws Exception
	 */
	public void paint(OutputStream stream, Object object) throws Exception {
		stream.write(a.getImage().getData());
        stream.close();
    }
	
	/**
	 * 
	 * @return les missions proposées à venir
	 * @throws Exception 
	 */
	public Collection<Mission> getMissions() throws Exception {
		return missionService.getMyMissionsIncompletes(a);
	}
	
	public boolean isMyProfile(){
		if(this.sessionBean.isLog()){
			return this.a.getid() == this.sessionBean.getUser().getid();
		}
		return false;
	}
}
