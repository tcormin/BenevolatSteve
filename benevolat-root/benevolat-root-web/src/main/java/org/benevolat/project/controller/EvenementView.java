package org.benevolat.project.controller;

import java.io.OutputStream;
import java.io.Serializable;

<<<<<<< HEAD
import javax.enterprise.context.SessionScoped;
=======
import javax.enterprise.context.RequestScoped;
>>>>>>> 014a35e93a94e6ef8b908689f9e45c5c29b6055d
import javax.inject.Inject;
import javax.inject.Named;

import org.benevolat.project.model.Evenement;
import org.benevolat.project.service.EvenementService;
import org.benevolat.project.service.ImageService;

<<<<<<< HEAD
/**
 * CONTROLEUR profileEvenement
 * 
 * @author tcormin
 */
@SessionScoped
=======
@RequestScoped
>>>>>>> 014a35e93a94e6ef8b908689f9e45c5c29b6055d
@Named("evenementView")
public class EvenementView implements Serializable{

	/**
	 * serial version UID
	 */
	private static final long serialVersionUID = 1625032344132684042L;
	
	/**
	 * Service pour les événements
	 */
	@Inject
	private EvenementService evenementService;
	/**
	 * Service pour les images
	 */
	@Inject
	private ImageService imageService;
	
	/**
	 * Evenement que l'on va afficher
	 */
	private Evenement e;

	/**
	 * 
	 * @return l'événement
	 */
	public Evenement getE() {
		return e;
	}
	/**
	 * 
	 * @param e
	 */
	public void setE(Evenement e) {
		this.e = e;
	}
	/**
	 * Permet de préciser quelle est l'événement que l'on va afficher, en envoyant son id
	 * @param nextEvenement
	 */
	public void setNextEvenement(String nextEvenement) {
		this.e = evenementService.getFromId(Evenement.class, nextEvenement);
	}

	public void test(){
		String s = evenementService.getFromId(Evenement.class, "1").getNom();
	}
<<<<<<< HEAD

	/**
	 * Supprime le'événement affiché de la DB
	 * @return l'action allEvenements
	 */
	public String delete(String id){
=======
	
	public String delete(String id){
		System.out.println("Suppression de l'evenement "+ this.e.getid().toString());
>>>>>>> 014a35e93a94e6ef8b908689f9e45c5c29b6055d
		evenementService.removeFromId(Evenement.class, this.e.getid().toString());
		return "allEvenements";
	}
	
	/**
	 * Permet d'afficher l'image de profil
	 * @param stream
	 * @param object
	 * @throws Exception
	 */
	public void paint(OutputStream stream, Object object) throws Exception {
		stream.write(e.getImage().getData());
        stream.close();
    }
}