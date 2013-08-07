package org.benevolat.project.controller;

import java.io.OutputStream;
import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.benevolat.project.model.Evenement;
import org.benevolat.project.service.EvenementService;
import org.benevolat.project.service.ImageService;

@RequestScoped
@Named("evenementView")
public class EvenementView implements Serializable{

	private static final long serialVersionUID = 1625032344132684042L;
	
	@Inject
	private EvenementService evenementService;
	@Inject
	private ImageService imageService;
	
	private Evenement e;

	public Evenement getE() {
		return e;
	}

	public void setE(Evenement e) {
		this.e = e;
	}
	
	public void setNextEvenement(String nextEvenement) {
		this.e = evenementService.getFromId(Evenement.class, nextEvenement);
	}
	
	public void test(){
		System.out.println("Je suis là.");
		String s = evenementService.getFromId(Evenement.class, "1").getNom();
		System.out.println(s);
	}
	
	public String delete(String id){
		System.out.println("Suppression de l'evenement "+ this.e.getid().toString());
		evenementService.removeFromId(Evenement.class, this.e.getid().toString());
		return "allEvenements";
	}
	
	public void paint(OutputStream stream, Object object) throws Exception {
		stream.write(imageService.getData().get(0).getData());
        stream.close();
    }
}
