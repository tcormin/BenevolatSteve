package org.benevolat.project.service;

import java.util.List;

import javax.ejb.Stateless;

import org.benevolat.project.model.Image;

@Stateless
public class ImageService extends PersistenceService{
	
	   public void setData(Image image) throws Exception {
		   save(image);
		   log.info("Image is registred with name: "+image.getName());
	   }
	   
	   public List<Image> getData() throws Exception {
		   List<Image> m = findAll(Image.class);
		   log.info(m.size() + " image found");
		   return m;
	   }
}