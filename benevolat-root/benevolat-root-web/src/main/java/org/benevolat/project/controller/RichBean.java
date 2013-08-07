package org.benevolat.project.controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@SessionScoped
@ManagedBean
public class RichBean implements Serializable {

    private static final long serialVersionUID = -2403138958014741653L;
    private String name;

    public RichBean() {
        name = "Johny Hallyday";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
