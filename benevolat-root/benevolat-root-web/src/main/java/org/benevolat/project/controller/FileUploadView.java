package org.benevolat.project.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import org.benevolat.project.model.Fichier;
import org.richfaces.event.FileUploadEvent;
import org.richfaces.model.UploadedFile;

public class FileUploadView implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -119016289831144009L;

	 private ArrayList<Fichier> files = new ArrayList<Fichier>();
	 
	    public void paint(OutputStream stream, Object object) throws IOException {
	        stream.write(getFiles().get((Integer) object).getData());
	        stream.close();
	    }
	 
	    public void listener(FileUploadEvent event) throws Exception {
	        UploadedFile item = event.getUploadedFile();
	        Fichier file = new Fichier();
	        file.setLength(item.getData().length);
	        file.setName(item.getName());
	        file.setData(item.getData());
	        files.add(file);
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
	 
	    public ArrayList<Fichier> getFiles() {
	        return files;
	    }
	 
	    public void setFiles(ArrayList<Fichier> files) {
	        this.files = files;
	    }
}
