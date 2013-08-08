package org.benevolat.project.controller;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.benevolat.project.model.Image;
import org.benevolat.project.service.AssociationService;
import org.benevolat.project.service.BenevoleService;
import org.benevolat.project.service.EvenementService;
import org.benevolat.project.service.ImageService;
import org.richfaces.event.FileUploadEvent;
import org.richfaces.model.UploadedFile;

/**
 * CONTROLEUR ajouterImage
 * 
 * @author tcormin
 */
@SessionScoped
@Named("ajouterImageView")
public class AjouterImageView implements Serializable {
	
	@Inject
	ImageService imageService;
	
	@Inject
	EvenementService evenementService;

	@Inject
	AssociationService associationService;
	
	@Inject
	BenevoleService benevoleService;
	
	private String idObjet;
	private String typeObjet;
	private boolean downloaded = false;
	
	/** serialVersionUID */
	private static final long serialVersionUID = -94812409559510484L;

	public String getIdObjet() {
		return idObjet;
	}

	public void setIdObjet(String idObjet) {
		this.idObjet = idObjet;
		this.downloaded = false;
	}

	public String getTypeObjet() {
		return typeObjet;
	}

	public void setTypeObjet(String typeObjet) {
		this.typeObjet = typeObjet;
	}

	public void listener(FileUploadEvent event) throws Exception {
        UploadedFile item = event.getUploadedFile();

		Image i = new Image();
		i.setData(item.getData());
		i.setLength(item.getSize());
		i.setName(item.getName());
		
		if(this.typeObjet.compareTo("Evenement") == 0){
			evenementService.setImageToId(idObjet, i);
		}
		if(this.typeObjet.compareTo("Association") == 0){
			associationService.setImageToId(idObjet, i);
		}
		if(this.typeObjet.compareTo("Benevole") == 0){
			benevoleService.setImageToId(idObjet, i);
		}
		
		this.downloaded=true;
		//imageService.save(i);
    }

	public boolean isDownloaded() {
		return downloaded;
	}

	public void setDownloaded(boolean downloaded) {
		this.downloaded = downloaded;
	}
	
	public String profil(){
		return "profile" + this.typeObjet;
	}
}
