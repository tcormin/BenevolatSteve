package org.benevolat.project.controller;

import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.benevolat.project.model.Image;
import org.benevolat.project.service.ImageService;
import org.richfaces.event.FileUploadEvent;
import org.richfaces.model.UploadedFile;
 
/**
 * @author Ilya Shaikovsky, tcormin
 */
@RequestScoped
<<<<<<< HEAD
@Named("imageUpload")
=======
>>>>>>> 014a35e93a94e6ef8b908689f9e45c5c29b6055d
public class ImageUploadView implements Serializable {
    
	/**
	 * serial version UID
	 */
	private static final long serialVersionUID = 7311880961111014627L;
	
	/**
	 * Liste des images
	 */
	private ArrayList<Image> files = new ArrayList<Image>();
 
	/**
	 * Service pour les images
	 */
	@Inject
	private ImageService imageService;
	
	/**
	 * Permet d'afficher les images
	 * @param stream
	 * @param object
	 * @throws Exception
	 */
    public void paint(OutputStream stream, Object object) throws Exception {
        stream.write(imageService.getData().get(0).getData());
        stream.close();
    }
 
    /**
     * Permet l'upload
     * @param event
     * @throws Exception
     */
    public void listener(FileUploadEvent event) throws Exception {
        UploadedFile item = event.getUploadedFile();
        Image file = new Image();
        file.setLength(item.getData().length);
        file.setName(item.getName());
        file.setData(item.getData());
        //files.add(file);
        imageService.save(file);
    }
 
    /**
     * Supprime les images téléchargées
     * @return
     */
    public String clearUploadData() {
        files.clear();
        return null;
    }
 
    /**
     * 
     * @return la taille de l'image
     */
    public int getSize() {
        if (getFiles().size() > 0) {
            return getFiles().size();
        } else {
            return 0;
        }
    }
 
    /**
     * 
     * @return le timeStamp
     */
    public long getTimeStamp() {
        return System.currentTimeMillis();
    }
    /**
     * 
     * @return toutes les images
     */
    public ArrayList<Image> getFiles() {
        return files;
    }
	 /**
	  * 
	  * @param files
	  */
    public void setFiles(ArrayList<Image> files) {
        this.files = files;
    }
}