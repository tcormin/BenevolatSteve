package org.benevolat.project.model;

import java.io.Serializable;
import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Image de profil DOM
 * 
 * @author tcormin
 */
@Entity(name="image")
public class Image implements Serializable {

	/** serialVersionUID */
    private static final long serialVersionUID = -8192553629588066292L;

    /** id de l'image */
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    
    /** nom de l'image */
    private String name;
    
    /** mime de l'image */
    private String mime;
    
    /** longueur de l'image */
    private long length;
    
    /** données de l'image */
    @Column(length=65535)
    private byte[] data;

    /**
     * 
     * @return les données
     */
    public byte[] getData() {
        return data;
    }

    /**
     * 
     * @param data
     */
    public void setData(byte[] data) {
    	this.data = Arrays.copyOf(data, data.length);
    }

    /**
     * 
     * @return le nom
     */
    public String getName() {
        return name;
    }
    
    /**
     * 
     * @param name
     */
    public void setName(String name) {
        int extDot = name.lastIndexOf('.');
        if (extDot > 0) {
            String extension = name.substring(extDot + 1);
            if ("bmp".equals(extension)) {
                mime = "image/bmp";
            } else if ("jpg".equals(extension)) {
                mime = "image/jpeg";
            } else if ("gif".equals(extension)) {
                mime = "image/gif";
            } else if ("png".equals(extension)) {
                mime = "image/png";
            } else {
                mime = "image/unknown";
            }
        }
    }

    /**
     * 
     * @return la longueur
     */
    public long getLength() {
        return length;
    }

    /**
     * 
     * @param length
     */
    public void setLength(long length) {
        this.length = length;
    }

    /**
     * 
     * @return le mime
     */
    public String getMime() {
        return mime;
    }

    /**
     * 
     * @return l'id
     */
	public Long getId() {
		return id;
	}

	/**
	 * 
	 * @param id
	 */
	public void setId(Long id) {
		this.id = id;
	}
    
    
}