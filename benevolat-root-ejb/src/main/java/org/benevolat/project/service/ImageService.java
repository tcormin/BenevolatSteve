package org.benevolat.project.service;

import java.util.List;

import javax.ejb.Stateless;

import org.benevolat.project.model.Evenement;
import org.benevolat.project.model.Image;

/**
 * SERVICE image
 * 
 * @author tcormin
 */
@Stateless
public class ImageService extends PersistenceService{
	
	/**
	* Enregistre l'image
	* @param image
	* @throws Exception
	*/
	public void setData(Image image) throws Exception {
		save(image);
		this.getLog().info("Image is registred with name: "+image.getName());
	}
	
	/**
	* Récupère toutes les images
	* @return
	* @throws Exception
	*/
	public List<Image> getData() throws Exception {
		List<Image> m = findAll(Image.class);
		this.getLog().info(m.size() + " image found");
		return m;
	}
	
	/**
	 * Met à jour l'image dans la BDD
	 * @param image
	 */
	public void update(Image image){
		Image i = this.getFromId(Image.class, image.getId().toString());
		i.setData(image.getData());
		i.setLength(image.getLength());
		i.setName(image.getName());
		
		this.getEm().flush();
	}
}