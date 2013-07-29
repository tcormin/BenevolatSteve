package org.benevolat.project.controller;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.benevolat.project.model.Evenement;
import org.benevolat.project.model.Image;
import org.benevolat.project.service.EvenementService;
import org.benevolat.project.service.ImageService;
import org.richfaces.event.FileUploadEvent;
import org.richfaces.model.UploadedFile;

@RequestScoped
@Named("newEvenementView")
public class NewEvenementView implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1127340180998168006L;

	@Inject
	private EvenementService evenementService;
	@Inject
	private ImageService imageService;
	
	private Evenement e;
	private Image image;
	Long imageId;
	private String progressString = "Fill the form please";
	private String success;
	
	public NewEvenementView(){
		
		e = new Evenement();
		image = new Image();
		image.setLength(100);
		image.setName("Hublot");
	}
	
	public void record() {
		Image i = new Image();
		//i.setData(imageService.getFromId(Image.class, String.valueOf(imageId)).getData());
		this.e.setImage(i);
		this.evenementService.save(e);
		this.success = "ok";
		if(!this.success.isEmpty()){
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Enregistrement réussi!", "Enregistrement réussi!"));
		}
		// return "profileAssociation";
    }

	public void listener(FileUploadEvent event) throws Exception {
        UploadedFile item = event.getUploadedFile();
        //file.setLength(item.getData().length);
//        file.setName(item.getName());
//        file.setData(item.getData());
        imageId = image.getId();
        image.setData(item.getData());
        imageService.save(image);
    }
	
	public String getProgressString() {
		return progressString;
	}

	public void setProgressString(String progressString) {
		this.progressString = progressString;
	}

	public String getSuccess() {
		return success;
	}

	public void setSuccess(String success) {
		this.success = success;
	}

	public Evenement getE() {
		return e;
	}

	public void setE(Evenement e) {
		this.e = e;
	}
	
	

}
