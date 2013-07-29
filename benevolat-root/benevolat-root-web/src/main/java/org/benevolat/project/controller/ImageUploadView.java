package org.benevolat.project.controller;

import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

import org.benevolat.project.model.Image;
import org.benevolat.project.service.ImageService;
import org.richfaces.event.FileUploadEvent;
import org.richfaces.model.UploadedFile;
 
/**
 * @author Ilya Shaikovsky
 */
@ManagedBean
@SessionScoped
public class ImageUploadView implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 7311880961111014627L;
	private ArrayList<Image> files = new ArrayList<Image>();
 
	@Inject
	ImageService imageService;
	
    public void paint(OutputStream stream, Object object) throws Exception {
        stream.write(imageService.getData().get(0).getData());
        stream.close();
    }
 
    public void listener(FileUploadEvent event) throws Exception {
        UploadedFile item = event.getUploadedFile();
        Image file = new Image();
        file.setLength(item.getData().length);
        file.setName(item.getName());
        file.setData(item.getData());
        //files.add(file);
        imageService.save(file);
    }
 
    public String clearUploadData() {
        files.clear();
        return null;
    }
 
    public int getSize() {
        if (getFiles().size() > 0) {
            return getFiles().size();
        } else {
            return 0;
        }
    }
 
    public long getTimeStamp() {
        return System.currentTimeMillis();
    }
 
    public ArrayList<Image> getFiles() {
        return files;
    }
 
    public void setFiles(ArrayList<Image> files) {
        this.files = files;
    }
}